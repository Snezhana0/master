package domain;

public class Publish {
  // Идентификатор должности
  private Long id;
  // Наименование издательства
  private String namepublish;
  
  private String add;
  
  private String site;
  
  public Publish() {
  }
  
  public Publish(String namepublish) {
    this.namepublish = namepublish;
    }
  
  public Publish(Long id, String namepublish, String site, String add) {
    this.id = id;
    this.namepublish = namepublish;
    this.site = site;
    this.add = add;
    }
  
  public Long getId() {
    return id;
    }
    public void setId(Long id) {
    
    this.id = id;
    }
    
  public String getNamePublish() {
    return namepublish;
    }
  
  public void setNamePublish(String namepublish) {
    this.namepublish = namepublish;
    }
  
  public String getSite() {
    return site;
    }
  
  public void setSite(String site) {
    this.site = site;
    }
  
  public String getAdd() {
    return add;
    }
  
  public void setAdd(String add) {
    this.add = add;
    }

}
