/**
 * @author
 * @description
 * @date 09.02.15.
 * A part of norxj.
 */
public class Foo {
    public static void main(String[] args) {
        int[] k = new int[] {
                0x00112233, 0x44556677,
                0x8899AABB, 0xCCDDEEFF
        };

        int[] n = new int[] {
                0xFFFFFFFF, 0xFFFFFFFF
        };

        Norx32 norx = new Norx32();
        int[] S = norx.initialize(k, n);
        for (int i = 0, num = S.length; i < num; i++) {
            System.out.print(S[i] + " ");
            if ((i+1)%4 == 0) {
                System.out.println();
            }
        }
    }
}
