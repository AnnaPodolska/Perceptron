import java.nio.file.Paths;
import java.util.List;

public class Perceptrone {
    private List<Iris> train;
    private List<Iris> test;
    private double phi;
    private double[] wektorWag = new double[4];
    private double alfa;
    private FileLoader fl = new FileLoader();
    private double net;

    public Perceptrone(double alfa, String trainSet, String testSet){
        this.alfa = alfa;
        this.train = fl.getFile(Paths.get(trainSet));
        this.test = fl.getFile(Paths.get(testSet));
            for (int i = 0; i < wektorWag.length; i++){
                wektorWag[i] = Math.random()*10 - 5;
            }
            phi =Math.random()*6 - 3;
    }

    public double testPerceptrone(){
        double goodAnswears = 0;
        double all = test.size();
        double accuracy;
        for(Iris ir : test){
            String perOutput =  testOneVector(ir.getValues());

            System.out.println("wynik: " + perOutput + ", pierwotnie: " + ir.getName());

            if (perOutput.equals(ir.getName())){
                goodAnswears++;
            }
        }
        accuracy = (goodAnswears / all) * 100;
        return accuracy;
    }
    public String testOneVector(double[] vec){
        net = countNet(wektorWag, phi, vec);
        if(net < phi){
            return "Iris-versicolor";
        }
            return "Iris-setosa";
    }

    public void trainPerceptrone(){

            for (int i = 0; i < 10; i++) {
                for (Iris iris : train) {
                    net = countNet(wektorWag, phi, iris.getValues());
                    if ((net < phi) && iris.getName().equals("Iris-setosa")){
                        deltaRuleV(iris.getValues(), 0, 1);
                        deltaRulePhi(0, 1);
                    }
                    if (net >= phi && iris.getName().equals("Iris-versicolor")){
                        deltaRuleV(iris.getValues(), 1, 0);
                        deltaRulePhi(1, 0);
                    }
                }
            }
    }

    public void deltaRuleV( double[] inputV, int actual, int expected){
        int wsize = wektorWag.length;
        for(int i = 0; i < wsize; i++){
            wektorWag[i] = wektorWag[i] + ((expected - actual)*(inputV[i] * alfa));
        }
    }

    public void deltaRulePhi(int actual, int expected){
         phi = phi + (expected - actual)*(alfa*(-1));
    }

    public double countNet(double[] weights, double phi, double[] vector){

        if(weights.length != vector.length){
            System.out.println("Niepoprawne dane wejsciowe - nierowne dlugosci wektorow");
            return -1;
        }
        double result = 0;
            for(int i = 0; i < weights.length; i++){
                result += weights[i] * vector[i];
            }
        return result;
    }
}
