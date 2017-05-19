package beans;

import javax.servlet.http.HttpServletRequest;

public class Bookbean {
	private String id;
	private String book_title;
	private String author_name;
	private String publisher_name;
	private String publisher_year;
	private String isbn_code;






	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getAuthor_name() {
		return author_name;
	}
	public void setAuthor_name(String author_name) {
		this.author_name = author_name;
	}
	public String getPublisher_name() {
		return publisher_name;
	}
	public void setPublisher_name(String publisher_name) {
		this.publisher_name = publisher_name;
	}
	public String getPublisher_year() {
		return publisher_year;
	}
	public void setPublisher_year(String publisher_year) {
		this.publisher_year = publisher_year;
	}
	public String getIsbn_code() {
		return isbn_code;
	}
	public void setIsbn_code(String isbn_code) {
		this.isbn_code = isbn_code;
	}

	public static Bookbean cBookbean(HttpServletRequest request){
		Bookbean bookbean = new Bookbean();
        bookbean.setBook_title(request.getParameter("book_title"));
        bookbean.setAuthor_name(request.getParameter("author_name"));
        bookbean.setPublisher_name(request.getParameter("publisher_name"));
        bookbean.setPublisher_year(request.getParameter("publisher_year"));
        bookbean.setIsbn_code(request.getParameter("isbn_code"));


        return bookbean;

	}

}
