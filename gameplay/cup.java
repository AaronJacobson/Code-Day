/**
 *
 * Created by Alex on 5/23/2015.
 *
 */
public class cup {

    int size;
    boolean color;

    public cup(int size, boolean color) {
        this.size = size;
        this.color = color;
    }

    public boolean getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String toString() { return "Size =" + size + color;}
}
