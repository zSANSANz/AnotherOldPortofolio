/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package svmradikalmetode.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Imam
 */
public class translate {

    public String callURL(String teks) throws JSONException {
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        JSONArray hasil = null;
        try {
            URL url = new URL("https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20160727T081549Z.6deba8af666fe221.4a7eb869272439d761daf6d75223dfe9af3246d3&text=" + teks + "&lang=en-id");
             urlConn = url.openConnection();
            if (urlConn != null) {
                urlConn.setReadTimeout(60 * 1000);
            }
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                if (bufferedReader != null) {
                    int cp;
                    while ((cp = bufferedReader.read()) != -1) {
                        sb.append((char) cp);
                    }
                    bufferedReader.close();
                }
            }
            in.close();

        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:" + teks, e);
        }
        String jsonStr = sb.toString();
        JSONObject jsonObj;
        try {
            jsonObj = new JSONObject(jsonStr);
            hasil = jsonObj.getJSONArray("text");
        } catch (JSONException ex) {
            Logger.getLogger(translate.class.getName()).log(Level.SEVERE, null, ex);
        }

        return hasil.get(0).toString();

    }
}
