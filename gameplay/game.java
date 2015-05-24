import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        //testing mouse listener
        JLabel hello = new JLabel("Hello Bitches");
        panel.add(hello);
        hello.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("WTF IS THIS SHIT MARLI");
            }
        });

        Container containGrid = new Container();
        JPanel[][] panelHolder = new JPanel[4][4];
        GridLayout gridLayout = new GridLayout(4, 4);
        containGrid.setLayout(gridLayout);

        for(int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                panelHolder[m][n] = new JPanel();
                containGrid.add(panelHolder[m][n]);
            }
        }

        for(int k = 0; k < 4; k++){
            for(int h= 0; h < 4; h++){
                ImageIcon icon = new ImageIcon(System.getProperty("user.dir") +  "\\BlankTile.jpg");
                JLabel lab = new JLabel(icon);
                panelHolder[k][h].add(lab);

                System.out.println(panelHolder[k][h].getSize());
            }
        }

        panel.add(containGrid);
        panel.add(new JLabel("BYYEEE"));
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(625, 950);
        frame.setLocation(375, 55);
    }

}
