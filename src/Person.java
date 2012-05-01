import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String firstname;
	private String lastname;
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
	private List<Car> cars = new ArrayList<Car>();
	
	public Person() {
		
	}
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return this.firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return this.lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public List<Car> getCars() {
		return this.cars;
	}
	
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
