package by.company.library.main;

import java.util.Scanner;

import by.company.library.controller.Controller;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		Controller controller = new Controller();
		String line = "";
		String response = "";
		String[] splittedLine;
		String[] splittedResponse;
		boolean isLoggedIn = false;
		boolean isAdult = false;

		System.out.println("Available command options: \n" + "LOGINATION String_login Stirng_password \n"
				+ "REGISTRATION String_login Stirng_password \n"
				+ "ADD_NEW_BOOK String_title, String_author, String_publishingHouse, int_numberOfPages, double_price,"
				+ " boolean_forAdults \n" + "DELETE_BOOK_BY_TITLE String_title \n"
				+ "FIND_BOOK_BY_TITLE String_title \n" + "CHANGE_USER_ROLE String_user String_newUserRole");

		System.out.println("Please login to access the library");

		if (scanner.hasNextLine()) {
			line = scanner.nextLine();
		} else {
			System.out.println("An error has occured");
		}

		while (!line.equals("Exit") & !line.equals("EXIT") & !line.equals("exit")) {

			splittedLine = line.split("\\s+");

			if (isLoggedIn) {
				if (splittedLine[0].equals("FIND_BOOK_BY_TITLE")) {
					line = line + " " + isAdult;

				}

				if (splittedLine[0].equals("CHANGE_USER_ROLE")) {
					line = line + " " + isAdult;
				}
			}

			response = controller.doAction(line);
			splittedResponse = response.split("\\s+");
			if (splittedLine[0].equals("LOGINATION")) {
				if (splittedResponse[0].equals("logged:")) {
					isLoggedIn = true;
					if (splittedResponse[3].equals("true")) {
						isAdult = true;
					} else {
						isAdult = false;
					}

				}

			}
			if (isLoggedIn) {
				if (splittedLine[0].equals("FIND_BOOK_BY_TITLE")) {
					line = line + " " + isAdult;

				}

				if (splittedLine[0].equals("CHANGE_USER_ROLE")) {
					line = line + " " + isAdult;
				}
			}
			System.out.println(response);

			line = scanner.nextLine();

		}
		scanner.close();

	}

}
