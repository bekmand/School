package StrengsøgningComparable;
//vises i undervisningen som eksempel på klasse, der implementerer Comparable
public class Bil implements Comparable<Bil>{
 
	 private int regnr;
	 
	 public Bil(int regnr){
		 this.regnr = regnr;
	 }
	 public void setRegnr(int regnr){
		 this.regnr  = regnr;
	 }
	 
	 public int getRegnr(){
		 return regnr;
	 }
	 
	 public int compareTo(Bil o){
		 if (this.regnr < o.getRegnr())
			 return -1;
			 else if (this.regnr > o.getRegnr())
				 return 1;
			 else return 0;
		 
		// return ((Integer)this.regnr).compareTo(o.getRegnr());
	 }
	 
	 public String toString(){
		 return "Bil med regnr: "+regnr;
	 }
	
	 
}
