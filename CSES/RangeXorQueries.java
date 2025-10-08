/*Range Xor Queries
 Time limit: 1.00 s
Memory limit: 512 MB

Given an array of n integers, your task is to process q queries of the form: what is the xor sum of values in range [a,b]?
Input
The first input line has two integers n and q: the number of values and queries.
The second line has n integers x_1,x_2,\dots,x_n: the array values.
Finally, there are q lines describing the queries. Each line has two integers a and b: what is the xor sum of values in range [a,b]?
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
3
0
6
4
 */
import java.util.*;
import java.io.*;
public class RangeXorQueries {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int N = 1;
        while(N<n)
        {
            N = N<<1;
        }
        long[] segment = new long[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            segment[N+i] = Long.parseLong(st.nextToken());
        }
        for(int i=N-1;i>=1;i--)
        {
            segment[i] = segment[2*i]^segment[2*i+1];
        }
        StringBuilder out = new StringBuilder();
        char[] buffer = new char[100];
        for(int i=0;i<q;i++)
        {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            out.append(xorsum(segment,1,0,N-1,left-1,right-1)).append("\n");
        }
        System.out.println(out);
    }
    private static long xorsum(long[] segment,int node,int nodeleft,int noderight,int queryleft,int queryright)
    {
        if(queryleft>noderight || queryright<nodeleft)
        {
            return 0;
        }
        if(queryleft<=nodeleft && noderight<=queryright)
        {
            return segment[node];
        }
        int mid = (nodeleft+noderight)/2;
        long left = xorsum(segment,node*2,nodeleft,mid,queryleft,queryright);
        long right = xorsum(segment,node*2+1,mid+1,noderight,queryleft,queryright);
        return left^right;
    }
}
