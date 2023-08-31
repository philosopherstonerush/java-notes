import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        HashMap<Integer, Integer> hm = new HashMap<>();
        int target = 4;
        for(int i = 0; i < A.length; i++) {
            int damn = Math.abs(target - A[i]);
            if(hm.get(damn) == null) {
                hm.put(damn, i);
            } else {
                System.out.println("Yes - [" + hm.get(damn) + ", " + i + "]");
            }
        }
        System.out.println("No");
    }
}
