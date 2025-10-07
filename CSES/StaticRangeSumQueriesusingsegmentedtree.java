/*Static Range Sum Queries using segmented tree
Time limit: 1.00 s
Memory limit: 512 MB

Given an array of n integers, your task is to process q queries of the form: what is the sum of values in range [a,b]?
Input
The first input line has two integers n and q: the number of values and queries.
The second line has n integers x_1,x_2,\dots,x_n: the array values.
Finally, there are q lines describing the queries. Each line has two integers a and b: what is the sum of values in range [a,b]?
Output
Print the result of each query.
Constraints

1 \le n,q \le 2 \cdot 10^5
1 \le x_i \le 10^9
1 \le a \le b \le n

Example
Input:
8 4
3 2 4 5 1 1 5 3
2 4
5 6
1 8
3 3

Output:
11
2
24
4
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;
public class StaticRangeSumQueriesusingsegmentedtree {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int N = 1;
        while(N<n)
        {
            N=N<<1;
        }
        long[] segment = new long[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            segment[N+i] = Long.parseLong(st.nextToken());
        }
        for(int i=N-1;i>=1;i--)
        {
            segment[i] = segment[2*i]+segment[2*i+1];
        }
        StringBuilder out = new StringBuilder();
        while(q-->0)
        {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;
            out.append(rangesum(segment,1,0,N-1,left,right)).append("\n");
        }
        System.out.println(out);
    }
    private static long rangesum(long[] segment,int node,int nodeleft,int noderight,int queryleft,int queryright)
    {
        if(nodeleft>queryright || noderight<queryleft)
        {
            return 0;
        }
        if(queryleft<=nodeleft && noderight<=queryright)
        {
            return segment[node];
        }
        int mid = (nodeleft+noderight)/2;
        long left = rangesum(segment,node*2,nodeleft,mid,queryleft,queryright);
        long right = rangesum(segment,node*2+1,mid+1,noderight,queryleft,queryright);
        return left+right;
    }
}
