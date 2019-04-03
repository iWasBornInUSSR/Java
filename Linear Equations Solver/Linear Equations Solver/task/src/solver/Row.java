package solver;

import java.util.Arrays;

public class Row {
    private float[] coeffs;
     float getFirstCoeff(){
        return coeffs[0];
    }

    public float[] getCoeffs() {
        return coeffs;
    }

    Row(float[] coeffs) {
        this.coeffs = coeffs;
    }

    Row(Row C) {
        this.coeffs = C.coeffs.clone();
    }
     void multByNumber(float m) {
        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] *= m;
        }

    }
    Row multByNumberNew(float m) {
         Row C = new Row(this);
        for (int i = 0; i < coeffs.length; i++) {
            C.coeffs[i] *= m;
        }
    return C;
    }
    public void intercalateRow(Row a) {
        if (a.coeffs.length != coeffs.length)
            System.err.println("Different length of rows!");
        else {

            for (int i = 0; i < coeffs.length; i++) {
                coeffs[i] += a.coeffs[i];
            }

        }
    }
    public String toString()
    { return Arrays.toString(coeffs);
    }
}
