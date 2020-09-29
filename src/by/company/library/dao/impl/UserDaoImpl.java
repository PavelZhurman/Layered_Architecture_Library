package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.company.library.bean.User;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;

public class UserDaoImpl implements UserDao {

	private final String USER_FILE_PATH = "resources\\user.txt";
	private final int USER_ID = 0;
	private final int PASSWORD_ID = 1;
	private final int ROLE_ID = 2;

	@Override
	public boolean registerUser(String login, String password) throws DAOException {
		boolean registrationSuccess = false;

		try (FileWriter writer = new FileWriter(USER_FILE_PATH, true)) {

			writer.write("\n" + login + " " + password + " false");
			registrationSuccess = true;

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}

		return registrationSuccess;
	}

	@Override
	public User logination(String login, String password) throws DAOException {

		try (FileReader reader = new FileReader(USER_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(reader)) {
			String line;

			line = bufferedReader.readLine();

			while (line != null) {

				if (line.isBlank()) {
					line = bufferedReader.readLine();
				}

				String[] parametres = line.split("\\s+");

				if (parametres[USER_ID].equals(login) && parametres[PASSWORD_ID].equals(password)) {
					if (parametres[ROLE_ID].equals("false")) {
						return new User(parametres[USER_ID], parametres[PASSWORD_ID], false);
					} else {
						return new User(parametres[USER_ID], parametres[PASSWORD_ID], true);
					}
				}
				line = bufferedReader.readLine();

			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return null;
	}

	@Override
	public boolean changeUserRole(String user, String newUserRole) throws DAOException {
		boolean result = false;
		String line;
		String[] splittedLine;
		List<String> temp = new ArrayList<String>();

		try (FileReader fileReader = new FileReader(USER_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			line = bufferedReader.readLine();

			while (line != null) {

				if (line.isBlank()) {
					line = bufferedReader.readLine();
				}

				splittedLine = line.split("\\s+");
				if (splittedLine[USER_ID].equals(user) && (!(splittedLine[ROLE_ID].equals(newUserRole)))) {

					temp.add(splittedLine[USER_ID] + " " + splittedLine[PASSWORD_ID] + " " + newUserRole);
					result = true;

				} else {
					temp.add(line);
				}
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		if (!result) {
			return result;
		}

		try (FileWriter fileWriter = new FileWriter(USER_FILE_PATH);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
			for (String str : temp) {
				bufferedWriter.write(str + "\n");
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}

		return result;
	}

	@Override
	public boolean findUserByLogin(String login) throws DAOException {
		boolean result = false;
		String[] splittedLine;
		String line;

		try (FileReader fileReader = new FileReader(USER_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			line = bufferedReader.readLine();

			while (line != null) {

				if (line.isBlank()) {
					line = bufferedReader.readLine();
				}
				
				splittedLine = line.split("\\s+");

				if (splittedLine[USER_ID].equals(login)) {
					result = true;
				}
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return result;
	}

}
