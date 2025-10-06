/*Time limit: 1.00 s
Memory limit: 512 MB

You are given a map of a building, and your task is to count the number of its rooms. The size of the map is n \times m squares, and each square is either floor or wall. You can walk left, right, up, and down through the floor squares.
Input
The first input line has two integers n and m: the height and width of the map.
Then there are n lines of m characters describing the map. Each character is either . (floor) or # (wall).
Output
Print one integer: the number of rooms.
Constraints

1 \le n,m \le 1000

Example
Input:
5 8
########
#..#...#
####.#.#
#..#...#
########

Output:
3
 Solved using Iterative DFS
 ---------------------------*/
import java.util.*;
public class Countingrooms {
    public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt() , c = sc.nextInt();
		char[][] grid = new char[r][c];
		for(int i=0;i<r;i++)
		{
            String line = sc.next();
		    grid[i] = line.toCharArray();
		}
		int[][] diff = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
		boolean[][] visited = new boolean[r][c];
		int count = 0;
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(grid[i][j] == '.' && !visited[i][j])
				{
					iterativedfs(i,j,grid,visited,diff);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	private static void iterativedfs(int row,int col,char[][] grid , boolean[][] visited , int[][] diff)
	{
		visited[row][col] = true;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row,col});
        while(!stack.isEmpty())
        {
            int[] start = stack.pop();
            for(int i=0;i<4;i++)
            {
                int r = start[0]+diff[i][0];
                int c = start[1]+diff[i][1];
                if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && !visited[r][c] && grid[r][c]=='.')
                {
                    stack.push(new int[]{r,c});
                    visited[r][c] = true;
                }
            }
        }
	}

}
