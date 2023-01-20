
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

class Game1 extends JFrame {

    public Game1() {
        // setSize(1000, 750);  <---- do not do it
        // setResizable(false); <----- do not do it either, unless any good reason

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Online First Person Shooter");

        ImageIcon image = new ImageIcon("src/gapabrikroti/resources/image/indonesia_map.png");
        JLabel label = new JLabel(image);
        JScrollPane scrollPane = new JScrollPane(label);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Game1().setVisible(true);
            }
        });

    }
}
