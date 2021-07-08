package modulo;

/**
 * Kiểm tra a có phải căn nguyên thủy của n không
 *
 * @author censodev
 */
public class PrimitiveSquare {
    public static void main(String[] args) {
        check(2, 352);
    }

    public static boolean check(int a, int n) {
        if (!isPrime(n)) {
            System.out.println("n khong la so nguyen to");
            return false;
        }
        int pN = n - 1;
        System.out.printf("Vi n la so nguyen to -> pN = %d%n", pN);
        for (int i = 2; i < pN; i++) {
            if (pN % i == 0) {
                int mod = ExpoModulo.calc(a, i, n, false);
                System.out.printf("%d^%d mod %d = %d%n", a, i, n, mod);
                if (mod == 1) {
                    System.out.println("=> a khong la can nguyen thuy cua n");
                    return false;
                }
            }
        }
        System.out.println("=> a la can nguyen thuy cua n");
        return true;
    }

    private static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        return true;
    }
}
