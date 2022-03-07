package programmers;

class Solution_외벽점검 {
	
	static int n, answer;
	static int[] weak, dist;
	static int[][] weakcases;
	
	public int solution(int n, int[] weak, int[] dist) {
		this.weak=weak;
		this.dist=dist;
		this.n=n;
		answer=Integer.MAX_VALUE;
		
		weakcases=new int[weak.length][weak.length];
		makeWeak();
		makeDist(new boolean[dist.length], new int[dist.length], 0);
		
		return answer==Integer.MAX_VALUE ? -1 : answer;
	}

	
	//모든 dist케이스 만들기 
	private void makeDist(boolean[] visited, int[] distcase, int idx) {
		if(idx==dist.length) {
			for(int[] wc : weakcases) {
				chk(distcase, wc);
			}
		}
		
		for(int i=0; i<dist.length; i++) {
			if(!visited[i]) {
				visited[i]=true;
				distcase[idx]=dist[i];
				makeDist(visited, distcase, idx+1);
				distcase[idx]=0;
				visited[i]=false;
			}
		}
	}

	
	//모든 weakcase에 대해 모든 Distcase 검사 
	private void chk(int[] distcase, int[] weakcase) {
		int cur=0;
		int dist_idx=0;
		int next=0;
		
		while(cur<weakcase.length && dist_idx<distcase.length) {
			next=cur+1;
			while(next<weakcase.length && weakcase[cur]+distcase[dist_idx] >= weakcase[next]) next++;
			cur=next;
			dist_idx++;
		}
	
		if(cur==weakcase.length && dist_idx<answer) answer=dist_idx;
	}

	
	//모든 weak케이스 만들기 
	private void makeWeak() {
		int[] tmpweak = this.weak.clone();
		weakcases[0]=tmpweak.clone();
		
		for(int i=1; i<weak.length; i++) {
			int tmp = tmpweak[0];
			for(int j=1; j<weak.length; j++) {
				tmpweak[j-1] = tmpweak[j];
			}
			tmpweak[weak.length-1] = tmp+n;
			weakcases[i]=tmpweak.clone();
		}
	}
	
}