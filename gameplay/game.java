import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
    public boolean anythingSelected;
    public JLabel selected;
    public cup movingCup;

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
            JLabel hello = enemyTile[e].getBiggestCup();
            hello.addMouseListener(new MouseAdapterSpecial(hello, panelHolderEnemy[e]));
            panelHolderEnemy[e].add(hello);
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
                    if(panelHolderBoard[m][n] != null) System.out.println("Yay");
                    if(panelHolderBoard[m][n] == null) System.out.println("Numm");
                    JLabel img = tileBoard[m][n].getBiggestCup();
                    panelHolderBoard[m][n].add(img);
                    height = m;
                    width = n;
                    img.addMouseListener(new MouseAdapterSpecial(img, panelHolderBoard[m][n]));
                    containGrid.add(panelHolderBoard[m][n]);}
        }
        panel.add(containGrid);

        //Home side layout basic
        homeSide = new Container();
        homeSide.setLayout(new BoxLayout(homeSide, BoxLayout.X_AXIS));
        homeTile = new tile[NUMBER_OF_PLAYER_TILES];
        panelHolderHome = new JPanel[NUMBER_OF_PLAYER_TILES];
        for(int e = 0; e< NUMBER_OF_PLAYER_TILES; e++){
            homeTile[e] = new tile();
            homeTile[e].whatCups.add(new cup(1,true));
            homeTile[e].whatCups.add(new cup(2,true));
            homeTile[e].whatCups.add(new cup(3,true));
            homeTile[e].whatCups.add(new cup(4,true));
            panelHolderHome[e] = new JPanel();
            JLabel hi = homeTile[e].getBiggestCup();
            hi.addMouseListener(new MouseAdapterSpecial(hi, panelHolderHome[e]));
            panelHolderHome[e].add(hi);

            homeSide.add(panelHolderHome[e]);
        }
        panel.add(homeSide);
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(650, 1000);
        frame.setLocation(600, 0);
    }

    public int[] getPanelPosition(JPanel el){
        int[] point = new int[2];
        System.out.println("Actual " + el );
        for(int y = 0; y < HEIGHT_OF_BOARD; y++){
            for(int x = 0; x < WIDTH_OF_BOARD; x++){
                if(panelHolderBoard[y][x] == el){
                    point = new int[]{y, x};
                }
            }
        }
        for(int z = 0; z < panelHolderHome.length; z ++){
            if(panelHolderHome[z] == el){
                point = new int[]{z};
            }
        }
        return point;
    }

    private class MouseAdapterSpecial extends MouseAdapter {
        private JLabel label;
        private JPanel p;

        public MouseAdapterSpecial(JLabel label, JPanel p){
            super();
            this.label = label;
            this.p = p;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println("CLICKED");
            if (selected == null) {
                selected = label;
                int[] thePoints = getPanelPosition(p);
               /*
                if(thePoints.length > 1) {
                    tile initialTile = tileBoard[thePoints[0]][thePoints[1]];
                    //movingCup = initialTile.whatCups.get(initialTile.whatCups.size()-1);
                    //initialTile.whatCups.remove(initialTile.whatCups.size() - 1);
                } else {
                    tile initialTile = homeTile[thePoints[0]];
                    for (int i = 0; i < initialTile.whatCups.size(); i++) {

                    }
                    //movingCup = initialTile.whatCups.get(initialTile.whatCups.size()-1);
                    //initialTile.whatCups.remove(initialTile.whatCups.size() - 1);
                } */
                p = (JPanel) selected.getParent();
                p.removeAll();
                JLabel l = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\BlackGobbletSize1.jpg"));
                l.addMouseListener(new MouseAdapterSpecial(l, p));
                p.add(l);
            } else {
               /* int[] thePoints = getPanelPosition(p);
                tile secondaryTile = tileBoard[thePoints[0]][thePoints[1]];
                System.out.println(movingCup);
                if(movingCup.size > secondaryTile.currentCupSize) {
                    secondaryTile.whatCups.add(movingCup);
                }*/
                p.removeAll();
                p.add(selected);
                SwingUtilities.updateComponentTreeUI(frame);
                selected = null;
            }

        }

    }

}

