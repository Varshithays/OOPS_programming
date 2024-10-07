import java.util.Scanner;

public class String1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String  st = in.nextLine();
        int countLower=0;
        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);
            if(ch>='a' && ch<='z'){
                countLower++;
            }
        }
        if (countLower>0){
            System.out.println(countLower);
        }else{
            System.out.println("Now lower case characters present");
        }

    }
}
