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
public class TestEksComparable {

	public static void main(String[] args) {
		
		EksComparable ec = new EksComparable();
		//eks. med String objekter
		ArrayList<Comparable> list = new ArrayList<Comparable>();
		list.add("Peter");
		list.add("Søren");
		list.add("Hanne");
		list.add("Jens");
		
		String s = "Søren";
		
		System.out.println("Samme streng er fundet: "+ec.findSamme(list,s));
		
		//eks. med Integer objekter
		ArrayList<Comparable> listInteger = new ArrayList<Comparable>();
		listInteger.add(3);
		listInteger.add(5);
		listInteger.add(4);
		listInteger.add(8);
		
		Integer i = 8;
		
		System.out.println("Samme tal er fundet: "+ec.findSamme(listInteger,i));
		
		ArrayList<Comparable> listBiler = new ArrayList<Comparable>();
		listBiler.add(new Bil(500));
		listBiler.add(new Bil(300));
		
		System.out.println("Samme bil er fundet: "+ec.findSamme(listBiler,new Bil(300)));
	}
}
