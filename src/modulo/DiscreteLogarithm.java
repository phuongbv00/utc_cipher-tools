package modulo;

/**
 * Tính Logarit rời rạc log a(b) mod n
 * @author censodev
 */
public class DiscreteLogarithm {
    public static void main(String[] args) {
        calc(3, 7, 13);
    }

    public static int calc(int a, int b, int n) {
        System.out.printf("x = log%d(%d) mod %d%n", a, b, n);
        for (int i = 1; i < n; i++) {
            int mod = ExpoModulo.calc(a, i, n, false);
            System.out.printf("%d^%d mod %d = %d%n", a, i, n, mod);
            if (mod == b) {
                System.out.println("=> x = " + i);
                return i;
            } else if (mod == 1) {
                System.out.printf("=> Vo nghiem (%d khong phai la can nguyen thuy cua %d)%n", a, n);
                return 0;
            }
        }
        return 0;
    }
}
