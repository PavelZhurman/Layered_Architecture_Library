package by.company.library.command.impl;

import by.company.library.bean.Book;
import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.exception.ServiceException;

public class FindBookByTitle implements Command {

	@Override
	public String execute(String request) throws CommandException {
		String[] splittedRequest;
		String title;
		boolean isUserAdult = false;
		String response = "Error";
		
		splittedRequest = request.split("\\s+");
		title = splittedRequest[1];
		isUserAdult = Boolean.valueOf(splittedRequest[2]);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		try {
			Book book = serviceFactory.getUpdateLiraryService().findBookByTitle(title, isUserAdult);
			response = book.toString();
		} catch (ServiceException e) {
			response = "error";
		}
		
		return response;
	}

}
