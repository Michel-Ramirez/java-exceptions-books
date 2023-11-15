package org.lessons.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.lessons.java.exceptions.Book;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner in = null;

		Book[] books = new Book[5];

		in = new Scanner(System.in);

		String userInp = null;
		int indexBooksList = 0;
		int moreBook = 0;

		while (true) {

			System.out.println("Inserisci Libro: \n" + "1 - Si \n" + "2 - No");
			userInp = in.nextLine();
			moreBook = Integer.valueOf(userInp);

			if (moreBook == 2) {
				System.out.println("FINE PROGRAMMA");
				break;
			}

			if (moreBook != 1)
				continue;

			try {

				System.out.print("Titolo: ");
				String title = in.nextLine();

				System.out.print("Autore: ");
				String auth = in.nextLine();

				System.out.print("Editore: ");
				String edit = in.nextLine();

				System.out.print("Numero di pagine: ");
				String strNpage = in.nextLine();
				int nPage = Integer.valueOf(strNpage);

				Book b = new Book(title, nPage, auth, edit);

				books[indexBooksList++] = b;

			} catch (Exception e) {

				System.err.println("Error: " + e.getMessage());
			} finally {
			}

		}

		if (in != null)
			in.close();

		System.out.println("\n----------------------\n");
		System.out.println("Print lista dei libri \n---------------------\n");
		System.out.println(Arrays.asList(books));

		// WRITE IN A FILE

		System.out.println("\n----------------------\n | INIZIO SCRITTURE SUL DISCO | \n----------------------\n");

		File bookListFile = new File("D:\\books-list.txt");

		FileWriter myWriter = null;

		try {

			myWriter = new FileWriter(bookListFile);

			for (Book book : books) {

				myWriter.write(book.toString() + "\n");
			}

		} catch (IOException e) {

			System.err.println("Erros while writing file " + e.getMessage());

		} finally {

			if (myWriter != null) {
				try {
					myWriter.close();
				} catch (IOException e) {

				}

			}
		}

		System.out.println("\n----------------------\n | FINE SCRITTURE | \n----------------------\n");

		// READ

		System.out.println("\n----------------------\n | INIZIO SCRITTURE | \n----------------------\n");

		Scanner reader = null;

		try {

			reader = new Scanner(bookListFile);

			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				System.out.println(data);
			}

		} catch (FileNotFoundException e) {

			System.err.println("Error while reading file: " + e.getMessage());

		} finally {

			if (reader != null)
				reader.close();
		}

		System.out.println("FINE LETTURA \n----------------------\n");

	}

}