public class Calculator {
    private int a;
    private int b;
    private char c;

    public Calculator(int a, int b, char c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean checkValidOfInput() {
        if (c != '+' && c != '-' && c != '*' && c != '/') {
            return false;
        }
        return true;
    }


    public void checkValueOfResult(){
        int intMax = Integer.MAX_VALUE;
        int intMin = Integer.MIN_VALUE;
        if(c == '+'){
            if (b > 0 && a > intMax - b) {
                throw new RuntimeException("Addition exceeds INT_MAX limit");
            } else if (b < 0 && a < intMin - b) {
                throw new RuntimeException("Addition exceeds INT_MIN limit");
            }
        }
        if (c == '-'){
            if (b > 0 && a < intMin + b) {
                throw new RuntimeException("Subtraction exceeds INT_MIN limit");
            } else if (b < 0 && a > intMax + b) {
                throw new RuntimeException("Subtraction exceeds INT_MAX limit");
            }
        }

        if(c == '*'){
            long result = (long)a * (long)b;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
                throw new RuntimeException("There is a number overflow");
            }
        }

        if(c == '/'){
            if(b == 0){
                throw new ArithmeticException ("Can't devide by 0");
            }
        }
    }

    public double calculate() {
        double result = 0;
        switch (c) {
            case '+':
                result = add();
                break;
            case '-':
                result = subtract();
                break;
            case '*':
                result = multiply();
                break;
            case '/':
                result = divide();
                break;
            default:
//                System.out.println("Phép tính không hợp lệ");
        }
        return result;
    }

    private int add() {
        return a + b;
    }

    private int subtract() {
        return a - b;
    }

    private int multiply() {
        return a * b;
    }

    private double divide() {
        double res = (double) a/b;
        return Math.round(res * 100.0) / 100.0;
    }
}


