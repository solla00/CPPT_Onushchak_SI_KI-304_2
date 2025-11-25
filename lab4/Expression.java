package lab4;

public class Expression {
    

    public static double calculate(double x) throws ArithmeticException {
        double denominator = Math.tan(2 * x - 4);
        
        if (Math.abs(denominator) < 1e-10) {
            throw new ArithmeticException("Помилка: tg(2x - 4) = 0, ділення на нуль неможливе.");
        }
        
        return 7 * x / denominator;
    }
    
}