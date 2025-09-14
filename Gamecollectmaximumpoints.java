/*Game - Collect Maximum Points

A game has a board with an RxC matrix having R rows and C columns containing positive integer values as cell values. A player can start from the top-left cell and perform the following two navigations after collecting the points in that cell.
- The player can move to the right cell.
- The player can move to the bottom cell.
The player cannot come back to the previous row or column. The player navigates until he reaches the bottom-right cell. The program must print the maximum points a player can collect from the given RxC matrix as the output.

Boundary Condition(s):
2 <= R, C <= 50
0 <= Each integer value <= 1000

Input Format:
The first line contains R and C separated by a space.
The next R lines, each containing C integers separated by a space.

Output Format:
The first line contains the maximum points a player can collect from the given RxC matrix.

Example Input/Output 1:
Input:
45
42961
79654
57388
74994

Output:
53

Explanation:
The navigation of the player to collect the maximum points is given below.
4->7->9->7->4->9->9->4
The maximum points a player can collect from the 4x5 matrix is 53 (4+7+9+7+4+9+9+4).
Hence the output is 53

Example Input/Output 2:
Input:
33
48 64 47
63 33 14
44 82 52

Output:
289 */
import java.util.*;
public class Gamecollectmaximumpoints {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(),c = sc.nextInt();
        int[][] grid = new int[r][c];
        int[][] dp = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                grid[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j] = grid[i][j];
                }
                else if(i==0)
                {
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                }
                else if(j==0)
                {
                    dp[i][j] = dp[i-1][j]+grid[i][j];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }
        System.out.println(dp[r-1][c-1]);
        sc.close();
    }
}
