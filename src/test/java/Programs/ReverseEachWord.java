package Programs;

public class ReverseEachWord {


    public static void main(String[] args) {

        String str = "Java is so fun";
        String[] words = str.split(" ");
        String reversedSentence = "";

        // Reverse each word
        for (String word : words) {
            String reverseword = "";

            //    String reversedWord = new StringBuilder(word).reverse().toString();
            // System.out.print(reversedWord);
            //       reversedSentence += reversedWord + " ";
            for (int i = word.length() - 1; i >= 0; i--) {
                reverseword = reverseword + word.charAt(i);
            }
            reversedSentence += reverseword + " ";

            // Print the result
            //   System.out.print("Original: " + str);
            // System.out.print("Reversed Words: " + reversedSentence.trim());
        }
        System.out.print(reversedSentence);
    }
}

