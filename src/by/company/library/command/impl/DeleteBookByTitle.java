package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.exception.ServiceException;

public class DeleteBookByTitle implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String response = null;
		String[] splittedRequest;
		String title;

		splittedRequest = request.split("\\s+");

		title = splittedRequest[1];

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		try {
			if (serviceFactory.getUpdateLiraryService().deleteBookByTitle(title)) {
				response = "Book successfully deleted";
			} else {
				response = "An error ocured while deleting the book";
			}
		} catch (ServiceException e) {
			response = "Error";
		}

		return response;
	}

}
