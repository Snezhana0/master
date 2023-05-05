package domain;
  

public class Author {
 
	protected Long id;
	protected String firstname;
	protected String lastname;
	
	
	
	public Author(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		
	}

	public Author(Long id, String firstname, String lastname) {
		
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString() {
		return "Автор "+ id + firstname + lastname ;
	}

}
