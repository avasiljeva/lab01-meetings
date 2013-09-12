package lv.lu.meetings.domain.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name = JPQConst.UserJpq.QUERY_GET_USER_BY_USERNAME, 
		query = "SELECT u FROM User u WHERE u.username = :username"),
	@NamedQuery(name = JPQConst.UserJpq.QUERY_GET_ID_BY_USERNAME, 
        query = "SELECT u.id FROM User u WHERE u.username = :username")		
})

/**
 * Portal user profile
 */
@Entity
public class User implements PersistentEntity {
	
	/**
	 * Persistent fields
	 */
	
	@Id @GeneratedValue
	private Long id;

	private String username;

	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	/**
	 * Getters and setters
	 */
	
	public Long getId() {
		return id;
	}	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
