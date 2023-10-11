import org.example.Main;
import org.junit.Test;

import static org.example.Main.A;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test
    public void TestA() { // x = 2, n = 4, a = 124
        double a = 124, x = 2;
        int n = 4;
        double R = (2 * n - 1) / ((2 * n + 1) * Math.pow(x, 2));
        a *= R;
        assertEquals(24.1111111, a, 0.0000001);
    }

    @Test
    public void testS() {
        double x = 2, eps = 1e-5;
        int n = 4;
        n = 0;
        double a = 1 / x;
        double s = a;
        do {
            n++;
            a = A(x, n, a);
            s += a;
        } while (Math.abs(a) >= eps);
        assertEquals(0.5493035, s, 0.0000001);
    }
}

