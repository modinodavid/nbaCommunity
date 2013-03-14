package org.modino.nbaCommunity.nbaCommunity;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import junit.framework.TestCase;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.Before;
import org.junit.Test;
import org.modino.nbaCommunity.domain.pojo.Address;
import org.modino.nbaCommunity.domain.pojo.League;
import org.modino.nbaCommunity.domain.pojo.Team;
import org.modino.nbaCommunity.domain.pojo.User;
import org.modino.nbaCommunity.domain.pojo.User.Type;
import org.modino.nbaCommunity.util.SaltAwareJdbcRealm;

public class UserTest extends TestCase {

	private static final String PERSISTENCE_UNIT_NAME = "people";
	  private EntityManagerFactory factory;

	  @Before
	  public void setUp() throws Exception {
		  
	    factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	    EntityManager em = factory.createEntityManager();

	    // Begin a new local transaction so that we can persist a new entity
	    em.getTransaction().begin();

	    // Read the existing entries
	    Query q = em.createQuery("select u from user u");
	    // Persons should be empty

	    // Do we have entries?
	    boolean createNewEntries = (q.getResultList().size() == 0);

	    // No, so lets create new entries
	    if (createNewEntries) {
	      assertTrue(q.getResultList().size() == 0);
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
	      user.setLeague(new League());
	      user.setUsername("pepito");
	      String tempPassword = "aeiou";
	      ByteSource salt = SaltAwareJdbcRealm.RNG.nextBytes();
	      String hashedPasswordBase64 = new Sha256Hash(tempPassword, salt, 1024).toBase64();
	      user.setPassword(hashedPasswordBase64);
	      user.setRepassword(hashedPasswordBase64);
	      user.setSalt(salt.toString());
	      user.setTeam(new Team());
	      user.setType(Type.Admin);
	      // save the object in the database
	      em.persist(user);	     
	    }

	    // Commit the transaction, which will cause the entity to
	    // be stored in the database
	    em.getTransaction().commit();

	    // It is always good practice to close the EntityManager so that
	    // resources are conserved.
	    em.close();

	  }

	  @Test
	  public void checkAvailablePeople() {

	    // Now lets check the database and see if the created entries are there
	    // Create a fresh, new EntityManager
	    EntityManager em = factory.createEntityManager();

	    // Perform a simple query for all the Message entities
	    Query q = em.createQuery("select u from user u");

	    // We should have 1 User in the database
	    assertTrue(q.getResultList().size() == 1);

	    em.close();
	  }

	  @Test(expected = javax.persistence.NoResultException.class)
	  public void deleteUser() {
	    EntityManager em = factory.createEntityManager();
	    // Begin a new local transaction so that we can persist a new entity
	    em.getTransaction().begin();
	    Query q = em.createQuery("SELECT u FROM user u WHERE u.username = :username AND u.password = :password");
	    q.setParameter("username", "pepito");
	    q.setParameter("password", "aeiou");
	    User user = (User) q.getSingleResult();
	    em.remove(user);
	    em.getTransaction().commit();
	    User user2 = (User) q.getSingleResult();
	    // Check that doesn't exist the previuos object in the database
	    assertNull(user2);

	    em.close();
	  }
}
