import java.util.Scanner;
//NO OF VOWELS AND CONSONANT IN STRING
// SO FIRST CONEVERING STRING TO LOWERCASE AND THEN COUNT VOWEL AND CONSONANTS
public class AlphabetCount {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        String st= str.toLowerCase();
        int vowel =0;
        int consonant = 0;
        for(int i=0;i<st.length();i++){
            char ch = st.charAt(i);
            if(ch =='a' || ch == 'e' || ch =='i' || ch =='o' || ch == 'u'){
                vowel++;
            }else if(ch >'a' && ch < 'z'){
                consonant++;
            }
        }
        System.out.println(vowel+ " "+consonant);
    }
}
