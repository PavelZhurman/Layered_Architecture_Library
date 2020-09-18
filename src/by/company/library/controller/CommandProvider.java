package by.company.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.command.impl.AddNewBook;
import by.company.library.command.impl.Logination;
import by.company.library.command.impl.Registration;

final class CommandProvider {
	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("LOGINATION", new Logination());
		commands.put("REGISTRATION", new Registration());
		commands.put("ADD_NEW_BOOK", new AddNewBook());
	}

	Command getCommand (String commandName) throws CommandException {
		Command command = commands.get(commandName);
		return command;
	}

}
