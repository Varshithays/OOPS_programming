import java.util.HashMap;
import java.util.*;
import java.util.Scanner;

public class CountOccurance {
    //a3b3c2
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String  input = in.nextLine();
       Map<Character,Integer> map = new HashMap<>();
       for(int i=0;i<input.length();i++){
           if(map.containsKey(input.charAt(i))){
               map.put(input.charAt(i),map.get(input.charAt(i))+1);
           }else{
               map.put(input.charAt(i),1);
           }
       }
        map.forEach((key,value)-> System.out.print(key+""+value));

    }
}
//second method
