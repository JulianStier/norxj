/**
 * @author
 * @description
 * @date 09.02.15.
 * A part of norxj.
 */
public abstract class Norx {
    /**
     * Specifies the actual word length of the according NORX version.
     *
     * @return Word length
     */
    abstract protected int getW();

    /**
     * Specifies the actual initialisation constants of the according NORX version.
     *
     * @return
     */
    abstract protected int[] getU();

    /**
     * Number of rounds.
     *
     * @return
     */
    abstract protected int getR();

    abstract protected int getD();

    abstract protected String getA();

    protected int H(int a, int b) {
        return ((a ^ b) ^ ((a & b) << 1));
    }

    protected int ROTR(int a, int r) {
        return ((a >>> r) | (a << (this.getW() - r)));
    }

    protected void G(int[] S, int a, int b, int c, int d) {
        S[a] = this.H(S[a], S[b]);
        S[d] = this.ROTR(S[a] ^ S[d], 8);
        S[c] = this.H(S[c], S[d]);
        S[b] = this.ROTR(S[b] ^ S[c], 11);
        S[a] = this.H(S[a], S[b]);
        S[d] = this.ROTR(S[a] ^ S[d], 16);
        S[c] = this.H(S[c], S[d]);
        S[b] = this.ROTR(S[b] ^ S[c], 31);
    }

    protected void F(int r, int[] S) {
        for (int i = 0; i < r; i++) {
            this.G(S, 0, 4, 8, 12);
            this.G(S, 1, 5, 9, 13);
            this.G(S, 2, 6, 10, 14);
            this.G(S, 3, 7, 11, 15);
            this.G(S, 0, 5, 10, 15);
            this.G(S, 1, 6, 11, 12);
            this.G(S, 2, 7, 8, 13);
            this.G(S, 3, 4, 9, 14);
        }
    }

    /**
     *
     * @param k Key with four words with W length
     * @param n Nonce with two words of W length
     * @return
     */
    protected int[] initialize(int[] k, int[] n) {
        int s0 = getU()[0];
        int s1 = n[0];
        int s2 = n[1];
        int s3 = getU()[1];
        int s4 = k[0];
        int s5 = k[1];
        int s6 = k[2];
        int s7 = k[3];
        int s8 = getU()[2];
        int s9 = getU()[3];
        int s10 = getU()[4];
        int s11 = getU()[5];
        int s12 = getU()[6];
        int s13 = getU()[7];
        int s14 = getU()[8];
        int s15 = getU()[9];
        s14 = s14 ^ ((this.getR() << 26) ^
                        (this.getD() << 18) ^
                        (this.getW() << 10) ^
                        (this.getA().length()));
        int[] S = {
                s0, s1, s2, s3,
                s4, s5, s6, s7,
                s8, s9, s10, s11,
                s12, s13, s14, s15
        };
        this.F(this.getR(), S);
        S[15] ^= 0x00000001;
        this.F(this.getR(), S);
        return S;
    }
}
