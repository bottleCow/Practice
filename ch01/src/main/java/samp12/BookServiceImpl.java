package samp12;

public class BookServiceImpl implements BookService{
	//dao객체 생성
	private BookDao bd;
	public void setBd(BookDao bd) {
		this.bd = bd;
	}

	public Book getBook() {
		return bd.getBook("Gatsby");
	}

}
