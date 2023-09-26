public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(Integer.MAX_VALUE, 0, '+');
        double res = calculator.calculate();
        System.out.println(res);
    }
}