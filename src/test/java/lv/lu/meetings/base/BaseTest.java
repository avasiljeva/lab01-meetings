package lv.lu.meetings.base;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import lv.lu.meetings.domain.jpa.User;
import lv.lu.meetings.domain.jpa.venue.Category;
import lv.lu.meetings.domain.jpa.venue.Venue;

/**
 * Base test containing the most common functions.
 */
public abstract class BaseTest {
    
    private static final Random RANDOM = new Random();
    
	protected static User createTestUser(){
		User user = new User();
		user.setUsername(generateRandomString());
		user.setPassword(generateRandomString());
		user.setFirstName(generateRandomString());
		user.setLastName(generateRandomString());
		return user;
	}
	
	protected static Category createTestCategory(){
	    Category category = new Category();
	    category.setName(generateRandomString());
        return category;
    }
	
	protected static Venue createTestVenue(Category category){
		Venue venue = new Venue();
		venue.setName(generateRandomString());
		venue.setLocation(generateRandomString());
		venue.setCategory(category);
		venue.setUrl(generateRandomString());
		venue.setUrl(generateRandomString());
		venue.setFoursquareId(generateRandomString());
		venue.setFoursquareUrl(generateRandomString());
		venue.setApproved(RANDOM.nextBoolean());
	    return venue;
	}
		
    private static String generateRandomString(){
        String random = Long.toString(Math.abs(RANDOM.nextLong()), 36);
        return random.substring(0,8);
    }
    
    protected void assertUsersEquals(User expected, User actual){
        assertEquals("User 'id' is wrong", expected.getId(), actual.getId());
        assertEquals("User 'username' is wrong", expected.getUsername(), actual.getUsername());
        assertEquals("User 'password' is wrong", expected.getPassword(), actual.getPassword());
        assertEquals("User 'first name' is wrong", expected.getFirstName(), actual.getFirstName());
        assertEquals("User 'last name' is wrong", expected.getLastName(), actual.getLastName());
    }
    
    protected void assertVenuesEquals(Venue expected, Venue actual){
        assertEquals("Venue 'id' is wrong", expected.getId(), actual.getId());
        assertEquals("Venue 'name' is wrong", expected.getName(), actual.getName());
        assertEquals("Venue 'location' is wrong", expected.getLocation(), actual.getLocation());
        assertEquals("Venue 'url' is wrong", expected.getUrl(), actual.getUrl());
        assertEquals("Venue 'foursquareId' is wrong", expected.getFoursquareId(), actual.getFoursquareId());
        assertEquals("Venue 'foursquareUrl' is wrong", expected.getFoursquareUrl(), actual.getFoursquareUrl());
        assertEquals("Venue 'approved' is wrong", expected.isApproved(), actual.isApproved());
        assertEquals("Venue 'category' is wrong", expected.getCategory().getName(), actual.getCategory().getName());
    }
}
