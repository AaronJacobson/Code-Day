/**
 *
 * Created by Alex on 5/23/2015.
 *
 */
public class tile {
    cup[] whatCups = new cup[4];
    int currentCupSize =  0;

    public tile() {
    }

    public cup[] getWhatCups() {
        return whatCups;
    }

    public void addCup(cup a) {
        whatCups[currentCupSize] = a;
        currentCupSize += 1;
    }

    public void removeCup(cup a) {
        whatCups[currentCupSize] = null;
        currentCupSize -=1;
    }
}