import java.util.*;
import java.io.*;


public class BOJ11505 {
	
	static int N, M, K;
	static int[] leaf;
	static long[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (h+1);
		
		leaf = new int[N+1];
		tree = new long[treeSize];
		
		for (int i = 1; i <= N; i++) {
			leaf[i] = Integer.parseInt(br.readLine());
		}
		
		build(1, 1, N);
		
		StringBuilder sb = new StringBuilder();
		int commandCnt = M + K;
		for (int i = 0; i < commandCnt; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(1, 1, N, b, c);
			} else {
				sb.append(query(1, 1, N, b, c)).append("\n");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	private static long multiply(long a, long b) {
		long temp = (long) a * (long) b;
		return temp % 1_000_000_007;
	}
	
	private static void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = leaf[start];
			return;
		}
		
		int mid = (start + end) / 2;
		build(node * 2, start, mid);
		build(node * 2 + 1, mid + 1, end);
		
		tree[node] = multiply(tree[node*2], tree[node*2+1]);
	}
	
	private static long query(int node, int start, int end, int left, int right) {
		if (right < start || left > end) { // 범위 밖인 경우
			return 1;
		}
		
		if (left <= start && end <= right) { // 범위에 완전 포함되는 경우
			return tree[node];
		}
		
		// 범위에 일부 포함되는 경우
		int mid = (start + end) / 2;
		long leftVal = query(node * 2, start, mid, left, right);
		long rightVal = query(node * 2 + 1, mid + 1, end, left, right);
		
		return multiply(leftVal, rightVal);
	}
	
	private static void update(int node, int start, int end, int index, int val) {
		if (start == end) {
			tree[node] = val;
			return;
		}
		
		int mid = (start + end) / 2;
		
		if (start <= index && index <= mid) { // 왼쪽에 포함되는 경우
			update(node * 2, start, mid, index, val);
		} else { // 오른쪽에 포함되는 경우
			update(node * 2 + 1, mid + 1, end, index, val);
		}
		
		tree[node] = multiply(tree[node * 2], tree[node * 2 + 1]);
	}
}
