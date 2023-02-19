import java.io.*;
import java.util.*;
class BOJ16562 {

	static int N, M, K;

	static class UnionFind {
		private int[] root;
		private int[] fee;

		public UnionFind(int size, int[] fee) {
			this.root =  new int[size];
			this.fee = fee;
			for (int i = 0; i < size; i++) {
				root[i] = i;
			}
		}

		public int find(int x) {
			if (x == root[x]) {
				return x;
			}
			return root[x] = find(root[x]);
		}
		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (fee[rootX] <= fee[rootY]) {
				root[rootY] = rootX;
			} else {
				root[rootX] = rootY;
			}
		}

		public int fee(int x) {
			return this.fee[x];
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		UnionFind unionFind = new UnionFind(N+1, A);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			unionFind.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int sum = 0;
		for (int i=1; i<=N; i++) {
			int tempParent = unionFind.find(i);
			if (tempParent != 0) {
				sum += unionFind.fee(tempParent);
				unionFind.union(0, tempParent);
			}
		}

		if (sum <= K) {
			System.out.println(sum);
		} else {
			System.out.println("Oh no");
		}
	}
}

