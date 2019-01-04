package net.app.DataApplicaion;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import app.dao.UserDAO;
import app.dto.Address;
import app.dto.Phone;
import app.dto.User;



public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address1 = null;
	private Phone phone1 = null;
	private Phone phone2 = null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("app");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
       public void testAddUser() {
		
		Instant  i = Instant.now();
	    user = new User() ;
	    user.setUsername("reenamehta11");
		user.setFirstName("test");
		user.setLastName("test");
		user.setPassword("Password@123");
		user.setCreatedOn(i);		
		user.setEmail("Abc12@gmail.com");
		user.setModifiedById(null);
		user.setModifiedOn(null);
		
		address1 = new Address() ;
		address1.setAddressLineOne("48500 156 Ave");
		address1.setAddressLineTwo("Apt 119");
		address1.setCity("Redmond");
		address1.setState("WA");
		address1.setCountry("usa	");
		address1.setPostalCode("98052");
		address1.setBilling(true);
		address1.setUser(user);
		Set<Address> addresses = new HashSet<Address>();
		addresses.add(address1);
		
		
		phone1= new Phone();
		phone2= new Phone();
		
		phone1.setPhoneNumber("3052976402");
		phone1.setPhoneType("Personal");
		phone1.setUser(user);
		Set<Phone> phones = new HashSet<Phone>();
		phones.add(phone1);
		phones.add(phone2);
		
		
		
		
		
		
		user.setAdresses(addresses);
		user.setPhones(phones);
		assertEquals("Failed to add the user!", true, userDAO.addUser(user));	
}
	
}