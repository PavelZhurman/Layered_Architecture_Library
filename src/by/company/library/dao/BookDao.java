package by.company.library.dao;

import by.company.library.bean.Book;
import by.company.library.dao.exception.DAOException;

public interface BookDao {

	public boolean addBook(Book book) throws DAOException;

	public Book findBookByTitle(String title, boolean isUserAdult) throws DAOException;

	public boolean deleteBookByTitle(String title) throws DAOException;

}
