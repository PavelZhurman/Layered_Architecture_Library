package by.company.library.command.impl;

import by.company.library.bean.User;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.exception.ServiceException;

public class Logination implements Command {

	@Override
	public String execute(String request) throws CommandException {

		String login;
		String password;
		String response = null;

		User user;

		String[] splittedRequest = request.split("\\s+");

		try {
			login = splittedRequest[1];

			password = splittedRequest[2];

			user = ServiceFactory.getInstance().getUserService().logination(login, password);

			if (user != null) {

				response = "logged: " + user.getLogin() + ", is user Adult? " + user.getisAdult();
			} else {
				response = "Error logination";
			}

		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error logination";

		}

		// parse request and get parameters
//		/* stub  */ login = "asdfg";
//		/* stub  */ password = "qwerty";

		return response;
	}

}
