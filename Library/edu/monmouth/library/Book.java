package edu.monmouth.library;

public class Book implements LibraryItem  {

	private String title, author;
	private int pages;
	private StatusType status;
	
	public Book(String title, String author, int pages, StatusType status) throws BookException{
		super();
		setTitle(title);
		setAuthor(author);
		setPages(pages);
		setStatus(status);
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) throws BookException{
		if (author == null || author.length() == BookConstants.MINLENGTH) {
			throw new BookException("The author field cannot be empty");
		}	
		else {
			this.author = author;
		}
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) throws BookException{
		if (pages >= BookConstants.MINPAGES) {
			this.pages = pages;
		}
		else {
			throw new BookException("The number of pages must be grater than 1");
		}
		
	}

	public StatusType getStatus() {
		return status;
	}

	public void setStatus(StatusType status) {
		this.status = status;
	}

	public void setTitle(String title) throws BookException{
		if (title == null || title.length() == BookConstants.MINLENGTH) {
			throw new BookException("The title field cannot be empty");
		}	
		else {
			this.title = title;
		}
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public boolean isAvailible() {
		if (status == StatusType.ONSHELF) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void borrowItem() {
		setStatus(StatusType.BORROWED);
	}

	@Override
	public void returnItem() {
		setStatus(StatusType.ONSHELF);
		
	}
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pages=" + pages + ", status=" + status + "]";
	}
	
}
