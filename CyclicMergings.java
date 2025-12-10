import java.util.*;
public class CyclicMergings {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int max = Integer.MIN_VALUE;
            int[] arr = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.nextInt();
                max = Math.max(max,arr[i]);
            }
            int cost=0;
            for(int i=0;i<n;i++)
            {
                int next=(i+1)%n;
                int maxi=0;
                maxi = Math.max(arr[i],arr[next]);
                cost+=maxi;
            }
            System.out.println(cost-max);
        }
    }
}
