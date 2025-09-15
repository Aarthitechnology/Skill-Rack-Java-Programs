/*A game has a board with an RxC matrix having R rows and C columns containing positive integer values as cell values. A player can start from the cell S whose indices are passed as the input. The player can perform the following two navigations after collecting the points in the cell S.
- The player can move to the right cell.
- The player can move to the bottom cell
The player cannot come back to the previous row or column. The player navigates until he reaches the bottom-right cell. The program must print the maximum points a player can collect from the given RxC matrix as the output.

Boundary Condition(s):
2 <= R, C <= 100
1 <= Each integer value <= 1000

Input Format:
The first line contains R and C separated by a space.
The next R lines, each containing C integers separated by a space.
The (R+2)nd line contains two integers representing the indices of the cell S.

Output Format:
The first line contains the maximum points a player can collect from the given RxC matrix.

Example Input/Output 1:
Input
45
42961
79654
57388
74994
01

Output:
44

Explanation:
The navigation of the player to collect the maximum points from the cell S (0, 1) is highlighted below.
42961
79654
7388
74994
The maximum points a player can collect is 44 (2+9+7+4+9+9+4).
Hence the output is 44

Example Input/Output 2:
Input:
33
70 76 60
18 64 39
45 28 79
11

Output:
182
 */
import java.util.*;
public class CollectMaxfromaGivenCell {
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
	int x = sc.nextInt() , y = sc.nextInt();
        for(int i=x;i<r;i++)
        {
            for(int j=y;j<c;j++)
            {
                if(i==x && j==y)
                {
                    dp[i][j] = grid[i][j];
                }
                else if(i==x)
                {
                    dp[i][j] = dp[i][j-1]+grid[i][j];
                }
                else if(j==y)
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

