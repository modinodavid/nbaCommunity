package org.modino.nbaCommunity.nbaCommunity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;
import org.modino.nbaCommunity.dao.hibernate.HibernateUtil;
import org.modino.nbaCommunity.domain.pojo.Address;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.User;
import org.modino.nbaCommunity.domain.pojo.User.Type;
import org.modino.nbaCommunity.util.SaltAwareJdbcRealm;
//import javax.persistence.Query;

// Quitar de la clase que extienda //extends TestCase -> cuando se utilicen anotaciones como @Before ...
public class UserTest { 
		
	  	@Before public void setUp() throws Exception {  
		Session session = HibernateUtil.getSession();

	    // Begin a new local transaction so that we can persist a new entity
		session.getTransaction().begin();

	    // Read the existing entries
		Query q = session.createQuery("SELECT u FROM User u");

	    // Do we have entries?
		boolean createNewEntries = (q.list().size() == 0);

	    // No, so lets create new entries
	    if (createNewEntries) {
	      assertTrue(q.list().size() == 0);
	      User user = new User();
	      Address address = new Address();
	      address.setCountry("Spain");
	      address.setPostalCode("11111");
	      address.setProvince("Bizkaia");
	      address.setStreet("Iparraguirre street");
	      user.setAddress(address);
	      user.setAvatar("pepito");
	      user.setBirthday(new Date());
	      user.setEmail("pepe@aa.com");
	      user.setFirstName("Pepe");
	      user.setLastName("Gotera");
	      user.addLeague(new League());
	      user.setUsername("pepito");
	      String tempPassword = "aeiou";
	      ByteSource salt = SaltAwareJdbcRealm.RNG.nextBytes();
	      String hashedPasswordBase64 = new Sha256Hash(tempPassword, salt, 1024).toBase64();
	      System.out.println("hash code password: " + hashedPasswordBase64);
	      user.setPassword(hashedPasswordBase64);
	      user.setRepassword(hashedPasswordBase64);
	      user.setSalt(salt.toString());
	      user.setType(Type.Admin);
	      // save the object in the database
	      session.save(user);    
	    }

	    // Commit the transaction, which will cause the entity to
	    // be stored in the database
	    session.getTransaction().commit();

	    // It is always good practice to close the EntityManager so that
	    // resources are conserved.
	    session.close();

	  }

	  @Test public void checkAvailablePeople() {

	    // Now lets check the database and see if the created entries are there
		Session session = HibernateUtil.getSession();

	    // Perform a simple query for all the Message entities
	    Query q = session.createQuery("SELECT u FROM User u");

	    // We should have 1 User in the database
	    assertTrue(q.list().size() == 1);

	    session.close();
	  }

//	  @Test(expected = javax.persistence.NoResultException.class)
	  @Test
	  public void deleteUser() {
		Session session = HibernateUtil.getSession();
	    // Begin a new local transaction so that we can persist a new entity
		session.getTransaction().begin();
	   
		Query q = session.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.email = :email");
	    q.setParameter("username", "pepito");
	    q.setParameter("email", "pepe@aa.com");
	    
	    assertTrue(q.list().size() == 1);
	    
	    User user = (User) q.list().get(0);
	    session.delete(user);
	    session.getTransaction().commit();

	    // Check that doesn't exist the previuos object in the database
	    assertFalse(q.list().size() == 1);

	    session.close();
	  }
}
