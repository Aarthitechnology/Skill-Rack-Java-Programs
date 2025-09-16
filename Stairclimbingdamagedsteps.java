/*Stair Climbing - Damaged Stairs

1

There are N stairs to be climbed in a building. A robot can take only S different leaps each containing certain distinct steps which are passed as the
input. But T stairs are damaged and hence the robot cannot land on those stairs. The damaged stair numbers are passed as the input. The program
must print the number of way C of steps the robot can take to climb N stairs.

Boundary Condition(s):
1 <= N <= 50
1 <= S <= 10
1 <= T <= N

Input Format:
The first line contains N, S and T separated by a space.
The second line contains S integer values separated by a space.
The third line contains T integer values separated by a space.

Output Format:
The first line contains the C.

Example Input/Output 1:
Input:
521
23
2

Output:
1
Explanation:
There are 5 steps. The robot can take 2 or 3 steps at a time.
So the possible way is
32
(2 3 is not possible as step 2 is damaged.)

Example Input/Output 2:
Input:
10 23
23
246

Output:
2

Explanation:
The possible ways are
3 5 7 10
3 5 8 10   */
import java.util.*;
public class Stairclimbingdamagedsteps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // total stairs
        int s = sc.nextInt(); // number of leap types
        int t = sc.nextInt(); // number of damaged stairs

        int[] leap = new int[s];
        for(int i = 0; i < s; i++) {
            leap[i] = sc.nextInt();
        }

        boolean[] damaged = new boolean[n + 1];
        for(int i = 0; i < t; i++) {
            int d = sc.nextInt();
            damaged[d] = true; // mark damaged stairs
        }

        long[] ways = new long[n + 1];
        ways[0] = 1; // base case

        for(int step = 1; step <= n; step++) {
            if(damaged[step]) {
                ways[step] = 0; // cannot step on damaged stair
            } else {
                for(int idx = 0; idx < s; idx++) {
                    if(step >= leap[idx]) {
                        ways[step] += ways[step - leap[idx]];
                    }
                }
            }
        }

        System.out.println(ways[n]);
    }
}
