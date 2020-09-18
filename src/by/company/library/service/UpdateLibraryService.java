package by.company.library.service;

import by.company.library.service.exception.ServiceException;

public interface UpdateLibraryService {
	void addNewBook(String title, int price) throws ServiceException;
}
