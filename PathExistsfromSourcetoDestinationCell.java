/*Path Exists from Source to Destination Cell

The program must accept a matrix of size R*C and the indices of two cells (Source and Destination) in the matrix as the input. The matrix contains only 1's and O's. The cell value 1 indicates the presence of a path. The cell value 0 indicates the presence of a stone (i.e., no path). The movement from one cell to
another can be in the left, right, bottom and top directions. The program must print yes if there is a path from the given source cell to the destination cell. Else the program must print no as the output.

Boundary Condition(s):
2 <= R, C <= 50

Input Format:
The first line contains R and C separated by a space.
The next R lines, each containing C integers separated by a space.
The (R+2)nd line contains two integers representing the indices of the source cell.
The (R+3)rd line contains two integers representing the indices of the destination cell.

Output Format:
The first line contains yes or no.

Example Input/Output 1:
Input
4 5
10110
01011
11010
11111
11
14

Output:
ves

Explanation:
One of the possible paths from the source cell to the destination cell in the matrix is highlighted below.
10110
01011
11010
11111

Example Input/Output 2:
Input:
33
101
011
101
02
20

Output:
no
 */
import java.util.*;
public class PathExistsfromSourcetoDestinationCell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt(), col = sc.nextInt();
        int[][] grid = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int[][] diff = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int startrow = sc.nextInt(), startcol = sc.nextInt();
        int endrow = sc.nextInt(), endcol = sc.nextInt();

        visited[startrow][startcol] = true;

        if (dfs(startrow, startcol, grid, visited, diff, endrow, endcol)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    private static boolean dfs(int startrow, int startcol, int[][] grid, boolean[][] visited, int[][] diff, int endrow, int endcol) {
        for (int i = 0; i < 4; i++) {
            int row = startrow + diff[i][0];
            int col = startcol + diff[i][1];

            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == 0) {
                continue;
            }

            if (row == endrow && col == endcol) {
                return true;
            }

            visited[row][col] = true;

            if (dfs(row, col, grid, visited, diff, endrow, endcol)) {
                return true;
            } else {
                visited[row][col] = false; // backtrack
            }
        }
        return false;
    }
}
