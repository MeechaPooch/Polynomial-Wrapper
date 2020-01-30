import lines.PolyTrendLine;

import java.util.ArrayList;

public class PolynomialWrapper extends PolyTrendLine {
    //accepts any ammount of arrays of length 2, indexes corresponding to x and y coordinatesa
    ArrayList<Double> x = new ArrayList();
    ArrayList<Double> y = new ArrayList();
    public PolynomialWrapper(int degree, double[]... points) {
        super(degree);
        for (int i = 0; i < points.length; i++) {
            if(points[i].length != 2) { throw(new IllegalArgumentException("The length of each array must be 2")); }
            x.add(points[i][0]);
            y.add(points[i][1]);
        }
        updateValues();
    }
    public PolynomialWrapper(int degree, double[] x, double[] y) {
        super(degree);
        for (int i = 0; i < x.length; i++) {
            this.x.add(x[i]);
            this.y.add(y[i]);
        }
        updateValues();
    }
    //takes polynomial degre
    public PolynomialWrapper(int degree) {
        super(degree);
    }

    public void addPoint(double[] point) {
        if(point.length!=2) { throw(new IllegalArgumentException("array must be of length 2")); }
        x.add(point[0]);
        y.add(point[1]);
        updateValues();
    }

    //updates super with current stored x and y values
    private void updateValues() {
        setValues((Double[])x.toArray(), (Double[]) y.toArray());
    }
}
