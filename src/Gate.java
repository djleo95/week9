/**
 * Created by admin on 2017/04/20.
 */
public class Gate {
    private String name;
    private int distance;
    public Gate(String _name, int _distance) {
        setName(_name);
        setDistance(_distance);
    }
    private void setName(String _name) {
        name = _name;
    }
    private void setDistance(int _distance) {
        distance = _distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void enter(Ticket ticket) {
        System.out.println("----------\nEntering at "+ this.name +"....");
        if(ticket.value < 9) {
            System.out.println("Not enough money. Please check your ticket/card value!" +
                    "\nMin value to access is $9");
            close();
            ticket.setValid(false);
        } else {
            System.out.println("Successful access. Welcome!");
            open();
            ticket.setOrigin(this);
        }
    }

    public void exit(Ticket ticket) {
        System.out.println("----------\nExiting at "+ this.name +"....");
        System.out.println("You came from "+ ticket.getOrigin().getName());
        System.out.println("You have $"+ ticket.getValue() + " in your ticket");
        int start = ticket.getOrigin().getDistance();
        int end = this.getDistance();
        Line a = new Line();
        ticket.adjustValue(a.getFare(end - start));
        if(ticket.isValid()) {
            open();
        } else {
            close();
        }
    }

    public void open() {
        System.out.println("Open gate");
    }
    public void close() {
        System.out.println("Close gate");
    }
}
