package sK_1_2_opg3;

import java.sql.Date;
import java.util.ArrayList;

public class TestMinihandel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Vare v1 = new Vare(1, "v1", 0.25);
		Vare v2 = new Vare(2, "v2", 0.50);
		Vare v3 = new Vare(3, "v3", 1.00);
		Vare v4 = new Vare(4, "v4", 53.75);
		Vare v5 = new Vare(5, "v5", 256.50);

		Kunde k1 = new Kunde("Jane Jensen", new Date(1964, 5, 23));
		k1.setRabat(new ProcentRabat(15));
		
		Ordre o1 = new Ordre(1, k1);
		o1.createOrdreLinie(1, 8, v1);
		o1.createOrdreLinie(2, 1, v4);
		
		Ordre o2 = new Ordre(2, k1);
		o2.createOrdreLinie(1, 2, v5);
		o2.createOrdreLinie(2, 100, v2);

		
		Kunde k2 = new Kunde("Hans Kirk", new Date(1953, 12, 12));
		k2.setRabat(new FastRabat(100, 20));
		
		Ordre o3 = new Ordre(3, k2);
		o3.createOrdreLinie(1, 10, v3);
		o3.createOrdreLinie(2, 1, v4);
		o3.createOrdreLinie(3, 1, v5);
		
		Ordre o4 = new Ordre(4, k2);
		o4.createOrdreLinie(1, 50, v2);
		o4.createOrdreLinie(2, 1000, v1);
		
		Ordre o5 = new Ordre(5, k2);
		o5.createOrdreLinie(1, 10, v2);
		o5.createOrdreLinie(2, 5, v3);
		
		Ordre o6 = new Ordre(6, k2);
		o6.createOrdreLinie(1, 1, v5);
		
		ArrayList<Kunde> kunder = new ArrayList<Kunde>();
		
		kunder.add(k1);
		kunder.add(k2);
		
		for(int i = 0; i < kunder.size(); i++){
			System.out.println(kunder.get(i).getNavn() + " " + kunder.get(i).getRabat().rabatBeloeb(kunder.get(i).samletKoeb()));
		}
		
		
	}

}
