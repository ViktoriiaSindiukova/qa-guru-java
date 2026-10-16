public class BaseJavaPractice {

    int a = 9;
    int b = 3;
    double c = 2.5;

    public void calculationsBetweenIntVariables() {
        int sum = a + b;
        int sub = a - b;
        int mult = a * b;
        int div = a / b;

        System.out.println(
                "sum: " + sum
                        + "\nsub: " + sub
                        + "\nmult: " + mult
                        + "\ndiv: " + div
        );
    }

    public void calculationBetweenIntAndDouble() {
        System.out.println(b * c + a);
    }

    public void compareVariables() {
        System.out.println(a > b);
        System.out.println(b < c);
    }

    public void integerOverflow() {
        int maxValue = Integer.MAX_VALUE;

        System.out.println(maxValue);
        System.out.println(maxValue + 1);
    }
}
