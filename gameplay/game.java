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
                if(m == 1 && n == 1){
                    ArrayList<cup> list = new ArrayList<cup>();
                    list.add(new cup(4, false));
                    tileBoard[1][1] = new tile();
                    panelHolderBoard[1][1] = new JPanel();
                    JLabel img = tileBoard[1][1].getBiggestCup();
                    panelHolderBoard[1][1].add(img);
                    height = 1;
                    width = 1;
                    img.addMouseListener(new MouseAdapterSpecial(img, panelHolderBoard[1][1]));
                    containGrid.add(panelHolderBoard[1][1]);
                }
                else {
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
        int x;
        int y;
        int[] point = new int[2];
        for(int yy = 0; yy < HEIGHT_OF_BOARD; yy++){
            for(int xx = 0; xx < WIDTH_OF_BOARD; xx++){
                if(panelHolderBoard[yy][xx] == el){
                    point = new int[]{yy, xx};
                }
            }
        }
        return point;
    }

    private class MouseAdapterSpecial extends MouseAdapter {
        private JLabel label;
        private boolean twoD;
        private JPanel p;
        private JPanel passed;

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
                tile initialTile = tileBoard[thePoints[0]][thePoints[1]];
                if (initialTile.whatCups.size() > 0) {
                    movingCup = initialTile.whatCups.get(initialTile.whatCups.size() - 1);
                    initialTile.whatCups.remove(initialTile.whatCups.size() - 1);
                }
                p = (JPanel) selected.getParent();
                p.removeAll();
                p.add(initialTile.getBiggestCup());
            } else {
                int[] thePoints = getPanelPosition(p);
                tile secondaryTile = tileBoard[thePoints[0]][thePoints[1]];
                if(movingCup.size > secondaryTile.currentCupSize) {
                    secondaryTile.whatCups.add(movingCup);
                }
                p.removeAll();
                p.add(selected);
                SwingUtilities.updateComponentTreeUI(frame);
                selected = null;
                passed = null;
            }

        }

    }

}

