public class Calculator {
    public int sum(int a, int b) {
        return a + b;
    }

    public int div1(int c, int d) throws NumberException {
        if (d == 0) {
            throw new NumberException ("Can't divide by 0");
        }
        return c / d;
    }

    public double div2(double y, double z) throws  NumberException{
        if (z == 0) {
            throw new NumberException("Can't divide by 0");
        }
        return y / z;
    }
}
