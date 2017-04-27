import java.util.Date;

/**
 * Created by admin on 2017/04/20.
 */
public class OneWayTicket extends Ticket {

    public OneWayTicket(int _value, Date _date) {
        super(_value, _date);
    }

    public boolean isValid() {
        return this.getValid();
    }
}
