package Programs;

public class RepeatingWords {
    public static void main(String[] args) {
        //Repeating words in a string
        String str = "Programming";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;


            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }

            if (count > 1) {
                System.out.println(ch + " appears " + count + " times");
                // To avoid printing the same character again
             //   str = str.replace(ch, '0');
            }
        }
    }
}
