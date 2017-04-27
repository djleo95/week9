import java.util.Date;

/**
 * Created by admin on 2017/04/20.
 */
public abstract class Ticket {
    protected Date issuedDate;
    protected int value;
    private Gate origin;
    private boolean valid = true;


    public Ticket(int _value, Date _date) {
        value = _value;
        issuedDate = _date;
    }

    public int getValue() {
        return value;
    }

    public void setOrigin(Gate _gate) {
        origin = _gate;
    }

    public Gate getOrigin() {
        return origin;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean getValid() {
        return valid;
    }

    public abstract boolean isValid();

    public void adjustValue(int fare) {
        System.out.println("Your ride cost: $" + fare);
        System.out.println("======>");
        if(value > fare){
            value -= fare;
            System.out.println("You still have $"+ value +" in this ticket/card!");
            System.out.println("Thanks for using our service!");
        } else if (value == fare) {
            System.out.println("This ticket/card is empty now!");
            System.out.println("Thanks for using our service!");
        } else {
            System.out.println("Your ticket/card don't have enough money to pay. You need add: "
                    +(fare - value)+"$ more to go!");
            setValid(false);
        }
    }
}
