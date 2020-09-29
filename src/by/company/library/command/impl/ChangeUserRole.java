package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.exception.ServiceException;

public class ChangeUserRole implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String response = "error";
		String[] splittedRequest;
		
		splittedRequest = request.split("\\s+");
		
		String accessRole;
		
		String user;
		String newUserRole;
		
		user = splittedRequest[1];
		newUserRole = splittedRequest[2];
		accessRole = splittedRequest [3];
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		try {
			if (serviceFactory.getUserService().changeUserRole(user, newUserRole, accessRole)) {
				response = "Role successfully changed";
			} else {
				response = "role change error";
			}
		} catch (ServiceException e) {
			throw new CommandException (e);
		}
		
		
		return response;
	}

}
