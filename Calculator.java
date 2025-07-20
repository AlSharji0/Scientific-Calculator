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

    public static void sub() {
        ans = x1 - x2;
    }

    public static void div() {
        if (x2 == 0) {
            System.out.println("Error: Cannot divide by 0");
            return;
        }

        ans = x1 / x2;
    }

    public static void mul() {
        ans = x1 * x2;
    }

    public static void pow() {
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

    public static void nLog() {
        ans = Math.log(x1);
    }

    public static void log() {
        ans = Math.log10(x1);
    }

    public static void abs() {
        ans = Math.abs(x1);
    }

    public static void round() {
        ans = Math.round(x1);
    }

    public static void roundUp() {
        ans = Math.ceil(x1);
    }

    public static void roundDown() {
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
        for (Method m : methods) {
            ++index;
            String name = m.toString();
            System.out.println( 
                index + ": " + name
            );
        }
    }

    public static void main(String[] args) {
        menu(Calculator.class);
    }
}