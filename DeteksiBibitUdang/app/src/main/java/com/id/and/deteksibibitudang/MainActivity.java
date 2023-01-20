package com.id.and.deteksibibitudang;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.sdsmdg.tastytoast.TastyToast;

import org.opencv.android.OpenCVLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    TextView btnJumlahUdang;
    Button cmdCameraOpen;
    Button cmdRealTimeCamera;
    ImageView imgViewCrab;
    ImageView imgViewCrabBefore;
    ImageView imgViewCrabBiner;
    private String userChoosenTask;
    private Bitmap thumbnail;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    int[] array;
    String hasilKonversi = "";
    int sisa;
    int top = -1;
    int input;

    static {
        if (!OpenCVLoader.initDebug()) {
            Log.wtf(TAG, "OpenCV not loaded");
        } else {
            Log.wtf(TAG, "OpenCV loaded");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgViewCrab = (ImageView) findViewById(R.id.ImgViewCrab);
        imgViewCrabBefore = (ImageView) findViewById(R.id.ImgViewCrabBefore);
        imgViewCrabBiner = (ImageView) findViewById(R.id.ImgViewCrabBiner);
        cmdCameraOpen = (Button) findViewById(R.id.CmdCameraOpen);
        cmdCameraOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();
                //executeImage();
            }
        });
        cmdRealTimeCamera = (Button) findViewById(R.id.CmdOpenBlobDetection);
        cmdRealTimeCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ColorBlobDetectionActivity.class));
            }
        });


    }

    private void executeImage() {
        boolean sukses = false;
        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/crab/";
        File file = new File(rootPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        BitmapDrawable drawable = (BitmapDrawable) imgViewCrab.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        Date date = new Date();
        String name = "kunci";
        File image = new File(rootPath, name + date + ".PNG");
        sukses = false;

        FileOutputStream outStream;

        try {
            outStream = new FileOutputStream(image);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);

            outStream.flush();
            outStream.close();
            sukses = true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (sukses) {
            Toast.makeText(getApplicationContext(), "Perhitungan Object Berhasil", Toast.LENGTH_LONG);
        } else {
            Toast.makeText(getApplicationContext(), "Gagal Menyimpan gambar", Toast.LENGTH_LONG);
        }

    }

    private void selectImage() {
        final CharSequence[] items = {"Ambil Foto Dengan Camera", "Memilih Photo dari Library",
                "Kembali"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Tambahkan Poto!!");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int item) {
                boolean result = Utility.checkPermission(MainActivity.this);

                if (items[item].equals("Ambil Foto Dengan Camera")) {
                    userChoosenTask = "Ambil Foto Dengan Camera";
                    if (result)
                        cameraIntent();
                } else if (items[item].equals("Memilih Photo dari Library")) {
                    userChoosenTask = "Memilih Photo dari Library";
                    if (result)
                        galleryIntent();
                } else if (items[item].equals("Kembali")) {
                    dialogInterface.dismiss();
                }
            }
        });
        builder.show();
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent.createChooser(intent, "Pilih File"), SELECT_FILE);

    }

    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {

        thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;

        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //tambilkan image sebelum di ekseskusi
        imgViewCrabBefore.setImageBitmap(thumbnail);

        //convert to grayscale
        imgViewCrab.setImageBitmap(toGrayScale(thumbnail));

        boolean sukses = false;
        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/crab/";
        File file = new File(rootPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        BitmapDrawable drawable = (BitmapDrawable) imgViewCrab.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        //convert to binary
        Bitmap binaryBitmap = toBinary(bitmap);
        imgViewCrabBiner.setImageBitmap(binaryBitmap);

        //menyiapkan imgView untuk memanggil hasil binar image
        BitmapDrawable drawableBiner = (BitmapDrawable) imgViewCrabBiner.getDrawable();
        Bitmap bitmapBlob = drawableBiner.getBitmap();

        //count blob
        try {
            countBlob(bitmapBlob);


            Date date = new Date();
            int numb = 0;
            String name = "kunci" + numb + 1;
            File image = new File(rootPath, name + ".PNG");
            sukses = false;

            FileOutputStream outStream;
            try {
                outStream = new FileOutputStream(image);
                binaryBitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);

                outStream.flush();
                outStream.close();
                sukses = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (sukses) {
                Toast.makeText(getApplicationContext(), "Perhitungan Object Berhasil",
                        Toast.LENGTH_LONG).show();


            } else {
                Toast.makeText(getApplicationContext(), "Gagal Menyimpan gambar",
                        Toast.LENGTH_LONG).show();
            }

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Gagal Menyimpan gambar",
                    Toast.LENGTH_LONG).show();
        }
    }

    private Bitmap toBinary(Bitmap bmpOriginal) {
        int width, height, threshold;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();
        threshold = 200;

        //final Bitmap bmpBinary = null;
        Bitmap bmpBinary = Bitmap.createBitmap(bmpOriginal);

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                //get one pixel color
                int pixel = bmpOriginal.getPixel(x, y);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);

                //get grayscale value
                int gray = (int) (red * 0.3 + green * 0.59 + blue * 0.11);

                //get binary value
                if (gray < threshold) {
                    bmpBinary.setPixel(x, y, 0xFF000000);
                } else {
                    bmpBinary.setPixel(x, y, 0xFFFFFFFF);
                }
            }
        }
        return bmpBinary;
    }

    private Bitmap toGrayScale(Bitmap bmpOriginal) {
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayScale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bmpGrayScale);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0);
        ColorMatrixColorFilter colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);
        paint.setColorFilter(colorMatrixColorFilter);
        c.drawBitmap(bmpOriginal, 0, 0, paint);

        return bmpGrayScale;
    }

    private void onSelectFromGalleryResult(Intent data) {

        thumbnail = null;
        if (data != null) {
            try {
                thumbnail = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //tambilkan image sebelum di ekseskusi
        imgViewCrabBefore.setImageBitmap(thumbnail);

        //convert to grayscale
        imgViewCrab.setImageBitmap(toGrayScale(thumbnail));

        boolean sukses = false;
        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/crab/";
        File file = new File(rootPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        //menyiapkan imgView untuk memanggil hasil grayscale
        BitmapDrawable drawable = (BitmapDrawable) imgViewCrab.getDrawable();
        Bitmap bitmap = drawable.getBitmap();

        //convert to binary
        Bitmap binaryBitmap = toBinary(bitmap);
        imgViewCrabBiner.setImageBitmap(binaryBitmap);

        //menyiapkan imgView untuk memanggil hasil binar image
        BitmapDrawable drawableBiner = (BitmapDrawable) imgViewCrabBiner.getDrawable();
        Bitmap bitmapBlob = drawableBiner.getBitmap();

        //count blob
        try {
            countBlob(bitmapBlob);


            Date date = new Date();
            int numb = 0;
            String name = "kunci" + numb + 1;
            File image = new File(rootPath, name + ".PNG");
            sukses = false;

            FileOutputStream outStream;
            try {
                outStream = new FileOutputStream(image);
                binaryBitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);

                outStream.flush();
                outStream.close();
                sukses = true;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            if (sukses) {
                Toast.makeText(getApplicationContext(), "Perhitungan Object Berhasil",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Gagal Menyimpan gambar",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Gagal Menyimpan gambar",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void crabCountImage() {

        //Create a Pint Object for drawing with
        Paint myRectPaint = new Paint();
        myRectPaint.setStrokeWidth(3);
        myRectPaint.setColor(Color.RED);
        myRectPaint.setStyle(Paint.Style.STROKE);

        //Create a Canvas Object for Drawing on
        Bitmap tempBitmap = Bitmap.createBitmap(thumbnail.getWidth(), thumbnail.getHeight(), Bitmap.Config.RGB_565);
        Canvas tempCanvas = new Canvas(tempBitmap);
        tempCanvas.drawBitmap(thumbnail, 0, 0, null);

        //Count the Crab

    }

    private void countBlob(Bitmap bmpOriginal) {
        int jumlahCrab = 0, width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();
        int No_of_Objects = 0;
        int Index, Mark;
        int[] Connected = new int[(width * height)];
        int[] linked;
        int[][] Neighbors = new int[width][height];

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                int pixel = bmpOriginal.getPixel(x, y);
                if (pixel != Color.WHITE) {
                    No_of_Objects = No_of_Objects + 1;
                    Index = ((y - 1) * width + x);
                    Connected[Index] = jumlahCrab;
                    while (Index < 0) {
                        pixel = Color.WHITE;
                        Neighbors[x][y] = jumlahCrab;
                        Connected[Index] = jumlahCrab;
                    }
                    jumlahCrab++;
                }
            }
        }

        Toast.makeText(this, "dalam Decimal : " + String.valueOf(jumlahCrab), Toast.LENGTH_LONG).show();
        input = jumlahCrab;
        biner(input);
    }

    private void setStack(int a) {
        array = new int[a];
    }

    private void push(int d) {
        if (d >= 1) {
            sisa = d % 2;
            d = d / 2;
            array[++top] = sisa;
            push(d);
        }
    }

    private String pop() {
        if (top >= 0) {
            hasilKonversi += array[top];
            array[top--] = 0;
            return pop();
        }
        return hasilKonversi;
    }

    public void biner(int input) {
        setStack(input);
        push(input);
        TastyToast.makeText(getApplicationContext(), "dalam Biner : " + pop(), TastyToast.LENGTH_SHORT, TastyToast.INFO);
    }



}