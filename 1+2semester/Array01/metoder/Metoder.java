package metoder;

public class Metoder {

		public String findStorStreng(String[] navne){
			String s = navne[0];
			for(int i = 0; i < navne.length; i++){
				if(s.compareTo(navne[i]) < 0){
					s = navne[i];
				}
			}	
			return s;	
		}
		
		public Integer findStorInteger(Integer[] tal){
			Integer max = tal[0];
			for(int i = 0; i < tal.length; i++){
				if(max.compareTo(tal[i]) < 0){
					max = tal[i];
				}
			}
			return max;
		}
		
		public Comparable findStorComparable(Comparable[] objekter){
			Comparable compare = objekter[0];
			for(int i = 0; i < objekter.length; i++){
				if(compare.compareTo(objekter[i]) < 0){
					compare = objekter[i];
				}
			}
			return compare;
		}
		
		public int findComparableLin(Comparable[] objekter, Comparable maal){
			boolean found = false;
			int i = 0;
			while(!found && i < objekter.length){
				Comparable compare = objekter[i];
				if(compare.compareTo(maal) == 0){
					found = true;
				}
				else
					i++;
			}
			if(found)
				return i;
			else
				return -1;
		}
}
