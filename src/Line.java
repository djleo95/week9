/**
 * Created by admin on 2017/04/20.
 */
public class Line {
    public static int START = 9;
    public static int BLOCK = 2;
    public static int START_PRICE = 6;
    public static int BLOCK_PRICE = 2;
    public static Gate A = new Gate("A",0);
    public static Gate B = new Gate("B",17);
    public static Gate C = new Gate("C",22);
    public static Gate D = new Gate("D",33);


    public int getFare(int  distance) {
        int total = 0;
        if(distance <= START) {
            return START_PRICE;
        } else {
            int step = 0;
            step = (int) Math.ceil((distance - START)/BLOCK);
            total = START_PRICE + BLOCK_PRICE*step;
            return total;
        }
    }
}
