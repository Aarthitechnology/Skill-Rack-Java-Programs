import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;
public class StaticRangeMinimumQueriesusingsegmentedtree {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int N=1;
        while(N<n)
        {
            N<<=1;
        }
        int[] segment = new int[2*N];
        Arrays.fill(segment,Integer.MAX_VALUE);
        segment[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            segment[N+i] = Integer.parseInt(st.nextToken());
        }
        for(int i=N-1;i>=1;i--)
        {
            segment[i] = Math.min(segment[i+i],segment[i+i+1]);
        }
        StringBuilder out = new StringBuilder();
        while(q-->0)
        {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken())-1;
            int right = Integer.parseInt(st.nextToken())-1;
            out.append(find(segment,1,0,N-1,left,right)).append("\n");
        }
        System.out.println(out);
    }
    private static int find(int[] segment,int node,int nodeleft,int noderight,int queryleft,int queryright)
    {
        if(nodeleft>queryright || noderight<queryleft)
        {
            return Integer.MAX_VALUE;
        }
        if(queryleft<=nodeleft && noderight<=queryright)
        {
            return segment[node];
        }
        int mid = (nodeleft+noderight)/2;
        int left = find(segment,node+node,nodeleft,mid,queryleft,queryright);
        int right = find(segment,node+node+1,mid+1,noderight,queryleft,queryright);
        return Math.min(left,right);
    }
}
