/*
 * Created on 2005-04-15
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package StrengsøgningComparable;
import java.util.*;


/**
 * @author haso
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EksComparable {
	//<T> alle steder med Comparable for at undgå advarslen, men tages ikke med på 1. sem. 
	//public<T> Comparable<T> findSamme(ArrayList<Comparable<T>> list, Comparable<T> c) {
	
	public Comparable findSamme(ArrayList<Comparable> list, Comparable c) {
		boolean found = false;
		int i = 0;
		Comparable comp = null;
		while(!found && i<list.size()){
			comp = list.get(i);
			if (c.compareTo(comp) == 0) found = true;
			else i++;
		}
		
		if (found)return comp;
		else return null;
		 
	}

}
