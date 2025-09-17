/*Longest Common Signal

4

The program must accept the alphabets emitted by the two signal systems (S1, S2) as the input. The program must print the length of the longest common signal emitted by these two signal systems
as the output.

Boundary Condition(s):
1 <= Length of S1, S2 <= 10^4

Input Format:
The first line contains S1.
The second line contains S2.

Output Format:
The first line contains the length of the longest common signal emitted by the two signal systems.

Example Input/Output 1:
Input:
nose

raise

Output:
2

Explanation:
se is the longest common signal whose length is 2.

Example Input/Output 2:
Input:
abcdelkgxwvu
abclkgxyz

Output:
4 */
import java.util.*;
public class Longestcommonsignal {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int n1 = s1.length() , n2 = s2.length();
        int maxlen = Integer.MIN_VALUE;
        int[][] dp = new int[n1+1][n2+1];
        for(int s1idx=1;s1idx<=n1;s1idx++)
        {
            for(int s2idx=1;s2idx<=n2;s2idx++)
            {
                if(s1.charAt(s1idx-1)==s2.charAt(s2idx-1))
                {
                    dp[s1idx][s2idx]=dp[s1idx-1][s2idx-1]+1;
                }
                else
                {
                    dp[s1idx][s2idx]=0;
                }
                maxlen = Math.max(maxlen,dp[s1idx][s2idx]);
            }
        }
        System.out.println(maxlen);
    }
}
