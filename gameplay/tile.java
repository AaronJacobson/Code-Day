import javax.swing.*;

/**
 *
 * Created by Alex on 5/23/2015.
 *
 */
public class tile {
    cup[] whatCups;
    int currentCupSize = 1;

    public tile() {
        whatCups = new cup[4];
    }

    public tile(int maxCupSize){
        currentCupSize = maxCupSize;
        whatCups = new cup[4];
    }

    public tile(cup[] cupArray){
        this.whatCups = cupArray;
        currentCupSize = getBiggestCupSize();
    }

    public cup[] getWhatCups() {
        return whatCups;
    }

    public void addCup(cup a) {
        whatCups[currentCupSize-1] = a;
        currentCupSize += 1;
    }

    public void removeCup(cup a) {
        whatCups[currentCupSize-1] = null;
        currentCupSize -=1;
    }

    public JLabel getBiggestCup() {
        System.out.println(whatCups[0]);
        System.out.println(currentCupSize);
        if (! (whatCups[currentCupSize - 1] == null)) {
            if (whatCups[currentCupSize- 1].getColor()) {
                ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlackGobbletSize" + currentCupSize + ".jpg");
                JLabel lab = new JLabel(icon);
                return lab;
            } else  { //if (!(whatCups[currentCupSize - 1].getColor()))
                ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BeigeGobbletSize" + currentCupSize + ".jpg");
                JLabel lab = new JLabel(icon);
                return lab;
            }
        } else {
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlankTile.jpg");
            JLabel lab = new JLabel(icon);
            return lab;
        }
       // return new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\BlankTile.jpg"));
    }

    private int getBiggestCupSize(){
        int largest = 0;
        for(int s= 0; s < whatCups.length; s++){
            if(whatCups[s].getSize() > largest){
                largest = whatCups[s].getSize();
            }
        }
        return largest;
    }

}