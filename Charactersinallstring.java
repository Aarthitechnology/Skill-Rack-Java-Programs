import java.util.*;

public class Charactersinallstring {    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        // Add all characters from the first string into the set
        Set<Character> common = new HashSet<>();
        for (char ch : s.toCharArray()) {
            common.add(ch);
        }

        // Intersect with characters from each next string
        for (int i = 1; i < n; i++) {
            String ss = sc.next();
            Set<Character> set = new HashSet<>();
            for (char ch : ss.toCharArray()) {
                set.add(ch);
            }
            common.retainAll(set);
        }

        // Convert to list and sort alphabetically
        List<Character> ch = new ArrayList<>(common);
        Collections.sort(ch);

        // Print result
        for (char chr : ch) {
            System.out.print(chr);
        }
    }
}
