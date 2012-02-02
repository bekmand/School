package aflOpgEfterAar;

import java.util.Random;

public class Faelles {
	private int global = 0;
	private boolean[] flag = new boolean[2];
	private int turn;
	
	public synchronized void m1(){
		kritisksection();
	}
	
	public synchronized void m2(){
		kritisksection();
	}
	
	public void P0(){
		while(true){
			flag[0] = true;
			turn = 1;
			while(flag[1] && turn ==1)
				
				kritisksection();
			
			flag[0] = false;
		}
	}
	
	public void P1(){
		while(true){
			flag[1] = true;
			turn = 0;
			while(flag[0] && turn == 0)
				
				kritisksection();
			
			flag[1] = false;
		}
	}
	
	public void TagerRandomTid(int max){
		Random r = new Random();
		int nymax = Math.abs(r.nextInt())% max +1;
		int sum = 0;
		
		for(int i = 0; i<max; i++){
			for(int j = 0; j<max; j++){
			 	sum += nymax;
			}
		}
	}
	
	public int getGlobal(){
		return global;
	}
	
	public void kritisksection(){
		int temp;
		temp = global;
		TagerRandomTid(100);
		global = temp+1;
	}

}
