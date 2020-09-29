package by.company.library.controller;

import java.util.HashMap;
import java.util.Map;

import by.company.library.command.Command;
import by.company.library.command.exception.CommandException;
import by.company.library.command.impl.AddNewBook;
import by.company.library.command.impl.ChangeUserRole;
import by.company.library.command.impl.DeleteBookByTitle;
import by.company.library.command.impl.FindBookByTitle;
import by.company.library.command.impl.Logination;
import by.company.library.command.impl.Registration;

final class CommandProvider {
	final private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("LOGINATION", new Logination());
		commands.put("REGISTRATION", new Registration());
		commands.put("ADD_NEW_BOOK", new AddNewBook());
		commands.put("FIND_BOOK_BY_TITLE", new FindBookByTitle());
		commands.put("DELETE_BOOK_BY_TITLE", new DeleteBookByTitle());
		commands.put("CHANGE_USER_ROLE", new ChangeUserRole());
	}

	Command getCommand (String commandName) throws CommandException {
		Command command = commands.get(commandName);
		return command;
	}

}
