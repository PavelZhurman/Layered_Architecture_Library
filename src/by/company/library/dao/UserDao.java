package by.company.library.dao;

import by.company.library.bean.User;
import by.company.library.dao.exception.DAOException;

public interface UserDao {

	public boolean registerUser(String login, String password) throws DAOException;
	public User logination(String login, String password) throws DAOException;
	public boolean changeUserRole (String user, String newUserRole) throws DAOException;
	public boolean findUserByLogin (String login) throws DAOException;
	
}
