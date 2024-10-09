import java.util.Scanner;

public class SmallestVowel {
    public static void main(String[] args){
        //SMALLEST VOWEL IN STRING
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String vowels[] = {"a","e","i","o","u"};
        for(int i=0;i<vowels.length;i++){
            char ch = str.charAt(i);
            if (str.contains(vowels[i])){
                System.out.println("Smallest vowel " +vowels[i]);
                break;
            }
        }
    }
}
