package by.company.library.bean;

public class Book {

	private String title;
	private String author;
	private String publishingHouse;
	private int numberOfPages;
	private boolean forAdults;
	private double price;

	public Book() {
		this.title = "";
		this.author = "";
		this.publishingHouse = "";
		this.numberOfPages = 0;
		this.forAdults = true;
		this.price = 0;

	}

	public Book(String author, String title, String publishingHouse, int numberOfPages, double price,
			boolean forAdults) {
		this.title = title;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.numberOfPages = numberOfPages;
		this.forAdults = forAdults;
		this.price = price;

	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setForAdults(boolean forAdults) {
		this.forAdults = forAdults;
	}

	public boolean getForAdults() {
		return forAdults;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (title == null ? 0 : title.hashCode());
		result = prime * result + (author == null ? 0 : author.hashCode());
		result = prime * result + (publishingHouse == null ? 0 : publishingHouse.hashCode());
		result = prime * result + numberOfPages;
		result = prime * result + (forAdults ? 1231 : 1237);
		long temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;

		if (other.forAdults != forAdults)
			return false;

		if (other.title == null) {
			if (title != null)
				return false;

		} else if (!title.equals(other.title))
			return false;

		if (other.author == null) {
			if (author != null)
				return false;
		} else if (!other.author.equals(author))
			return false;

		if (other.publishingHouse == null) {
			if (publishingHouse != null)
				return false;

		} else if (!other.publishingHouse.equals(publishingHouse))
			return false;

		if (other.numberOfPages != numberOfPages)
			return false;

		if (Double.doubleToLongBits(other.price) != Double.doubleToLongBits(price))
			return false;

		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [title=" + title + ", author=" + author + ", publishingHouse=" + publishingHouse
				+ ", numberOfPages=" + numberOfPages + ", forAdults=" + forAdults + ", price=" + price + "]";
	}

}
