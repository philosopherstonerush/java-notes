public class Main {

    public static void main(String[] args) {
        String test = "Hello World";
        int output = lengthOfLastWord(test);
        System.out.println(output);
    }


    // welp it was not hard at all
    public static int lengthOfLastWord(String s) {
        Character c;
        StringBuilder sb = new StringBuilder();

        int i = s.length() - 1;

        while(i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
            } else {
                break;
            }
        }

        while(i >= 0) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i--;
            } else {
                break;
            }
        }

        return sb.toString().length();

    }

}
