package by.company.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.company.library.bean.Book;
import by.company.library.dao.BookDao;
import by.company.library.dao.exception.DAOException;

public class BookDaoImpl implements BookDao {

	private final String BOOK_FILE_PATH = "resources\\book.txt";

	@Override
	public boolean addBook(Book book) throws DAOException {
		boolean result = false;
		try (FileWriter writer = new FileWriter(BOOK_FILE_PATH, true)) {
			writer.write(book.getAuthor() + " " + book.getTitle() + " " + book.getPublishingHouse() + " "
					+ book.getNumberOfPages() + " " + book.getPrice() + " " + book.getForAdults() + "\n");
			result = true;

		} catch (IOException e) {
			throw new DAOException(e.getMessage());
		}
		return result;

	}

	@Override
	public Book findBookByTitle(String title, boolean isUserAdult) throws DAOException {
		Book book = null;
		String line;
		String[] splittedLine;

		try (FileReader fileReader = new FileReader(BOOK_FILE_PATH)) {
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			line = bufferedReader.readLine();

			while (line != null) {

				if (line.isBlank()) {
					line = bufferedReader.readLine();
				}

				splittedLine = line.split("\\s+");

				if (splittedLine[1].equals(title) && Boolean.parseBoolean(splittedLine[5]) == isUserAdult) {

					book = new Book(splittedLine[0], splittedLine[1], splittedLine[2],
							Integer.parseInt(splittedLine[3]), Double.parseDouble(splittedLine[4]),
							Boolean.parseBoolean(splittedLine[5]));

					return book;
				}

				line = bufferedReader.readLine();

			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e) {
			throw new DAOException(e.getMessage());
		}

		return book;
	}

	@Override
	public boolean deleteBookByTitle(String title) throws DAOException {
		boolean result = false;

		String line;
		String[] splittedLine;
		List<String> temp = new ArrayList<String>();

		try (FileReader fileReader = new FileReader(BOOK_FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {

			line = bufferedReader.readLine();

			while (line != null) {

				if (line.isBlank()) {
					line = bufferedReader.readLine();
				}

				splittedLine = line.split("\\s+");
				if (!(splittedLine[1].equals(title))) {
					temp.add(line);
					
				} else {
					result = true;
				}
				line = bufferedReader.readLine();
			}

		} catch (FileNotFoundException e) {
			throw new DAOException("File not found");
		} catch (IOException e) {
			throw new DAOException("IOException");
		}

		try (FileWriter fileWriter = new FileWriter(BOOK_FILE_PATH);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

			for (String str : temp) {
				bufferedWriter.write(str + "\n");
			}

		} catch (FileNotFoundException e) {
			throw new DAOException("File not found");

		} catch (IOException e) {
			throw new DAOException("IOException");
		}

		return result;
	}

}
