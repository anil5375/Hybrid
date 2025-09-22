package Programs;

public class ReverseWords {

    public static void main(String[] args) {

        String str = "Java is so fun";
        String[] words = str.split(" ");
        String reversedString = "";
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString = reversedString + words[i] + " ";

        }
        System.out.println(reversedString.trim());
    }
}
