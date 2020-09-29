package by.company.library.service.impl;

import by.company.library.bean.User;
import by.company.library.dao.DAOFactory;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;
import by.company.library.service.UserService;
import by.company.library.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

	@Override
	public boolean registration(String login, String password) throws ServiceException {
		boolean registrationSuccess = false;

		// parameters validation
		if (login == null || login.isBlank()) {
			throw new ServiceException("incorrect login");
		}
		if (password == null || password.isBlank()) {
			throw new ServiceException("incorrect password");
		}

		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();

		try {
			if (!(userDAO.findUserByLogin(login))) {
			registrationSuccess = userDAO.registerUser(login, password);
			}
		} catch (DAOException e) {
			throw new ServiceException(e);

		}

		return registrationSuccess;
	}

	@Override
	public User logination(String login, String password) throws ServiceException {
		// parameters validation
		if (login == null || login.isBlank()) {
			throw new ServiceException("incorrect login");
		}
		if (password == null || password.isBlank()) {
			throw new ServiceException("incorrect password");
		}

		User loggedUser = null;

		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDao userDAO = daoFactory.getUserDAO();

		try {
			loggedUser = userDAO.logination(login, password);

		} catch (DAOException e) {
			throw new ServiceException(e);

		}
		return loggedUser;

	}

	@Override
	public boolean changeUserRole(String user, String newUserRole, String accessRole) throws ServiceException {
		boolean result = false;
		// parameters validation
		if (user == null || user.isBlank()) {
			throw new ServiceException("there is no information about who to change the role");
		}
		if (newUserRole == null || newUserRole.isBlank()) {
			throw new ServiceException("no information about the new role");
		}
		if (accessRole == null || accessRole.isBlank() || accessRole.equals("false")) {
			throw new ServiceException("no access to change roles");
		}
		
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		try {
			result = daoFactory.getUserDAO().changeUserRole(user, newUserRole);
		} catch (DAOException e) {
			throw new ServiceException (e);
		}
		

		return result;
	}

}
