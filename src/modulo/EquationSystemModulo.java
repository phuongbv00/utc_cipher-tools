package modulo;

/**
 * Giải hệ phương trình Modulo bằng phương pháp phần dư Trung Hoa
 *
 * @author censodev
 */
public class EquationSystemModulo {
    public static void main(String[] args) {
        calc(6, 2, 4, 11, 13, 17);
    }

    public static void calc(int a1, int a2, int a3, int m1, int m2, int m3) {
        int M = m1 * m2 * m3;
        int M1 = M / m1;
        int M2 = M / m2;
        int M3 = M / m3;
        System.out.printf("M = %d.%d.%d = %d\n", m1, m2, m3, M);
        System.out.printf("M1 = M/m1 = %d\n", M1);
        System.out.printf("M2 = M/m2 = %d\n", M2);
        System.out.printf("M3 = M/m3 = %d\n", M3);
        System.out.println();

        int M1_1 = EuclidReverseModulo.calc(M1, m1, false);
        int M2_1 = EuclidReverseModulo.calc(M2, m2, false);
        int M3_1 = EuclidReverseModulo.calc(M3, m3, false);
        System.out.printf("M1^-1 mod m1 = %d^-1 mod %d = %d\n", M1, m1, M1_1);
        System.out.printf("M2^-1 mod m2 = %d^-1 mod %d = %d\n", M2, m2, M2_1);
        System.out.printf("M3^-1 mod m3 = %d^-1 mod %d = %d\n", M3, m3, M3_1);
        System.out.println();

        int c1 = M1 * M1_1;
        int c2 = M2 * M2_1;
        int c3 = M3 * M3_1;
        System.out.printf("c1 = %d.%d = %d\n", M1, M1_1, c1);
        System.out.printf("c2 = %d.%d = %d\n", M2, M2_1, c2);
        System.out.printf("c3 = %d.%d = %d\n", M3, M3_1, c3);
        System.out.println();

        int rs = (a1 * c1 + a2 * c2 + a3 * c3) % M;
        System.out.printf("x = (a1.c1 + a2.c2 + a3.c3) mod M = (%d.%d + %d.%d + %d.%d) mod %d = %d", a1, c1, a2, c2, a3, c3, M, rs);
    }
}
