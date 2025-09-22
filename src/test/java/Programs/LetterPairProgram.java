package Programs;

public class LetterPairProgram {
    public static void main(String[] args) {
        String input = "I love my dogs";
        input = input.replace(" ", ""); // remove spaces

        for(int i=0; i<input.length(); i++) {
            char prefix = input.charAt(i);
            for (int j = 0; j < input.length(); j++) {
                if (i != j) {
                    char suffix = input.charAt(j);
                    System.out.print(prefix + "" + suffix + " ");
                }
            }
            System.out.println(); // new line after each prefix
        }
}
}