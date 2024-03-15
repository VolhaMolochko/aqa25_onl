public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, String nessage) {
        System.out.println(nessage);
        return a + b;
    }

    public double div(double c, double d) {
        return c / d;
    }

    public int div(int c, int d) {
        return c / d;
    }
}
