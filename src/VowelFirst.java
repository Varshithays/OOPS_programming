import java.util.Scanner;

public class VowelFirst {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        str.toLowerCase();
        int count=0;
        String words[] = str.split(" ");
        for(int i=0;i<words.length;i++){
            char ch = words[i].charAt(0);
           if(ch =='a'||ch=='e'||ch =='i'||ch == 'o'||ch == 'u'){
               count++;
           }
        }
        if(count==0){
            System.out.println("no match");
        }else{
            System.out.println(count);
        }
    }
}
