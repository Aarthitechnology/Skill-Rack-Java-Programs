import java.util.*;
public class SegmentTree {
 public static void main(String args[])
 {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int N = 1;
    while(N<n)
    {
        N<<=1;
    }
    int[] segment = new int[2*N];
    Arrays.fill(segment,Integer.MAX_VALUE);
    segment[0] = 0;
    for(int i=0;i<n;i++)
    {
        segment[N+i] = sc.nextInt();
    }
    for(int i=N-1;i>=1;i--)
    {
        segment[i] = Math.min(segment[i+i] , segment[i+i+1]);
    }
    for(int i=0;i<2*N;i++)
    {
        System.out.print(segment[i]+" ");
    }
 }   
}
