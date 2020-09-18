package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import by.company.library.bean.User;
import by.company.library.dao.UserDao;
import by.company.library.dao.exception.DAOException;

public class UserDaoImpl implements UserDao {

	private final String USER_FILE_PATH = "resources\\user.txt";

	@Override
	public boolean registerUser(String login, String password) throws DAOException {
		boolean registrationSuccess = false;

		try (FileWriter writer = new FileWriter(USER_FILE_PATH, true)) {

			writer.write(login + " " + password + " false\n\n");
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

			while (bufferedReader.readLine() != null) {

				String[] parametres = line.split("\\s+");

				if (parametres[0].equals(login) && parametres[1].equals(password)) {
					if (parametres[2].equals("false")) {
						return new User(parametres[0], parametres[1], false);
					} else {
						return new User(parametres[0], parametres[1], true);
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

}
