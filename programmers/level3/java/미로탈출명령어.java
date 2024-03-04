class 미로탈출명령어 {
	
	// 정답을 찾은 경우
	boolean solved = false;
	
	// 하, 좌, 우, 상 (알파벳 순서)
	int[] dx = {1,0,0,-1};
	int[] dy = {0,-1,1,0};
	char[] dc = {'d', 'l', 'r', 'u'};
	
	// 격자
	int n,m;
	
	// 시작, 도착
	int sx, sy, ex, ey;
	
	// 이동횟수
	int k;
	
	// 정답
	String answer = "impossible";
	
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
    	this.n = n;
    	this.m = m;
    	this.sx = x;
    	this.sy = y;
    	this.ex = r;
    	this.ey = c;
    	this.k = k;
    	if (sx == ex && sy == ey) return "";
        if(!canArrival(sx,sy,k)) return answer;
    	dfs(k - 1, sx, sy, "");
        return this.answer;
    }
    
    //거리, 움직일 횟수
    public boolean canArrival(int cx, int cy, int k){
        int d = getD(cx,cy,ex,ey);
        if(d > k || (k-d) % 2 == 1 )return false;
        else return true;
    }
    
    public int getD(int ax, int ay, int bx, int by){
        return Math.abs(ax - bx) + Math.abs(ay - by);
    }
    
    public void dfs(int cnt, int cx, int cy, String cur) {
    	if (cnt < 0 || solved) return;
    	for (int i = 0; i < 4; i++) {
    		if (solved) return; // 해결하면 더 이상 루프 필요 없음
    		int nx = cx + dx[i];
    		int ny = cy + dy[i];
    		if (nx < 1 || ny < 1 || nx > n || ny > m || !canArrival(nx,ny,cnt)) continue; //격자 밖
    		if (cnt == 0 && nx == ex && ny == ey) {	// 해결
    			this.solved = true;
    			this.answer = cur + dc[i];
    			return;
    		}
    		dfs(cnt - 1, nx, ny, cur + dc[i]);
    	}
    }
    
}