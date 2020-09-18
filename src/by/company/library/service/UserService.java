package by.company.library.service;

import by.company.library.bean.User;
import by.company.library.service.exception.ServiceException;

public interface UserService {
	User logination(String login, String password) throws ServiceException;
	boolean registration (String login, String password) throws ServiceException;
}
