public class TryCatchExample {
    public static void main(String[] args) {
        try {
            int number = 10;
            int result = number / 10; // Causes ArithmeticException
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        }

        System.out.println("Program continues after catch block.");
    }
}