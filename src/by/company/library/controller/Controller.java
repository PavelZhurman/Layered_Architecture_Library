package by.company.library.controller;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;

public class Controller {
	private final CommandProvider provider = new CommandProvider();

	public String doAction(String request) {
		String commandName;

		
		String[] parametres = request.split("\\s+");

		commandName = parametres[0];
		
		String response;
		try {
			Command command = provider.getCommand(commandName);
			response = command.execute(request);

		} catch (CommandException | NullPointerException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			// loggin
			// response with error massage is formed
			/* stub */response = "error";
		}

		return response;

	}
}
