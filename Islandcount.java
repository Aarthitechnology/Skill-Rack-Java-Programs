/*Island Count

The program must accept an integer matrix of size R*C containing only 1's and O's as the input. 1 indicates land and 0 indicates water. The program must print the number of islands in the given matrix as the output. An island is surrounded by water and is formed by connecting adjacent lands horizontally
or vertically or diagonally.

Boundary Condition(s):
3 <= R, C <= 50

Input Format:
The first line contains R and C separated by a space.
The next R lines, each containing C integers separated by a space.

Output Format:
The first line contains the number of islands in the given matrix.

Example Input/Output 1:
Input:
56
010111
100111
100100
000101
011001

Output:
3
Explanation:
The 3 islands in the matrix are highlighted below.
010111
100111
100100
00010
01100

Example Input/Output 2:
Input:
64
0111
1010
1110
0001
0111
1111

Output:
1 */
import java.util.*;
public class Islandcount {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() , c = sc.nextInt();
        int[][] grid = new int[r][c];
        int[][] diff = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        int island = 0;
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
                if(grid[i][j] == 1)
                {
                    island++;
                    dfs(i,j,grid,diff);
                }
            }
        }
        System.out.println(island);
    }
    private static void dfs(int r,int c,int[][] grid,int[][] diff)
    {
        grid[r][c] = 0;
        for(int i=0;i<8;i++)
        {
            int row = r+diff[i][0];
            int col = c+diff[i][1];
            if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col]==0)
            {
                continue;
            }
            dfs(row,col,grid,diff);
        }
    }
}
