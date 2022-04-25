package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_line_3 {
	public static void main(String[] args) {

	}
	
	static class Remote implements Comparable<Remote> {
		int employnum;
		int teamnum;
		String task;
		
		public Remote(int employnum, int teamnum, String task) {
			super();
			this.employnum = employnum;
			this.teamnum = teamnum;
			this.task = task;
		}

		@Override
		public int compareTo(Remote o) {
			return this.employnum-o.employnum;
		}
	}
	
	public int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        ArrayList<Remote> remote = new ArrayList<>();
        int[] employeesnum = new int[num_teams+1];
        int[] remotenum = new int[num_teams+1];
        
        for(int i=0; i<employees.length; i++) {
        	employeesnum[employees[i].charAt(0)-'0']++;
            boolean isRemote=true;
        	for(int j=0; j<office_tasks.length; j++) {
        		if(employees[i].contains(office_tasks[j])) {
        			isRemote=false;
        			break;
        		}
        	}
        	if(isRemote) {
        		remote.add(new Remote(i+1, employees[i].charAt(0)-'0',employees[i].substring(2)));
        		remotenum[employees[i].charAt(0)-'0']++;
        	}
        }

        Collections.sort(remote);
        for(int i=1; i<=num_teams; i++) {
        	if(employeesnum[i]==remotenum[i]) {
        		for(int j=0; j<remote.size(); j++) {
        			if(remote.get(j).teamnum==i) {
        				remote.remove(j);
        				break;
        			}
        		}
        	}
        }
        int[] answer = new int[remote.size()];
        for(int i=0; i<remote.size(); i++) {
        	answer[i]=remote.get(i).employnum;
        }
        return answer;
    }
}
