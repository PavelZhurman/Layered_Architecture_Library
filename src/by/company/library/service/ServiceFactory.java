package by.company.library.service;

import by.company.library.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	// private final UpdateLibraryService updateLiraryService = ...;
	private final UserService userService = new UserServiceImpl();

	public static ServiceFactory getInstance() {
		return instance;
	}

	// public UpdateLibraryService getUpdateLiraryService(){
	// return updateLiraryService;
	// }

	public UserService getUserService() {
		return userService;
	}

}
