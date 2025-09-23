/*Word Search in Matrix

The program must accept a character matrix of size R*C and a string S as input. The program must search the string S in the given R*C character matrix by traversing horizontally and vertically. If the string S is found in the matrix, the program must print yes. Else the program must print no as the output.

Boundary Condition(s):
2 <= R, C, Length of S <= 50

Input Format:
The first line contains R and C separated by a space.
The next R lines, each containing C characters separated by a space.
The (R+2)nd line contains the string S.

Output Format:
The first line contains the either yes or no.

Example Input/Output 1:
Input:
58
kertunop
rainqbow
vanguecl
rattongh
hwyfnxog
ringtone

Output:
yes

Explanation:
Here, the string ringtone is found in the given matrix and it is highlighted below.
kertunop
rainqbow
vanguecl
rattongh
hwyfnxog

Example Input/Output 2:
Input:
47
pokranw
meneerl
jhginov
adfqstc
engineering

Output:

no */
import java.util.*;
public class Wordsearchinmatrix {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt() , c = sc.nextInt();
        char[][] grid = new char[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        String str = sc.next();
        char[] arr = str.toCharArray();
        int[][] diff = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean there = false;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==arr[0])
                {
                    boolean[][] visited = new boolean[r][c];
                    visited[i][j]=true;
                    if(dfs(i,j,grid,visited,diff,arr,0))
                    {
                        there = true;
                        break;
                    }
                }
            }
        }
        if(there)
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
    private static boolean dfs(int r,int c, char[][] grid , boolean[][] visited,int[][] diff,char[] arr,int idx)
    {
        if(idx==arr.length-1)
        {
            return true;
        }
        for(int i=0;i<4;i++)
        {
            int row = r+diff[i][0];
            int col = c+diff[i][1];
            if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col])
            {
                continue;
            }
            if(grid[row][col] == arr[idx+1])
            {
                visited[row][col] = true;
                if(dfs(row,col,grid,visited,diff,arr,idx+1))
                {
                    return true;
                }
                visited[row][col] = false;
            }
        }
        return false;
    }
}
