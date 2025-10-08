/*List Removals
 Time limit: 1.00 s
Memory limit: 512 MB

You are given a list consisting of n integers. Your task is to remove elements from the list at given positions, and report the removed elements.
Input
The first input line has an integer n: the initial size of the list. During the process, the elements are numbered 1,2,\dots,k where k is the current size of the list.
The second line has n integers x_1,x_2,\dots,x_n: the contents of the list.
The last line has n integers p_1,p_2,\dots,p_n: the positions of the elements to be removed.
Output
Print the elements in the order they are removed.
Constraints

1 \le n \le 2 \cdot 10^5
1 \le x_i \le 10^9
1 \le p_i \le n-i+1

Example
Input:
5
2 6 1 4 2
3 1 3 1 1

Output:
1 2 2 6 4

Explanation: The contents of the list are [2,6,1,4,2], [2,6,4,2], [6,4,2], [6,4], [4] and [].
 */
import java.util.*;
import java.io.*;
public class ListRemovals {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int N = 1;
        while(N<n)
        {
            N=N<<1;
        }
        long[] arr = new long[N];
        long[] segment = new long[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            arr[i] = Long.parseLong(st.nextToken());
            segment[N+i] = 1;
        }
        for(int i=N-1;i>=1;i--)
        {
            segment[i] = segment[2*i] + segment[2*i+1];
        }
        StringBuilder out = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        {
            int k = Integer.parseInt(st.nextToken());
            int ans = find(segment,1,0,N-1,k);
            out.append(arr[ans]).append(" ");
        } 
        System.out.println(out);
    }
    private static int find(long[] segment,int node,int nodeleft,int noderight,int k)
    {
        if(k==1 && nodeleft==noderight && segment[node]!=0)
        {
            segment[node] = 0;
            return nodeleft;
        }
        int mid = (nodeleft+noderight)/2;
        int ans = 0;
        if(segment[2*node]>=k)
        {
            ans = find(segment,2*node,nodeleft,mid,k);
        }
        else
        {
            ans = find(segment,2*node+1,mid+1,noderight,k-(int)segment[2*node]);
        }
        segment[node] = segment[2*node]+segment[2*node+1];
        return ans;
    }
}
