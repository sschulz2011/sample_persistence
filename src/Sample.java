import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Sample {
	private static final String PERSISTENCE_UNIT_NAME = "sample";
	private static EntityManagerFactory factory;

	public static void main(String[] args) {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();

		// Begin transaction
		em.getTransaction().begin();
		
		// Create new Person
		Person maxMustermann = new Person("Max", "Mustermann");
		
		// Create some cars
		Car porsche911 = new Car("Porsche", "911");
		Car vwGolf = new Car("VW", "Golf");
		
		// Create car list
		List<Car> cars = new ArrayList<Car>();
		
		cars.add(porsche911);
		cars.add(vwGolf);
		
		// Assign car list to person
		maxMustermann.setCars(cars);	
		
		// save everything and close transaction
		em.persist(maxMustermann);
		
		em.getTransaction().commit();
		
		// Read the existing entries and write to console
		Query q = em. createQuery("select p from Person p");
		List<Person> personList = q.getResultList();
		System.out.println("name\t\tCar");
		System.out.println("---------------------------------");
		for (Person p : personList) {
			for (Car c : p.getCars()) {
				System.out.println(p.getFirstname() + " " + p.getLastname() + "\t" + c.getBrand() + " " + c.getModel());
			}
		}
		
		em.close();
	}
}
