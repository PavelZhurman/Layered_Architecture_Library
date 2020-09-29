package by.company.library.service.impl;

import by.company.library.bean.Book;
import by.company.library.dao.BookDao;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.UpdateLibraryService;
import by.company.library.service.exception.ServiceException;

public class BookServiceImpl implements UpdateLibraryService {

	@Override
	public boolean addNewBook(String title, String author, String publishingHouse, int numberOfPages, double price,
			boolean forAdults) throws ServiceException {
		boolean result = false;
		// parameters validation
		if (author == null || author == "" || author.isBlank()) {
			throw new ServiceException("There is no author of the book");
		}
		if (title == null || title == "" || title.isBlank()) {
			throw new ServiceException("There is no title of the book");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		BookDao bookDao = daoFactory.getBookDAO();
		result = true;
		try {
			bookDao.addBook(new Book (title,author, publishingHouse, numberOfPages, price, forAdults));
		} catch (DAOException e) {
			throw new ServiceException("An error occurred while adding the book");
		}

		return result;
	}

	@Override
	public Book findBookByTitle(String title, boolean isUserAdult) throws ServiceException {
		Book book = null;

		// parameters validation
		if (title == null || title == "" || title.isBlank()) {
			throw new ServiceException("Title is empty");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		try {
			
			book = daoFactory.getBookDAO().findBookByTitle(title);
			if (book == null) {
				throw new ServiceException("Book not found");
			}
			
			if (book.getForAdults() == isUserAdult) {
				return book;
			} else {
				throw new ServiceException("This user can't read this book");
			}
			
			
		} catch (DAOException e) {
			throw new ServiceException("An error occurred while finding the book");
		}

		
	}

	@Override
	public boolean deleteBookByTitle(String title) throws ServiceException {
		boolean result = false;

		// parameters validation
		if (title == null || title == "" || title.isBlank()) {
			throw new ServiceException("Title is empty");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		try {
			result = daoFactory.getBookDAO().deleteBookByTitle(title);
		} catch (DAOException e) {
			throw new ServiceException("An error occurred while deleting the book");
		}

		return result;
	}

}
