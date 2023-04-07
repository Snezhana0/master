package domain;

public class Book {
	 private Long id;

	 // Название
	 private String title;

	 // код книги
	 private String сode;

	 // год издания
	 private String yearpublish;

	 // количество страниц

	 private String countpage;
	 
	// тип переплёта

	 private String hardcover;
	 
	// реферат

	private String Abstract;
	
	// наличие на складе
	private String statuc;

	 // Внешний ключ -ссылка на сущность Author
	 private Long idAuthor;

	 // Навигационное свойства - ссылка на автора
	 private Author author;
	 
	 private Long idPublish;

	 // Навигационное свойства - ссылка на издательство
	 private Publish publish;
	 
	 public Book() {
	 }
	 
	 public Book(String title, String code, String yearpublish,
			 String countpage, String hardcover, String Abstract, String statuc,  Author author, Publish publish) {
			 this.title = title;
			 this.сode = code;
			 this.yearpublish = yearpublish;
			 this.countpage = countpage;
			 this.hardcover = hardcover;
			 this.Abstract = Abstract;
			 this.statuc = statuc;
			 this.author = author;
			 this.publish = publish;
			 }
	 
	 public Book(String title, String code, String yearpublish,
			 String countpage, String hardcover, String Abstract, String statuc,  Author author, Publish publish, Long idAuthor, Long idPublish) {
			 this.title = title;
			 this.сode = code;
			 this.yearpublish = yearpublish;
			 this.countpage = countpage;
			 this.hardcover = hardcover;
			 this.Abstract = Abstract;
			 this.statuc = statuc;
			 this.author = author;
			 this.publish = publish;
			 this.idAuthor = idAuthor;
			 this.idPublish = idPublish;
			 }
	 
	 public Book(Long id, String title, String code, String yearpublish,
			 String countpage, String hardcover, String Abstract, String statuc,  Author author, Publish publish, Long idAuthor, Long idPublish) {
		 	 this.id = id;
			 this.title = title;
			 this.сode = code;
			 this.yearpublish = yearpublish;
			 this.countpage = countpage;
			 this.hardcover = hardcover;
			 this.Abstract = Abstract;
			 this.statuc = statuc;
			 this.author = author;
			 this.publish = publish;
			 this.idAuthor = idAuthor;
			 this.idPublish = idPublish;
			 }
	 
	 public String geTtitle() {
		 return title;
		}
	public void setTitle(String title) {
		this.title = title;
		}
	 
	 public String getCode() {
		 return сode;
		}
	public void setCode(String сode) {
		this.сode = сode;
		}
	 
	 public String getYearpublish() {
		 return yearpublish;
		}
	public void setYearpublish(String yearpublish) {
		this.yearpublish = yearpublish;
		}
	 
	 public String getCountpage() {
		 return countpage;
		}
	public void setCountpage(String countpage) {
		this.countpage = countpage;
		}
		 
		 
	public String getHardcover() {
		return hardcover;
		}
	public void setHardcover(String hardcover) {
		this.hardcover = hardcover;
		}
		 
		 
	public String getAbstract() {
		return Abstract;
		}
	public void setAbstract(String Abstract) {
		this.Abstract = Abstract;
		}
		 
	public Author author () {
		return author;
		}
		 
	public Publish publish () {
		return publish;
		}
		 
	public Long getId() {
		return id;
		}
	public void setId(Long id) {
		this.id = id;
		}
		 
	public String getStatuc() {
		return statuc;
		}
	public void setStatuc(String statuc) {
		this.statuc = statuc;
		}
		 
		 
	public String getAuthor() {
		return author.getLastName();
		}
	public void setRole(Author author) {
		this.author = author;
		}
	public Long getIdAuthor() {
		return idAuthor;
		}
	public void setIdAuthor(Long idAuthor) {
		this.idAuthor = idAuthor;
		}
		 
		 
	public String getPublish() {
		return publish.getNamePublish();
		}
	public void setPublish(Publish publish) {
		this.publish = publish;
		}
	public Long getIdPublish() {
		return idPublish;
		}
	public void setIdPublish(Long idPublish) {
		this.idPublish = idPublish;
		}
	
	@Override
	public String toString() {
	return "Role {" + "Id: " + id +
	", Название:  " + title +
	", Код: " + сode +
	", Год публикации: " +  yearpublish +
	", Кол-во страниц: " + countpage + ", Переплёт: " + hardcover + ", Реферат: " + Abstract + ", Наличие:   "  +statuc +
	", Автор = " + getAuthor() + ", Издательство: " +  getPublish() +
	"}";
	}



}
