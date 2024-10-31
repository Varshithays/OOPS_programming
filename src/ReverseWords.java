import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String st= in.nextLine();
        String[] arr = st.split("\\s+");
        for(int i=arr.length-1;i>=0;i--) {

                System.out.print(arr[i] + " ");

        }
    }
}
