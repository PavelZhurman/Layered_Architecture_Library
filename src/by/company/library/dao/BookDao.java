package by.company.library.dao;

import by.company.library.bean.Book;
import by.company.library.dao.exception.DAOException;

public interface BookDao {
	
	public void addBook(Book book) throws DAOException;

}
