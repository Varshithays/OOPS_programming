import java.util.Scanner;

public class String3 {
    public static  void main(String[] args){
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        int count =0;
        int space =0;

        for(int i=0;i<input.length();i++){
            
            if(input.charAt(i)==' '){
                count++;
            }

            if (!input.isEmpty()) {
            } else {
                space++;
            }
            int countchar = input.replace(" ","").length();

            int spacecount = input.length()-input.replace(" ","").length();

            System.out.println(countchar);
            System.out.println(spacecount);
        }

    }
}
