package by.company.library.command.impl;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.service.ServiceFactory;
import by.company.library.service.exception.ServiceException;

public class AddNewBook implements Command {

	@Override
	public String execute(String request) throws CommandException {
		boolean result = false;
		String response = "";
		String title = "";
		String author = "";
		String publishingHouse = "";
		int numberOfPages = 0;
		double price = 0.0;
		boolean forAdults = false;

		String[] splittedRequest = request.split("\\s+");

		try {
			title = splittedRequest[1];
			author = splittedRequest[2];
			publishingHouse = splittedRequest[3];
			numberOfPages = Integer.parseInt(splittedRequest[4]);
			price = Double.parseDouble(splittedRequest[5]);
			forAdults = Boolean.parseBoolean(splittedRequest[6]);

		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			response = "Book adding error";
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		try {
			result = serviceFactory.getUpdateLiraryService().addNewBook(title, author, publishingHouse, numberOfPages,
					price, forAdults);

			if (result) {
				response = "Book added successfully";
			} else {
				response = "Book adding error";
			}
		} catch (ServiceException e) {

			response = "Book adding error";
		}

		return response;
	}

}
