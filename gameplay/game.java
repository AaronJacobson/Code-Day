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
    private static final int NUMBER_OF_PLAYER_TILES = 3;
    private static final int WIDTH_OF_BOARD = 4;
    private static final int HEIGHT_OF_BOARD = 4;

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
        Container enemySide = new Container();
        enemySide.setLayout(new BoxLayout(enemySide, BoxLayout.X_AXIS));
        tile[] enemyTile = new tile[NUMBER_OF_PLAYER_TILES];
        Container[] panelHolderEnemy = new Container[NUMBER_OF_PLAYER_TILES];
        for(int e = 0; e< NUMBER_OF_PLAYER_TILES; e++){
            enemyTile[e] = new tile(4);
            panelHolderEnemy[e] = new JPanel();
            panelHolderEnemy[e].add(enemyTile[e].getBiggestTile());
            enemySide.add(panelHolderEnemy[e]);
        }
        panel.add(enemySide);
        /*JLabel hello = new JLabel("Hello Bitches");
        panel.add(hello);
        hello.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("I clicked Marli");
            }
        });*/

        Container containGrid = new Container();
        JPanel[][] panelHolderBoard = new JPanel[4][4];
        tile[][] tileBoard = new tile[4][4];
        GridLayout gridLayout = new GridLayout(4, 4);
        containGrid.setLayout(gridLayout);

        for(int m = 0; m < 4; m++) {
            for (int n = 0; n < 4; n++) {
                tileBoard[m][n] = new tile();
                panelHolderBoard[m][n] = new JPanel();
                panelHolderBoard[m][n].add(tileBoard[m][n].getBiggestTile());
                containGrid.add(panelHolderBoard[m][n]);
            }
        }
        panel.add(containGrid);

        Container homeSide = new Container();
        homeSide.setLayout(new BoxLayout(homeSide, BoxLayout.X_AXIS));
        tile[] homeTile = new tile[NUMBER_OF_PLAYER_TILES];
        Container[] panelHolderHome = new Container[NUMBER_OF_PLAYER_TILES];
        for(int e = 0; e< NUMBER_OF_PLAYER_TILES; e++){
            homeTile[e] = new tile(4);
            panelHolderHome[e] = new JPanel();
            panelHolderHome[e].add(homeTile[e].getBiggestTile());
            homeSide.add(panelHolderHome[e]);
        }
        panel.add(homeSide);
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(625, 975);
        frame.setLocation(375, 55);
    }

}
