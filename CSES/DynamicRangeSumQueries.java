/*Dynamic Range Sum Queries
 Time limit: 1.00 s
Memory limit: 512 MB

Given an array of n integers, your task is to process q queries of the following types:

update the value at position k to u
what is the sum of values in range [a,b]?

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
1 3 1
2 1 4

Output:
14
2
11
 */
import java.util.*;
import java.io.*;

public class DynamicRangeSumQueries {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int N = 1;
        while (N < n) N <<= 1;

        long[] segment = new long[2 * N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            segment[N + i] = Long.parseLong(st.nextToken());

        for (int i = N - 1; i >= 1; i--)
            segment[i] = segment[2 * i] + segment[2 * i + 1];

        StringBuilder out = new StringBuilder();

        char[] buffer = new char[100]; 
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 1) {
                update(segment, N + a - 1, b);
            } else {
                out.append(sum(segment, 1, 0, N - 1, a - 1, b - 1)).append("\n");
            }
        }

        System.out.print(out);
    }

    private static long sum(long[] segment, int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (nodeLeft > queryRight || nodeRight < queryLeft) return 0;
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) return segment[node];

        int mid = (nodeLeft + nodeRight) / 2;
        long left = sum(segment, node * 2, nodeLeft, mid, queryLeft, queryRight);
        long right = sum(segment, node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
        return left + right;
    }

    private static void update(long[] segment, int index, long value) {
        segment[index] = value;
        index /= 2;
        while (index >= 1) {
            segment[index] = segment[2 * index] + segment[2 * index + 1];
            index /= 2;
        }
    }
}
