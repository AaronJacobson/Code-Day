import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Marli on 5/23/2015.
 */
public class game {
    //general ui feilds
    private JFrame frame;
    private JPanel panel;

    //enemy side
    public Container enemySide;
    public tile[] enemyTile;
    public JPanel[] panelHolderEnemy;

    //home side
    public Container homeSide;
    public tile[] homeTile;
    public JPanel[] panelHolderHome;

    //grid
    public Container containGrid;
    public JPanel[][] panelHolderBoard;
    public tile[][] tileBoard;

    //clickable
    public int height;
    public int width;

    //constants
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

        //Enemy side layout basic
        enemySide = new Container();
        enemySide.setLayout(new BoxLayout(enemySide, BoxLayout.X_AXIS));
        enemyTile = new tile[NUMBER_OF_PLAYER_TILES];
        panelHolderEnemy = new JPanel[NUMBER_OF_PLAYER_TILES];
        for(int e = 0; e< NUMBER_OF_PLAYER_TILES; e++){
            enemyTile[e] = new tile();
            enemyTile[e].whatCups.add(new cup(1,false));
            enemyTile[e].whatCups.add(new cup(2,false));
            enemyTile[e].whatCups.add(new cup(3, false));
            enemyTile[e].whatCups.add(new cup(4, false));
            panelHolderEnemy[e] = new JPanel();
            panelHolderEnemy[e].add(enemyTile[e].getBiggestCup());
            enemySide.add(panelHolderEnemy[e]);
        }
        panel.add(enemySide);

        containGrid = new Container();
        panelHolderBoard = new JPanel[HEIGHT_OF_BOARD][WIDTH_OF_BOARD];
         tileBoard = new tile[HEIGHT_OF_BOARD][WIDTH_OF_BOARD];
        GridLayout gridLayout = new GridLayout(HEIGHT_OF_BOARD, WIDTH_OF_BOARD);
        containGrid.setLayout(gridLayout);

        for( int m = 0; m < HEIGHT_OF_BOARD; m++) {
            for (int n = 0; n < WIDTH_OF_BOARD; n++) {
                tileBoard[m][n] = new tile();
                panelHolderBoard[m][n] = new JPanel();
                JLabel img = tileBoard[m][n].getBiggestCup();
                panelHolderBoard[m][n].add(img);
                height = m;
                width = n;
                img.addMouseListener(new MouseAdapterSpecial(m, n));

                System.out.println("count " + panelHolderBoard[m][n].getComponentCount());
                containGrid.add(panelHolderBoard[m][n]);

            }
        }
        panel.add(containGrid);

        //Home side layout basic
        homeSide = new Container();
        homeSide.setLayout(new BoxLayout(homeSide, BoxLayout.X_AXIS));
        homeTile = new tile[NUMBER_OF_PLAYER_TILES];
        panelHolderHome = new JPanel[NUMBER_OF_PLAYER_TILES];
        for(int e = 0; e< NUMBER_OF_PLAYER_TILES; e++){
            homeTile[e] = new tile(4);
            homeTile[e].whatCups.add(new cup(1,true));
            homeTile[e].whatCups.add(new cup(2,true));
            homeTile[e].whatCups.add(new cup(3,true));
            homeTile[e].whatCups.add(new cup(4,true));
            panelHolderHome[e] = new JPanel();
            panelHolderHome[e].add(homeTile[e].getBiggestCup());
            homeSide.add(panelHolderHome[e]);
        }
        panel.add(homeSide);
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(650, 1000);
    }

    private class MouseAdapterSpecial extends MouseAdapter {
        private int height;
        private int width;

        public MouseAdapterSpecial(int currentHeight, int currentWidth){
            super();
            height = currentHeight;
            width = currentWidth;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("Clicked");
            System.out.println("count2a " +  panelHolderBoard[height][width].getComponentCount());
            panelHolderBoard[height][width].removeAll();
            System.out.println("count2b " +  panelHolderBoard[height][width].getComponentCount());
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlackGobbletSize4.jpg");
            JLabel lab = new JLabel(icon);
            panelHolderBoard[height][width].add(lab);
            SwingUtilities.updateComponentTreeUI(frame);
            //

        }

    }

}

