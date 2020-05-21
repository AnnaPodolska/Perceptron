
public class Iris {

    private String name;
    private double[] values = new double[4];

    public Iris(double sepalLength, double sepalWidth, double petalLength,
                double petalWidth, String name){
        this.name = name;
        values[0] = sepalLength;
        values[1] = sepalWidth;
        values[2] = petalLength;
        values[3] = petalWidth;
    }
    public double[] getValues(){
        return values;
    }
    public String getName() {
        return name;
    }
}
