package model_Listeksempler;

import java.util.ArrayList;
import java.util.Collections;

public class MetoderPaaArrayList
{
    /**
     * Udskriver listens elementer med et element per linje
     * @param list
     */
	public void udskrivHeltalsListe(ArrayList<Integer> list){
        for(int tal: list){
            System.out.println(tal);
    
        }
    } 
	 /**
     * Returnerer summen af elementerne i listen
     * @param list
     * @return summen
     */
    public int sumListe(ArrayList<Integer> list){
        int resultat = 0;
        for(int tal: list){
            resultat = resultat + tal;
        }
        return resultat;
    } 
    
    /**
     * Returnerer indeks for hvor det st�rste element kan findes i listen
     * Krav list er ikke tom
     * @param list
     * @return indeks
     */
    public int indeksForMaksimum(ArrayList<Integer> list){
        int maxIndex = 0;
        int i = 1;
        while(i<list.size()){
            if (list.get(i)> list.get(maxIndex))
            	maxIndex = i;
            i++;
        }
        return maxIndex;
    }
    
    /**
     * Opdaterer list s� f�rste og sidste tal i list er 0
     * Krav list er ikke tom
     * @param list
     */
    public void startOgSlutNul(ArrayList<Integer> list){
        list.set(0, 0);
        list.set(list.size()-1, 0);
    }
    
    /**
     * Her tager vi og sætter nr. 2 på arraylist til at være nr. 4 og omvendt 
     * @param list
     */
    
    public void ombyt (ArrayList<Integer> list){
    	    	Collections.swap(list,1,3);
    	    	System.out.println(list.get(1) + " " + list.get(3));
    }
    /**
     * 
     * Her tager vi alle de ulige tal på Arraylist<Integer> list, og addere +1 til dem
     * @param list
     */
    
    public void adderEnTilUlige(ArrayList<Integer> list){
    	int i = 0;
    	int i2;
    		while (i < list.size()) {
    			if (list.get(i) % 2 != 0) {
    				i2 = list.get(i);
    				i2++;
    				list.set(i, i2);
    			}
    			i++;
    	}
    }
    
    /*
    
    public Arraylist<Integer> enLigeListe(ArrayList<Integer> list){
    	
    }
    
    public void fjernNuller(ArrayList<Integer> list){
    	ListIterator<Integer> it = list.listIterator();
    	while(it.hasNext()){
    		int i = it.next();
    		if(i == 0)
    			it.remove();
    	}
    }
    */
 
}