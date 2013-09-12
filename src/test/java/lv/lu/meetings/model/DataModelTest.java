package lv.lu.meetings.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lv.lu.meetings.base.JpaBaseTest;
import lv.lu.meetings.domain.jpa.User;
import lv.lu.meetings.domain.jpa.venue.Category;
import lv.lu.meetings.domain.jpa.venue.Venue;

/**
 * Creates a full data structure with associations 
 * and then tests that data is correctly saved to and retrieved from database.
 * 
 * Only persistence and O/R mapping is tested there.
 */
public class DataModelTest extends JpaBaseTest{ 
    
	private static List<User> users;
	private static List<Category> categories;
	private static List<Venue> venues;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		JpaBaseTest.setUpBeforeClass();
		em.getTransaction().begin();
		
		users = createUsers(3);
		categories = createCategories(2);
		venues = createVenues(5);
		
		// TODO: Meeting, Invite, Attendance
		
		/* flush changes to data store and clear persistence context */		
		flushAndClear();
	}

    @AfterClass
	public static void tearDownAfterClass() {
		em.getTransaction().rollback();
		JpaBaseTest.tearDownAfterClass();
	}
	
	@Override @Before
	public void setUp() { /* nothing */ }
	
	@Override @After
	public void tearDown() {/* nothing */ }

	/**
	 * Data creation
	 */
	
	private static List<User> createUsers(int count) {
		List<User> users = new ArrayList<User>(count);
		for (int i = 0 ; i < count; i++){
		    users.add(createTestUser());	
		}	
		jpaDAO.saveAll(users);
		return users;
	}
	
    private static List<Category> createCategories(int count) {
        List<Category> categories = new ArrayList<Category>(count);
        for (int i = 0 ; i < count; i++){
            categories.add(createTestCategory());
        }
        jpaDAO.saveAll(categories);
        return categories;
    }
    
    private static List<Venue> createVenues(int count) {
        List<Venue> venues = new ArrayList<Venue>(count);
        for (int i = 0 ; i < count; i++){
            Category category = categories.get(i % categories.size());
            Venue venue = createTestVenue(category);
            venues.add(venue);
        }
        jpaDAO.saveAll(venues);
        return venues;
    }
    
    /**
     * Data loading and verification
     */

	@Test
	public void testUsers(){			
		List<User> usersFromDB = jpaDAO.findAll(User.class);
		assertEquals("Wrong number of users", users.size(), usersFromDB.size());

		for (int i = 0; i < users.size(); i++){
		    assertUsersEquals(users.get(i), usersFromDB.get(i));
		}
	}
	
	@Test
	public void testCategories(){            
	    List<Category> categoriesFromDB = jpaDAO.findAll(Category.class);
	    assertEquals("Wrong number of categories", categories.size(), categoriesFromDB.size());
	    
	    for (int i = 0; i < categoriesFromDB.size(); i++){
	        assertEquals(categories.get(i).getName(), categoriesFromDB.get(i).getName());  
	    }
	}
	
	@Test
	public void testVenues(){            
	    List<Venue> venuesFromDB = jpaDAO.findAll(Venue.class);
	    assertEquals("Wrong number of venues", venues.size(), venuesFromDB.size());
	    
	    for (int i = 0; i < venuesFromDB.size(); i++){
	        assertVenuesEquals(venues.get(i), venuesFromDB.get(i));  
	    }
	}
}
