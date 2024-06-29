public class Main {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {

        // If doubt refer to sliding window in obsidian

        if(s.isEmpty()) return 0;
        else if (s.length() == 1) return 1;

        int ans = 0;
        int i = 0;
        int j = 0;
        int N = s.length();
        int[] A = new int[256];

        for(; j < N; j++) {

            // invalidate the state
            A[s.charAt(j)]++;

            // until the invalid state is valid, reduce
            while(A[s.charAt(j)] > 1) {
                A[s.charAt(i++)]--;
            }

            ans = Math.max(ans, j - i + 1);

        }

        return ans;

    }
}
