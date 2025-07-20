import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Calculator {
    /** Calculation answer */
    protected static double ans = 0;
    
    /** Calculation variable. 
     * @hidden x1 is used for single param functions.
    */
    protected static double 
    x1 = 0, x2 = 0;

    protected static Method[] methods;

    // Basic Scientific Calculator Funstions:
    public static void add() {
        ans = x1 + x2;
    }

    public static void subtract() {
        ans = x1 - x2;
    }

    public static void divide() {
        if (x2 == 0) {
            System.out.println("Error: Cannot divide by 0");
            return;
        }

        ans = x1 / x2;
    }

    public static void multiply() {
        ans = x1 * x2;
    }

    public static void power() {
        ans = Math.pow(x1, x2);
    }

    public static void sqrt() {
        ans = Math.sqrt(x1);
    }

    public static void sine() {
        ans = Math.sin(x1);
    }

    public static void cos() {
        ans = Math.cos(x1);
    }

    public static void tan() {
        ans = Math.cos(x1);
    }

    public static void natural_log() {
        ans = Math.log(x1);
    }

    public static void log() {
        ans = Math.log10(x1);
    }

    public static void absolute() {
        ans = Math.abs(x1);
    }

    public static void round_nearest() {
        ans = Math.round(x1);
    }

    public static void round_up() {
        ans = Math.ceil(x1);
    }

    public static void round_down() {
        ans = Math.floor(x1);
    }

    public static void min() {
        ans = Math.min(x1, x2);
    }

    public static void max() {
        ans = Math.max(x1, x2);
    }

    // Helper functions:
    /**
     * Prints all methods of a class in a menu fashion.
     * @param _class
     */
    public static void menu(Class<Calculator> _class) {
        methods = _class.getDeclaredMethods();

        for (int i = 1; i < methods.length; ++i) {
            String name = methods[i].getName();

            // Prints: "1: tan()"
            System.out.println( 
                i + ": " + name
            );
        }
    }

    /**
     * Exits the program
     */
    public static void exit() {
        System.exit(0);
    }

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        menu(Calculator.class);
        System.out.printf("%nSelect a function via index");
        System.out.printf("%nIf function takes a single inputs you may ignore (Number 2: )");
        System.out.printf("To exit select index 1");

        while (true) {
            Scanner sc = new Scanner(System.in);

            int index;

            System.out.printf("%nFunction Index: ");
            index = sc.nextInt();

            if (index == 1)
                methods[1].invoke(null);

            System.out.printf("%nNumber 1: ");
            x1 = sc.nextDouble();

            System.out.printf("%nNumber 2: ");
            x2 = sc.nextDouble();

            Method selected = methods[index];
            selected.invoke(null);

            System.out.printf("%nAnswer: " + ans);
        }
    }
}