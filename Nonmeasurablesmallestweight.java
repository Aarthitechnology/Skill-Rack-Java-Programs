/*
 Non-Measurable Smallest Weight

8

A shop-keeper is having N integer values representing the measurement weights. He wishes to find the smallest integer value of weight that cannot be measured using these N weights. Please help the shop keeper by completing the program.

Boundary Condition(s):
1 <= N <= 1000
1 <= Each weight value <= 500

Input Format:
The first line contains N.
The second line contains the N integer values separated by a space.

Output Format:
The first line contains an integer value.

Example Input/Output 1:
Input:

2 41 10

Output:

Explanation:
1, 2, 4 and 10 can be measured using the given single measurement.
3 - 1 and 2
5 - 1 and 4
6 - 2 and 4
7 - 1, 2 and 4
8 - cannot be measured and hence is printed as the output.

Example Input/Output 2:
Input:

14243

Output:
15

5
 */
import java.util.*;
public class Nonmeasurablesmallestweight {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weight = new int[n];
        for(int i=0;i<n;i++)
        {
            weight[i] = sc.nextInt();
        }
        Arrays.sort(weight);
        int m = 1;
        int idx = 0;
        while(idx<n)
        {
            if(weight[idx]<=m)
            {
                m = m+weight[idx];
                idx++;
            }
            else
            {
                break;
            }
        }
        System.out.println(m);
    }
}
