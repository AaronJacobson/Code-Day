import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * Created by Alex on 5/23/2015.
 *
 */
public class tile {
    ArrayList<cup> whatCups;
    int currentCupSize = 0;
    int locationInArray = 0;

    public tile() {
        whatCups = new ArrayList<>();
    }

    public tile(int maxCupSize){
        currentCupSize = maxCupSize;
        whatCups = new ArrayList<>();
    }

    public tile(ArrayList<cup> cupArray){
        whatCups = cupArray;
        currentCupSize = getBiggestCupSize();
    }

    public void setCurrentCupSize(int size){
        currentCupSize = size;
    }

    public ArrayList<cup> getWhatCups() {
        return whatCups;
    }

    public JLabel getBiggestCup() {
        if (whatCups.size() > 0 ) {
            if (!(whatCups.get(locationInArray) == null)) {
                if (whatCups.get(locationInArray).getColor()) {
                    ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlackGobbletSize" + getBiggestCupSize() + ".jpg");
                    JLabel lab = new JLabel(icon);
                    return lab;
                } else { //if (!(whatCups[currentCupSize - 1].getColor()))
                    ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BeigeGobbletSize" + getBiggestCupSize() + ".jpg");
                    JLabel lab = new JLabel(icon);
                    return lab;
                }
            } else {
                ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlankTile.jpg");
                JLabel lab = new JLabel(icon);
                return lab;
            }
        } else {
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlankTile.jpg");
            JLabel lab = new JLabel(icon);
            return lab;
        }
    }

    private int getBiggestCupSize(){
        int largest = 0;
        for(int s = 0; s < whatCups.size(); s++) {
            if (!(whatCups.get(s) == null)) {
                if (whatCups.get(s).getSize() > largest) {
                    largest = whatCups.get(s).getSize();
                }
            }
        }
        return largest;
    }

}