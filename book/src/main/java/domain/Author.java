package domain;
  

public class Author {
 
  private Long id;
  
  private String firstname;
  
  private String lastname;
  
  public Author() {
  }
  
  public Author(String firstname) {
    this.firstname = firstname;
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
  return "Автор {" + "Id: " + id + ", Имя: " + firstname + ", Фамилия: "+ lastname + "}";
  }

}