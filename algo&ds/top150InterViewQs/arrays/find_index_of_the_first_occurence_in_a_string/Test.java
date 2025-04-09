public class Test {
    public static void main(String[] args) {
        String hayStack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(hayStack, needle));
    }

    public static int strStr(String haystack, String needle) {

        if(needle.length() > haystack.length()){
            return -1;
        }

        int i = 0;
        int j = 0;
        int start = 0;
        while(i < haystack.length()) {
            start = i;
            while(j < needle.length() && haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
            }
            if(j == needle.length()) {
                return start;
            }
            i = start + 1;
            j=0;
        }

        return -1;

    }
}
