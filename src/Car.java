import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String brand;
	private String model;
	
	@ManyToOne
	private Person owner;
	
	public Car() {
		
	}
	
	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public Person getOwner() {
		return this.owner;
	}

}
