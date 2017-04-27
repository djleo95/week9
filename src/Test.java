import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by admin on 2017/04/20.
 */
public class Test {
    static Date today = new Date();
    private static boolean question(Gate gate, Ticket ticket) {
        Scanner s = new Scanner(System.in);
        System.out.println("-?- Keep going or stop here?");
        System.out.println("--> Type: GO or STOP to choose\n");
        String answer = s.next();
        switch (answer) {
            case "GO":
            case "go":
            case "Go":
                return true;
            case "STOP":
            case "stop":
            case "Stop":
                gate.exit(ticket);
                return false;
            default:
                System.out.println("-#-Did you type GO/STOP? Please input again");
                return question(gate, ticket);
        }
    }

    private static boolean main() {
        Scanner s = new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("_______START TEST_______");
        System.out.println("1.OneWayTicket Test");
        System.out.println("2.PrepaidCard Test");
        System.out.println("3.QUIT");
        System.out.println("Choose:");
        int choose = s.nextInt();
        switch(choose) {
            case 1:
                while(test1());
                return true;
            case 2:
                while(test2());
                return true;
            case 3:
                return false;
            default:
                return true;
        }
    }

    private static boolean test1(){
        Scanner s = new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("___ONE WAY TICKET TEST___");
        System.out.println("1.Can't enter start-station");
        System.out.println("2.Can enter start but can't exit end-station");
        System.out.println("3.Can enter and exit");
        System.out.println("4.Back to main menu");
        System.out.println("Choose:");
        int choose = s.nextInt();
        switch(choose) {
            case 1:
                oneWayTickketCase(7);
                return true;
            case 2:
                oneWayTickketCase(12);
                return true;
            case 3:
                oneWayTickketCase(100);
                return true;
            case 4:
                return false;
            default:
                return true;
        }
    }

    private static boolean test2(){
        Scanner s = new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("___PREPAID CARD TEST___");
        System.out.println("1.Can't enter start-station");
        System.out.println("2.Can enter start but can't exit end-station");
        System.out.println("3.Can enter and exit");
        System.out.println("4.Back to main menu");
        System.out.println("Choose:");
        int choose = s.nextInt();
        switch(choose) {
            case 1:
                prepaidCardCaseCase(7);
                return true;
            case 2:
                prepaidCardCaseCase(12);
                return true;
            case 3:
                prepaidCardCaseCase(100);
                return true;
            case 4:
                return false;
            default:
                return true;
        }
    }

    private static void run(Ticket ticket) {
        Line.A.enter(ticket);
        if(ticket.isValid()) {
            System.out.println("____Get in train____");
            System.out.println("_____Arrived B_____");
            boolean a = question(Line.B, ticket);
            if(a) {
                System.out.println("____Get in train____");
                System.out.println("_____Arrived C_____");
                a = question(Line.C, ticket);
                if(a) {
                    System.out.println("____Get in train____");
                    System.out.println("_____Arrived D_____");
                    System.out.println("_____Last station_____");
                    Line.D.exit(ticket);
                }
            }
        }
    }

    private static void oneWayTickketCase(int value) {
        OneWayTicket ticket = new OneWayTicket(value, today);
        System.out.println("#######################");
        System.out.println("Attempt test for OneWayTicket:" + " Value: $" + ticket.getValue());
        run(ticket);
    }

    private static void prepaidCardCaseCase(int value) {
        PrepaidCard card = new PrepaidCard(value, today);
        System.out.println("#######################");
        System.out.println("Attempt test for PrepareCard:" + " Value: $" + card.getValue());
        run(card);
    }

    public static void main(String args[]) {
        while(main());
    }
}
