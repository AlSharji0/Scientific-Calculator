import java.lang.reflect.Method;


public class Calculator {
    /** Calculation answer */
    protected static double ans = 0;
    
    /** Calculation variable. 
     * @hidden x1 is used for single param functions.
    */
    protected static double x1, x2;

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
        Method[] methods = _class.getDeclaredMethods();

        int index = 0;
        for (int i = 0; i < methods.length; ++i) {
            String name = methods[i].getName();

            // Prints: "1: tan()"
            System.out.println( 
                index + ": " + name
            );
        }
    }

    public static void main(String[] args) {
        menu(Calculator.class);
    }
}