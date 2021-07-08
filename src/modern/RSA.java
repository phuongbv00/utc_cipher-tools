package modern;

import modulo.EuclidReverseModulo;
import modulo.ExpoModulo;

public class RSA {
    public static void main(String[] args) {
        calc(17, 11, 7, 41);
    }

    public static void calc(int p, int q, int e, int M) {
        int n = p * q;
        int phiN = (p - 1) * (q - 1);
        System.out.printf("B1: n = p.q = %d.%d = %d \n", p, q, n);
        System.out.printf("B2: phi(n) = (p - 1).(q - 1) = (%d - 1).(%d - 1) = %d \n", p, q, phiN);
        System.out.printf("B3: d = %d^-1 mod %d\n", e, phiN);
        int d = EuclidReverseModulo.calc(e, phiN, true);
        System.out.printf("=> d = %d\n", d);
        System.out.printf("B4: PU = {e,n} = {%d,%d}\n", e, n);
        System.out.printf("B5: PR = {d,n} = {%d,%d}\n", d, n);

        System.out.println("B6.1: Ma hoa");
        int C = 0;
        System.out.println(">> Dung PU de ma hoa: (Bao mat)");
        System.out.printf("C = M^e mod n = %d^%d mod %d%n", M, e, n);
        C = ExpoModulo.calc(M, e, n, true);
        System.out.println("=> C = " + C);
        System.out.println();
        System.out.println(">> Dung PR de ma hoa: (Chu ky so)");
        System.out.printf("C = M^d mod n = %d^%d mod %d%n", M, d, n);
        C = ExpoModulo.calc(M, d, n, true);
        System.out.println("=> C = " + C);
        System.out.println();

        System.out.println("B6.2: Giai ma");
        System.out.println(">> Dung PU de ma hoa: (Bao mat) => Dung PR de giai ma");
        System.out.printf("M = C^d mod n = %d^%d mod %d%n", M, d, n);
        C = ExpoModulo.calc(M, d, n, true);
        System.out.println("=> M = " + C);
        System.out.println();
        System.out.println(">> Dung PR de ma hoa: (Chu ky so) => Dung PU de giai ma");
        System.out.printf("M = C^d mod n = %d^%d mod %d%n", M, e, n);
        C = ExpoModulo.calc(M, e, n, true);
        System.out.println("=> M = " + C);
        System.out.println();
    }
}
