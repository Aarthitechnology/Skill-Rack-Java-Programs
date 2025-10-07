/*Dynamic Range Minimum Queries
 Time limit: 1.00 s
Memory limit: 512 MB

Given an array of n integers, your task is to process q queries of the following types:

update the value at position k to u
what is the minimum value in range [a,b]?

Input
The first input line has two integers n and q: the number of values and queries.
The second line has n integers x_1,x_2,\dots,x_n: the array values.
Finally, there are q lines describing the queries. Each line has three integers: either "1 k u" or "2 a b".
Output
Print the result of each query of type 2.
Constraints

1 \le n,q \le 2 \cdot 10^5
1 \le x_i, u \le 10^9
1 \le k \le n
1 \le a \le b \le n

Example
Input:
8 4
3 2 4 5 1 1 5 3
2 1 4
2 5 6
1 2 3
2 1 4

Output:
2
1
3
 */
import java.util.*;
import java.io.*;
public class DynamicRangeMinimumQueries {
    public static void main(String[] args) throws IOException
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
            segment[i] = Math.min(segment[2*i],segment[2*i+1]);
        }
        StringBuilder out = new StringBuilder();
        char[] buffer = new char[100];
        for(int i=0;i<q;i++)
        {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(type == 1)
            {
                update(segment,N+a-1,(long)b);
            }
            if(type == 2)
            {
                out.append(min(segment,1,0,N-1,a-1,b-1)).append("\n");
            }
        }
        System.out.println(out);
    }
    private static long min(long[] segment,int node,int nodeleft,int noderight,int queryleft,int queryright)
    {
        if(nodeleft>queryright || noderight<queryleft)
        {
            return Long.MAX_VALUE;
        }
        if(queryleft<=nodeleft && noderight<=queryright)
        {
            return segment[node];
        }
        int mid = (nodeleft+noderight)/2;
        long left = min(segment,node*2,nodeleft,mid,queryleft,queryright);
        long right = min(segment,node*2+1,mid+1,noderight,queryleft,queryright);
        return Math.min(left,right);
    }
    private static void update(long[] segment,int idx,long val)
    {
        segment[idx] = val;
        for(idx/=2;idx>=1;idx/=2)
        {
            segment[idx] = Math.min(segment[idx*2],segment[idx*2+1]);
        }
    }
}
