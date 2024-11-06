import java.util.Scanner;

public class LastCharWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] words= str.split("\\s+");
       /* for(int i=0;i< words.length;i++){
            char ch = words[i].charAt(words[i].length()-1);
            if(Character.isDigit(ch)){
                continue;
            }
            System.out.print(ch);
        }*/
        String ans = "";
        for(String word:words){
            StringBuilder filteredWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    filteredWord.append(ch);
                }
            }

            // If there’s any alphabetic character in the filtered word, get the last character
            if (filteredWord.length() > 0) {
                ans += filteredWord.charAt(filteredWord.length() - 1);
            }
        }

        System.out.println("Output: " + ans);
        }
    }

