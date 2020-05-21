import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        double alfa;
        System.out.println("Podaj stałą uczenia: ");
        alfa = scan.nextDouble();

        Perceptrone p = new Perceptrone(alfa, "iris.csv", "irisTest.csv");
        p.trainPerceptrone();
        System.out.println("Skutecznosc rozpoznawania dla danych testowych wynosi " + p.testPerceptrone() + "%");

        double[] vector = new double[4];
            do {
               System.out.println("Podaj dane do sprawdzenia...");
               System.out.println("sepal length: ");
               vector[0] = scan.nextDouble();
               System.out.println("width length: ");
               vector[1] = scan.nextDouble();
                System.out.println("petal length: ");
                vector[2] = scan.nextDouble();
                System.out.println("petal width: ");
                vector[3] = scan.nextDouble();
                System.out.println("Kwiat o podanych parametrach klasyfikuje sie do rodzaju " +
                    p.testOneVector(vector));
                }
            while(scan.nextDouble() != -1);
    }
}

