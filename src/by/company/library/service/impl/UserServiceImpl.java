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
			registrationSuccess = userDAO.registerUser(login, password);

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

}
