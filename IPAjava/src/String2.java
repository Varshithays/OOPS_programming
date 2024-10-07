import java.util.Scanner;

public class String2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String st = in.nextLine();
        int count = 0;
        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);
            /*if(ch >= 'A' && ch <= 'Z'){
                count++;
            }*/
            if(Character.isUpperCase(ch)){
                count++;
            }
        }
        if(count >5){
            System.out.println("Valid String");
        }else{
            System.out.println("Invalid String");
        }
    }

}
