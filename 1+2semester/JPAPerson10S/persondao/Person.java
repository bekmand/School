package persondao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
	@Id
	@GeneratedValue
	private String id;
	private String navn;
	
	public Person(String navn) {
		this.navn = navn;
	}

	public Person() {
	}

	public String getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", navn=" + navn + "]";
	}
}
