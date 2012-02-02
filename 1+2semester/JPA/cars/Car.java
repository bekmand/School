package cars;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	private String number;
	private String model;
	private int HP;
	
	public Car() {
	}
	
	public Car(String number, String model, int hP) {
		super();
		this.number = number;
		this.model = model;
		HP = hP;
	}

	public String getNumber() {
		return number;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	@Override
	public String toString() {
		return "Car [number=" + number + ", model=" + model + ", HP=" + HP
				+ "]";
	}
}
