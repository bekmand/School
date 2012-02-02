package sk_7_8_OpgaverRekursivFortsat;

public class Opgave4 {
	
	public static void anagram(String prefix, String tekst){
		for(int i = 0; i<tekst.length(); i++){
			if(tekst.length() == 1){
				System.out.println(prefix + tekst);
			}
			else{
				anagram(prefix+tekst.substring(0,1), tekst.substring(1,tekst.length()));
				tekst = tekst.substring(1,tekst.length()) + tekst.substring(0, 1);
			}
		}
	}
	
	public static void main(String[] args) {
		
		anagram("","remmebov");
		
	}
}
