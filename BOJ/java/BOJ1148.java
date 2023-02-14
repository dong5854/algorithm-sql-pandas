import java.util.*;
import java.io.*;

class Main {
	
	static List<Integer> list;
	static int N, K;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		list = new LinkedList<Integer>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i=1; i<=N; i++) {
			list.add(i);
		}
		sb.append("<");
		int toRemove = K;
		while (!list.isEmpty()) {
			sb.append(list.get(toRemove-1)).append(", ");
			toRemove += K;
			while (toRemove > list.size()) {
				if (list.isEmpty()) break;
				int tempDel = toRemove - K;
				toRemove -= list.size();
				for (int i = tempDel; i > 0; i -= K) {
					list.remove(i-1);
				}
			}
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append(">");
		
		System.out.println(sb);
	}
	
}