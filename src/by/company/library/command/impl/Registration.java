package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.exception.ServiceException;

public class Registration implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String response;

		String[] splittedRequest = request.split("\\s+");

		try {
			String login = splittedRequest[1];

			String password = splittedRequest[2];

			if (ServiceFactory.getInstance().getUserService().registration(login, password)) {
				response = "Registration successfull";	
			} else {
				response = "user with this login exists";
			}

			

		} catch (ServiceException | ArrayIndexOutOfBoundsException e) {
			response = "Error registration";
		}
		return response;
	}

}
