/*Minimum Sum - K*K Sub-Matrix

The program must accept an integer matrix of size R*C and an integer K as the input. The program must print the sum of integers in the K*K sub-matrix which has the minimum sum S among the all possible K*K sub-matrices of the given R*C matrix as the output.

Boundary Condition(s):
2 <= R, C <= 1000
2 <= K <= R and C

Input Format:
The first line contains R and C separated by a space.
The next R lines, each containing C integers separated by a space.
The (R+2)nd line contains K.

Output Format:
The first line contains S.

Example Input/Output 1:
Input:
54
8497
4052
3596
3004
8861
3
Output:
29

Explanation:
The 3*3 sub-matrix which has the minimum sum is given below.
405
359
300

Example Input/Output 2:
Input:
44
10 80 50 70
40 30 50 50
50 70 30 20
70 10 40 70

2

Output:
150 */
import java.util.*;
public class MinimumSumKxKSubMatrix {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() , c = sc.nextInt();
        int[][] grid = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int[][] dp = new int[r+1][c+1];
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=r;i++)
        {
            for(int j=1;j<=c;j++)
            {
                dp[i][j] = grid[i-1][j-1] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }
        for(int i=k;i<=r;i++)
        {
            for(int j=k;j<=c;j++)
            {
                int sum = dp[i][j] - dp[i-k][j] - dp[i][j-k] + dp[i-k][j-k];
                min = Math.min(min, sum);
            }
        }
        System.out.println(min);
    }
}
