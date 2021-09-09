/**
 * NorxJ
 * Java implementation of NORX authenticated stream cipher: https://norx.io
 *
 * @author Julian Stier <norx@julian-stier.de>
 * @description
 * @date 2015
 * A part of norxj.
 *
 * You should have received a copy of the CC0 Public Domain Dedication along with
 * this software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */
public class Norx32 extends Norx {
    private static final int W = 32;
    private static final int M = 0xFFFFFFFF;
    private static final int[] U = new int[] {
        0x243F6A88, 0x85A308D3,
        0x13198A2E, 0x03707344,
        0x254F537A, 0x38531D48,
        0x839C6E83, 0xF97A3AE5,
        0x8C91D88C, 0x11EAFB59
    };
    private static final int R = 0;
    private static final int A = 0;

    @Override
    protected int getW() {
        return Norx32.W;
    }

    @Override
    protected int[] getU() {
        return Norx32.U;
    }

    @Override
    protected int getR() {
        return Norx32.R;
    }

    @Override
    protected int getD() {
        return 1;
    }

    @Override
    protected String getA() {
        return "";
    }
}
