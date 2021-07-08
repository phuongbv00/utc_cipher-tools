package modulo;

/**
 * Tính lũy thừa Modulo bằng phương pháp hạ bậc
 * @author censodev
 */
public class ExpoModulo {
    public static void main(String[] args) {
        calc( 251, 1758, 229, true);
    }

    public static int calc(int a, int m, int n, boolean isPrint) {
        int mod;
        if (m == 1) {
            mod = (int) (Math.pow(a, m) % n);
            if (isPrint) {
                System.out.printf("%d mod %d = %d%n", a, n, mod);
            }
            return mod;
        }
        int newM = m / 2;
        int childExpoMod = calc(a, newM, n, isPrint);
        if (m % 2 == 0) {
            mod = (int) (Math.pow(childExpoMod, 2) % n);
            if (isPrint) {
                if (newM > 1) {
                    System.out.printf("%d^%d mod %d = (%d^%d)^2 mod %d = %d^2 mod %d = %d%n", a, m, n, a, newM,
                            n, childExpoMod, n, mod);
                } else {
                    System.out.printf("%d^%d mod %d = %d^2 mod %d = %d^2 mod %d = %d%n", a, m, n, a, n,
                            childExpoMod, n, mod);
                }
            }
        } else {
            mod = (int) ((Math.pow(childExpoMod, 2) % n * a % n) % n);
            if (isPrint) {
                if (newM > 1) {
                    System.out.printf("%d^%d mod %d = (%d^%d)^2.%d mod %d = %d^2.%d mod %d = %d%n", a, m, n, a,
                            newM, a, n, childExpoMod, a, n, mod);
                } else {
                    System.out.printf("%d^%d mod %d = %d^2.%d mod %d = %d^2.%d mod %d = %d%n", a, m, n, a, a,
                            n, childExpoMod, a, n, mod);
                }
            }
        }
        return mod;
    }
}
