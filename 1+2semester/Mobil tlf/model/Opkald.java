package model;

public class Opkald {

	private Long tidStart;
	private boolean incommingCall, callAccpeted;
	private int nummer;
	private long callLength;
	
	public Opkald(boolean incommingCall, boolean callAccpeted, int nummer){
		this.incommingCall = incommingCall;
		this.callAccpeted = callAccpeted;
		this.nummer = nummer;
		setTidStart(System.nanoTime());
	}

	public void setTidStart(Long tidStart) {
		this.tidStart = System.nanoTime();
	}

	public Long getTidStart() {
		return tidStart;
	}

	public boolean isIncommingCall() {
		return incommingCall;
	}

	public void setCallAccpeted(boolean callAccpeted) {
		this.callAccpeted = callAccpeted;
	}

	public boolean isCallAccpeted() {
		return callAccpeted;
	}

	public int getNummer() {
		return nummer;
	}
	
	public void setCallLenght(){
		callLength = System.nanoTime() - tidStart;
	}
	
	public long getCallLenght(){
		return callLength;
	}
	
	public String getFormattedCallTime(){
		String strCallLength = "";
		int tmpCallLength = Integer.parseInt((callLength/1000000000)+"");

        int hours = (int)tmpCallLength / 3600;
        tmpCallLength %= 3600;

        int mins = tmpCallLength / 60;
        tmpCallLength %= 60;

        int secs = tmpCallLength;        
        
        if (hours != 0)
        	strCallLength += hours + ":";

         if (mins < 10)
        	 strCallLength += "0" + mins + ":";
         else
        	 strCallLength += mins + ":";

         if (secs < 10)
        	 strCallLength += "0" + secs;
         else
        	 strCallLength += secs;
       
		return strCallLength;
	}
	
}
