public class bai1 {
    public static double Power(double x, int n) {
        if (n == 0)
            return 1.0;
        else if (n > 0)
            return x * Power(x, n - 1);
        else {
            // n < 0: avoid division by zero
            if (x == 0.0)
                throw new IllegalArgumentException("Zero cannot be raised to a negative power");
            return Power(x, n + 1) / x;
        }
    }

    // Simple test harness (acts like unit tests without external dependencies)
    public static void main(String[] args) {
        test("positive exponent", 2.0, 3, 8.0);
        test("zero exponent", 5.0, 0, 1.0);
        test("negative exponent", 2.0, -2, 0.25);
        test("negative base", -2.0, 3, -8.0);
        testZeroNegativeException();
        System.out.println("All tests finished.");
    }

    static void test(String name, double x, int n, double expected) {
        double actual = Power(x, n);
        double eps = 1e-9;
        if (Math.abs(actual - expected) < eps) {
            System.out.println("PASS: " + name);
        } else {
            System.out.println("FAIL: " + name + " expected=" + expected + " actual=" + actual);
        }
    }

    static void testZeroNegativeException() {
        try {
            Power(0.0, -1);
            System.out.println("FAIL: zero negative exponent did not throw");
        } catch (IllegalArgumentException e) {
            System.out.println("PASS: zero negative exponent threw IllegalArgumentException");
        }
    }
}
