/*Iterations Count All Zero

Output:

The program must accept an integer matrix of size R*C and an integer K as the input. For each occurrence of K in the matrix, the program must replace K and all the adjacent non-zero cell values with zero which are to it's left, right, top and bottom. The program must repeat the process untill all the values become zero. The program must print how many times the process has to be performed to convert all the
cell values to zero.

Boundary Condition(s):
2 <= R. C <= 50

Input Format:
he first line contains R and C separated by a space.
aled by a space.
The next R lines, each containing C integers separated by a space.
The (R+2)"o line contains K.

Output Format:
The first line contains an integer representing the number of times the above process has to be performed to convert all the cell values to zero.

Example Input/Output 1:

55
56056
8802
5506
45550

Explanation:
fter performing the process for the first occurrence of 6, the matrix becomes
00056
00002
00006

00000
After performing the process for the second occurrence of 6, the matrix becomes
00000
00000
00000
00n00
00000
Now, all the cell values in the matrix become zero.
Hence the output is 2

Example Input/Output 2:
Input:
45
50056
0810
05006
45052

5

Output:
4 */
import java.util.*;
public class Iterationcountallzeros {
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
        int count=0;
        int[][] diff = new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==k)
                {
                    count++;
                    dfs(i,j,grid,diff);
                }
            }
        }
        System.out.println(count);
    }
    private static void dfs(int r,int c,int[][] grid,int[][] diff)
    {
        grid[r][c] = 0;
        for(int i=0;i<4;i++)
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
