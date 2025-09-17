/*In an amusement park at jooney's amusement, there is a weighted maze challenge. This consists of a set of east west roads and north south roads(referred to as up down roads). there are n intersections and each intersection has a block of iron bar, the weight of which is given.you enter the maze at top left corner. the exit from the maze is at bottom right corner. Movement at any intersection is to the right or down provided a road exisits int that direction
At each intersection you pass through , you must exchange the weight in your cart with the weight of the bar at the intersection if it is heavier that the weight you have in the cart.
The object is to determine a path through maze along the roads so that on can exit the maze with the minimum cart in the cart 
Example 1
4
1,8,21,7
19,17,10,20
2,18,23,22
14,25,4,13
output
22 */
import java.util.*;
public class Jooneysamusementpark {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] grid = new int[n][n];
        for(int i=0;i<n;i++)
        {
            String line = sc.nextLine().trim();
            String[] news = line.split(",\\s*");
            for(int j=0;j<n;j++)
            {
                grid[i][j] = Integer.parseInt(news[j]);
            }
        }
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for(int j=1;j<n;j++)
        {
            dp[0][j] = Math.max(grid[0][j],dp[0][j-1]);
        }
        for(int i=1;i<n;i++)
        {
            dp[i][0] = Math.max(grid[i][0],dp[i-1][0]);
        }
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n;j++)
            {
                int best = Math.min(dp[i-1][j],dp[i][j-1]);
                dp[i][j] = Math.max(grid[i][j],best);
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
