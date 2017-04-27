import java.util.Date;

/**
 * Created by admin on 2017/04/20.
 */
public class PrepaidCard extends Ticket implements ICard {
    public PrepaidCard(int _value, Date _date) {
        super(_value, _date);
    }

    @Override
    public void add(int amount) {
        this.value += amount;
    }

    @Override
    public boolean deduct(int amount) {
        if(this.value < amount) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isValid(){
        return this.getValid();
    }
}
