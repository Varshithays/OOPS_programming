import java.util.Scanner;

class Vegetable{
    int vegetableId;
    String vegetableName;
    int price;
    int rating;

    public Vegetable(int vegetableId,String vegetableName,int price,int rating){
        this.vegetableId=vegetableId;
        this.vegetableName=vegetableName;
        this.price=price;
        this.rating=rating;
    }
}
public class VegetableProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Vegetable[] arr = new Vegetable[4];
        for (int i = 0; i < 4; i++) {
            int a = in.nextInt();
            in.nextLine();
            String b = in.nextLine();
            int c = in.nextInt();
            in.nextLine();
            int d = in.nextInt();
            in.nextLine();

            arr[i] = new Vegetable(a, b, c, d);

        }
        int inputrating = in.nextInt();
        in.nextLine();
        Vegetable ans = findPrice(arr, inputrating);
        if (ans == null) {
            System.out.println("No match found");
        } else {
            System.out.println(ans.vegetableId);
        }
    }

    public static Vegetable findPrice(Vegetable[] arr, int inputrating) {
        Vegetable minPriceVegetable = null;  // Keep track of the vegetable with the lowest price

        for (int i = 0; i < arr.length; i++) {
            // Check if the vegetable's rating is greater than the inputrating
            if (arr[i].rating > inputrating) {
                // If no vegetable has been selected or this vegetable's price is lower, update the result
                if (minPriceVegetable == null || arr[i].price < minPriceVegetable.price) {
                    minPriceVegetable = arr[i];
                }
            }
        }
        return minPriceVegetable;  // Return the vegetable with the lowest price that meets the condition
    }


}

