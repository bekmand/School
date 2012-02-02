package stringeksempel;

public class StringEksempler {
	public int countDigits(String str){
		int antal = 0;
		for (int i =0; i<str.length();i++){
			char c = str.charAt(i);
			if (c>='0' && c<='9')
				antal++;
		}
			return antal;
	}
	
	public void count(String str){

		for (int i =0; i<str.length();i++){
			char c = str.charAt(i);
			if (c>='0' && c<='9')
				System.out.println(i);
		}
		
	}
	
	public  void spacePositions(String str){
		int i = str.indexOf(' ');
	
		while (i!= -1){
			System.out.println(i);
			i = str.indexOf(' ',i+1);
			
		}
	}
	
	public String insertSpace(String str){
		int  i = str.indexOf('.');
		while (i!=-1){
			str = str.substring(0,i+1)+ " "+ str.substring(i+1);
			i = str.indexOf('.', i+1);
		}
		return str;
	}
}
