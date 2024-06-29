public class Main {

    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";

        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] cArr = new int[256];

        for(int i = 0; i < magazine.length();i++){
            cArr[magazine.charAt(i)]++;
        }

        for(int i = 0; i < ransomNote.length();i++){
            if(--cArr[ransomNote.charAt(i)] < 0) return false;
        }

        return true;
    }

}
