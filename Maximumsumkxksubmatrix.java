/*Maximum Sum - K*K Sub-Matrix

The program must accept an integer matrix of size R*C and an integer K as the input. The program must print the sum of integers in the K*K sub-matrix which has the maximum sum S among the all possible K*K sub-matrices in the given R*C matrix as the output.

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
Input

10 20 80 40 55
90 50 90 200 65
60 20 5 20 12
10 50 40 60 8

4 5

2

Output:
25

3

Output:
567

Explanation:
The 3*3 sub-matrix which has the maximum sum is given below.
30 40 55
90 200 65
5 20 12

Example Input/Output 2:
Input
4 3
498
244
573
768
2
Output
25
 */
import java.util.*;
public class Maximumsumkxksubmatrix {
    public static void main(String args[])
    {
        Scanner sc =new Scanner(System.in);
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
        int max = Integer.MIN_VALUE;
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
                max = Math.max(max, sum);
            }
        }
        System.out.println(max);
    }
}
