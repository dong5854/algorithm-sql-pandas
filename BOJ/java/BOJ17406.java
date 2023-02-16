import java.io.*;
import java.util.*;


class Main {

	private static int N, M, K, result=Integer.MAX_VALUE;
	private static int [][]arr, copy;
	private static int [] r, c, s;

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());

		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());

		arr=new int[N+1][M+1];
		copy=new int[N+1][M+1];
		r=new int[K];
		c=new int[K];
		s=new int[K];

		for(int r=1;r<=N;r++) {
			st=new StringTokenizer(br.readLine());
			for(int c=1;c<=M;c++) {
				arr[r][c]=Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			r[i]=Integer.parseInt(st.nextToken());
			c[i]=Integer.parseInt(st.nextToken());
			s[i]=Integer.parseInt(st.nextToken());
		}
		permutation(K, new int[K], new boolean[K]);
		System.out.println(result);
	}

	public static void permutation(int cnt, int []choosed, boolean[]visited) {
		if(cnt==0) {
			for(int i=1;i<=N;i++) {
				copy[i]= Arrays.copyOf(arr[i], arr[i].length);
			}
			for(int i=0;i<choosed.length;i++) {
				int x=r[choosed[i]]-s[choosed[i]];
				int y=c[choosed[i]]-s[choosed[i]];

				for(int d=0;d<=s[choosed[i]];d++) {
					rotate(x+d,y+d,s[choosed[i]]-d);
				}

			}
			for(int x1=1;x1<=N;x1++) {
				int tmp=0;
				for(int y1=1;y1<=M;y1++) {
					tmp+=copy[x1][y1];
				}
				result=Math.min(result, tmp);
			}
			return;
		}

		for(int i=0;i<K;i++) {
			if (visited[i]) continue;
			visited[i]=true;
			choosed[choosed.length-cnt]=i;
			permutation(cnt-1, choosed, visited);
			visited[i]=false;
		}
	}

	public static void rotate(int R, int C, int S) {
		if(S==0) return;
		int keep=copy[R][C];
		for(int r=R+1;r<=R+2*S;r++) {
			copy[r-1][C]=copy[r][C];
		}

		for(int c=C+1;c<=C+2*S;c++) {
			copy[R+2*S][c-1]=copy[R+2*S][c];
		}
		for(int r=R+2*S-1;r>=R;r--) {
			copy[r+1][C+2*S]=copy[r][C+2*S];
		}
		for(int c=C+2*S-1;c>=C+1;c--) {
			copy[R][c+1]=copy[R][c];
		}
		copy[R][C+1]=keep;
	}
}