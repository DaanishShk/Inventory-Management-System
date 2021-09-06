package ui.buffer;

/** Generic class to wrap ArrayList object
 * @author DaanishShk
 * @version 1.0
 * @since 2021-09-06
 */
import java.util.ArrayList;

public class Buffer<T> {

    private ArrayList<T> list;

    public Buffer() {
        this.list = new ArrayList<>();
    }

    public void add(T t) {
        this.list.add(t);
    }

    public void remove(T t) {
        this.list.remove(t);
    }

    public ArrayList<T> getList() {
        return this.list;
    }

    public void flush() {
        this.list.clear();
    }

    /**
     * All contents of the buffer are printed row by row.
     */
    public void printContents() {
        System.out.println("Buffer Contents:");
        int cnt = 1;
        for(T i: this.list) {
            System.out.println(cnt+". "+i);
            cnt++;
        }
    }

}
