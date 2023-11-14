import java.io.*;
import java.util.*;

class BOJ1517 {
	
	static int N;
	// {idx, val}
	static int[][] a;
	static int[] tree;
	static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int height = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (height + 1);
		
		a = new int[N][2];
		tree = new int[treeSize];
		cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int idx = 0; idx < N; idx++) {
			int val = Integer.parseInt(st.nextToken());
			a[idx] = new int[]{idx, val};
		}
		
		Arrays.sort(a, (a, b) -> Long.compare(a[1], b[1]));
		
		long ans = 0;
		for (int i = 0; i < N; i++) {
			int idx = a[i][0];
			ans += query(1, 0, N-1, idx+1, N-1);
			update(1, 0, N-1, idx);
		}
		
		System.out.println(ans);
		
		br.close();
	}
	
	
	private static int query(int node, int start, int end, int targetStart, int targetEnd) {
		// 전부 포함되지 않는 경우
		if (end < targetStart || start > targetEnd) {
			return 0;
		}
		
		// 완전 포함되는 경우
		if (targetStart <= start && end <= targetEnd) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		int leftSum = query(node * 2, start, mid, targetStart, targetEnd);
		int rightSum = query(node * 2 + 1, mid+1, end, targetStart, targetEnd);
		
		return leftSum + rightSum;
	}
	
	private static void update(int node, int start, int end, int idx) {
		if (start == end) {
			tree[node] = 1;
			return;
		}
		
		int mid = (start + end) / 2;
		if (idx <= mid)
			update(node * 2, start, mid, idx);
		else
			update(node * 2 + 1, mid + 1, end, idx);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}