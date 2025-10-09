import java.util.*;
import java.io.*;

public class StaticRangeSumTwoTrees {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int N = 1;
        while (N < n) {
            N = N << 1;
        }

        // Two segment trees: one for odd positions, one for even
        long[] segOdd = new long[2 * N];
        long[] segEven = new long[2 * N];

        // Read input array
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            long val = Long.parseLong(st.nextToken());
            if ((i + 1) % 2 == 1) { // 1-based odd index
                segOdd[N + i] = val;
            } else {
                segEven[N + i] = val;
            }
        }

        // Build both segment trees
        for (int i = N - 1; i >= 1; i--) {
            segOdd[i] = segOdd[2 * i] + segOdd[2 * i + 1];
            segEven[i] = segEven[2 * i] + segEven[2 * i + 1];
        }

        StringBuilder out = new StringBuilder();

        // Process queries
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            long oddSum = rangeSum(segOdd, 1, 0, N - 1, left, right);
            long evenSum = rangeSum(segEven, 1, 0, N - 1, left, right);

            out.append(oddSum).append("\t").append(evenSum).append("\n");
        }

        System.out.println(out);
    }

    private static long rangeSum(long[] segment, int node, int nodeLeft, int nodeRight, int queryLeft, int queryRight) {
        if (nodeLeft > queryRight || nodeRight < queryLeft) {
            return 0;
        }
        if (queryLeft <= nodeLeft && nodeRight <= queryRight) {
            return segment[node];
        }
        int mid = (nodeLeft + nodeRight) / 2;
        long left = rangeSum(segment, node * 2, nodeLeft, mid, queryLeft, queryRight);
        long right = rangeSum(segment, node * 2 + 1, mid + 1, nodeRight, queryLeft, queryRight);
        return left + right;
    }
}
