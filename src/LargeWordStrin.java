import java.util.Scanner;

public class LargeWordStrin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str= in.nextLine();
        String large="";
        String[] words= str.split("\\s+");
        for(int i=0;i< words.length;i++){
            if(words[i].length()>large.length()){
                large=words[i];
            }

        }
        System.out.println(large);
    }
}
