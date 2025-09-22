package Programs;

public class StringBuffer {
    public static void main(String[] args) {

        String sentence = "Java is fun and Java is powerful and fun";

        String[] words = sentence.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            boolean found = false;

            // Check if words[i] already appeared in result
            for (int j = 0; j < i; j++) {
                if (words[i].equals(words[j])) {
                    found = true;
                    break;

                }


            }
           // If not found earlier, add to result
            if (!found) {
                result += words[i] + " ";
            }
        }

        System.out.println("Original: " + sentence);
        System.out.println("Without Duplicates: " + result.trim());
    }

}
