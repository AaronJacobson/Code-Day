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

    public JLabel getBiggestTile() {
        /*if (whatCups[currentCupSize-1].getColor()){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlackCupSize" + currentCupSize + ".jpg");
            JLabel lab = new JLabel(icon);
            return lab;
        } else if(!(whatCups[currentCupSize-1].getColor())){
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BeigeCupSize" + currentCupSize + ".jpg");
            JLabel lab = new JLabel(icon);
            return lab;
        } else {
            ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\BlankTile.jpg");
            JLabel lab = new JLabel(icon);
            return lab;
        }*/
        return new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\BlankTile.jpg"));
    }

}