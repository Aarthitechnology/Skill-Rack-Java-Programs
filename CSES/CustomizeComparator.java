/*Customize Operator */
import java.util.*;
public class CustomizeComparator {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            arr[i] = sc.nextInt();
            map.put(arr[i],i);
        }
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        for(int i=0;i<a.length;i++)
        {
            if(map.get(a[i]-'0') > map.get(b[i]-'0'))
            {
                System.out.println(new String(a));
                break;
            }
            else
            {
                System.out.println(new String(b));
                break;
            }
        }
    }
}
