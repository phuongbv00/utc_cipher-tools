package modern;

import modulo.ExpoModulo;

/**
 * Trao đổi khóa Diffie Hellman
 *
 * @author censodev
 */
public class DiffieHellmanKeyExchange {
    public static void main(String[] args) {
        calc(7523, 5, 387, 247);
    }

    public static void calc(int q, int a, int xA, int xB) {
        System.out.println("Tinh khoa cong khai yA:");
        int yA = ExpoModulo.calc(a, xA, q, true);
        System.out.println("=> yA = " + yA);
        System.out.println();
        System.out.println("Tinh khoa cong khai yB:");
        int yB = ExpoModulo.calc(a, xB, q, true);
        System.out.println("=> yB = " + yB);
        System.out.println();
        System.out.println("Tinh khoa phien K:");
        int k = ExpoModulo.calc(a, xA * xB, q, true);
        System.out.println("=> K = " + k);
    }
}
