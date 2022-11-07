package edu.monmouth.book;

public class Book {
	
	private double price;
	private BookTypes bookType;
	private int numberOfPages;
	private String title;
	
	
	public Book(int numberOfPages, BookTypes bookType, String title, double price) throws BookException
	{
		setnumberOfPages (numberOfPages);
		setBookType (bookType);
		setTitle (title);
		setPrice (price);
	}
	
	public int getnumberOfPages()
	{
		return numberOfPages;
	}
	
	public void setnumberOfPages(int numberOfPages) throws BookException 
	{
		if(numberOfPages < BookConstants.MIN_PAGES)
		{
			throw new BookException("Pages can NOT be less than 1.");
		}
		this.numberOfPages = numberOfPages;
	}
	
	public String getTitle() 
	{
		return title;
	}
	
	public void setTitle(String title) throws BookException
	{
		if(title == null )
		{
			throw new BookException("Book title can NOT be null.");
		}
		if(title.length() == 0)
		{
			throw new BookException("Book title can NOT be empty.");
		}
		this.title = title;
	}
	
	public BookTypes getBookType()
	{
		return bookType;
	}
	
	public void setBookType(BookTypes bookType) throws BookException
	{
		if(bookType == null)
		{
			throw new BookException("This book type does not exsist.");
		}
		this.bookType = bookType;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public double setPrice(double price) throws BookException
	{
		if(price <= BookConstants.MIN_PRICE)
		{
			throw new BookException("Price can NOT be a negative.");
		}
		return this.price = price;
	}

	@Override
	public String toString() 
	{
		return "Book [price = " + price + ", bookType = " + bookType + ", numberOfPages = " + numberOfPages + ", title = "
				+ title + "]";
	}
	
}
