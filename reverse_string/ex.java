import java.util.Scanner;

class ex {
    public static void main(String[] args) {
        // To get User input from the terminal
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // Define an empty output string
        String outString = "";

        // Iterate over the characters and add to the outstring
        for(int i = 0; i < input.length(); i++) {
            outString = input.charAt(i) + outString;
        }

        System.out.println(outString);
    }
} 