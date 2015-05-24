import javax.swing.*;
import java.awt.*;

/**
 * Created by Marli on 5/23/2015.
 */
public class game {
    private JFrame frame;
    private JPanel panel;

    public static void main(String[] args){
        new game().run();
    }

    private void run(){
        //basic jframe stuff
        frame = new JFrame("Gobblet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //basic panel stuff
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("HIIIII"));
        Container containGrid = new Container();
        JPanel[][] panelHolder = new JPanel[4][4];
        containGrid.setLayout(new GridLayout(4, 4));

        for(int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                ImageIcon icon = new ImageIcon("C:\\Users\\Marli\\Documents\\Code-Day\\BeigeGobbletSize1.jpg");
                JLabel lab = new JLabel(icon);
                JPanel pan = new JPanel();
                pan.add(lab);
                panelHolder[m][n] = pan;
                containGrid.add(panelHolder[m][n]);
            }
        }

        try {
            ImageIcon icon = new ImageIcon("C:\\Users\\Marli\\Documents\\Code-Day\\BeigeGobbletSize1.jpg");
            JLabel lab = new JLabel(icon);
            panel.add(lab);
           // panel.add(lab);
        } catch (NullPointerException npe){
            npe.printStackTrace();
            System.out.println("Failed");
        }
        //panel.add(containGrid);
        panel.add(new JLabel("BYYEEE"));
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(625, 950);
        frame.setLocation(375, 55);
    }

    /*
    compontent.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            System.outsgfjlksf
        }
    });
    */

}
