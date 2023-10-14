import java.io.*;
import java.util.*;

public class BOJ2042 {
	
	static int N, M, K;
	static long[] a;
	static long[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int height = (int) Math.ceil(Math.log(N) / Math.log(2));
		int treeSize = 1 << (height + 1);
		a = new long[N];
		tree = new long[treeSize];
		
		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(br.readLine());
		}
		
		build(1, 0, N-1);
		
		StringBuilder sb = new StringBuilder();
		int commmands = M + K;
		for (int i = 0; i < commmands; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				update(1, 0, N-1, b-1, c);
			} else {
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				sb.append(query(1, 0, N-1, b-1, c-1)).append("\n");
			}
		}
		
		System.out.println(sb);
		
		br.close();
	}
	
	// 세그먼트 트리 생성
	private static void build(int node, int start, int end) {
		if (start == end) {
			tree[node] = a[start];
			return;
		}
		
		int mid = (start + end) / 2;
		// left
		build(node * 2, start, mid);
		// right
		build(node * 2 + 1, mid + 1, end);
		
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	
	// 값 구하기
	private static long query(int node, int start, int end, int left, int right) {
		// 원하는 구간의 값을 포함하지 않는 경우
		if (right < start || end < left) {
			return 0;
		}
		
		// 원하는 구간에 완전히 포함된 경우
		if (left <= start && end <= right) {
			return tree[node];
		}
		
		// 원하는 구간의 값이 일부만 포함된 경우
		int mid = (start + end) / 2;
		long leftSum = query(node * 2, start, mid, left, right);
		long rightSum = query(node* 2 + 1, mid + 1, end, left, right);
		
		return leftSum + rightSum;
	}
	
	// 값 업데이트 하기
	private static void update(int node, int start, int end, int index, long val) {		
		if (start == end) {
			tree[node] = val;
			return;
		}
		
		int mid = (start + end) / 2;
		if (start <= index && index <= mid) {	// 왼쪽에 포함된 경우
			update(node * 2, start, mid, index, val);
		} else {	// 오른쪽에 포함된 경우
			update(node * 2 + 1, mid + 1, end, index, val);
		}
		
		tree[node] = tree[node*2] + tree[node*2 + 1];
	}
}
