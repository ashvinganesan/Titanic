
public class TitanicScoring {

    public static Titanic.Passenger[] passengers = TitanicTrainData.passengers;

    public static void print(Titanic.Passenger passenger) {
        System.out.println("  ID = " + passenger.id());
        System.out.println("  Sex = " + passenger.sex());
        System.out.println("  Age = " + passenger.age());
        System.out.println("  Port = " + passenger.port());
        System.out.println("  Fare = " + passenger.fare());
        System.out.println("  Class = " + passenger.pclass());
        System.out.println("  Parents = " + passenger.parents());
        System.out.println("  Siblings = " + passenger.siblings());
        System.out.println("  Survived = " + passenger.survived());
        System.out.println();
    }

    public static void main(String[] args) {
        int correct = 0;
        int count = 0;

        for (Titanic.Passenger passenger : passengers) {
            try {

                boolean survived = TitanicClassifier.survived(passenger);
                if (passenger.sex() == Titanic.Sex.FEMALE) {
                    if (survived == passenger.survived()) {
                        correct++;
                    } else {
                        System.out.println("Incorrect classification: " + passenger.name());
                        print(passenger);
                    }
                }
            } catch (Exception e) {
                System.out.println("Unhandled exception (" + e + "): " + passenger.name());
                print(passenger);
            }
             if (passenger.sex() == Titanic.Sex.FEMALE) {
                count++;

             }
        }

        double accuracy = ((double) correct) / ((double) count);
        System.out.printf("Accuracy = %.2f\n", 100.0 * accuracy);
    }
}
