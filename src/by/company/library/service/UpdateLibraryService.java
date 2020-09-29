package by.company.library.service;

import by.company.library.bean.Book;
import by.company.library.service.exception.ServiceException;

public interface UpdateLibraryService {
	boolean addNewBook(String title, String author, String publishingHouse, int numberOfPages, double price,
			boolean forAdults) throws ServiceException;

	Book findBookByTitle(String title, boolean isUserAdult) throws ServiceException;

	boolean deleteBookByTitle(String title) throws ServiceException;
}
