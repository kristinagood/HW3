package edu.monmouth.hw3;

import edu.monmouth.book.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;



public class HW3 {
	
	public static void main(String[] args) {
		
		if (HW3Constants.DEBUG == false)
		{
		
		try {
			PrintStream newIO = new PrintStream(HW3Constants.LOGFILENAME);	
			System.setOut(newIO);
			System.setErr(newIO);
			} catch (FileNotFoundException e) 
			{
				System.err.println(e.getMessage() + "Cannot redirect STDERR or STDOUT");
				e.printStackTrace();
				System.exit(HW3Constants.REDIRECTFAILURE);
			}
		}
		//STRING
			List<String> stringArrayList = new ArrayList<String>();
				
			List<String> stringLinkedList = new LinkedList<String>();
	
		try {
					
			Scanner file = new Scanner(new File(HW3Constants.FILENAME1));

				while (file.hasNext()) 
				{
					String line = file.nextLine();

					System.out.println("Read '" + line + "' from " + HW3Constants.FILENAME1 + " file.");
					
					stringArrayList.add(line);
					
					stringLinkedList.add(line);
				}

				file.close();
				
			} catch (IOException e) {
				System.err.println("Failed to open '" + HW3Constants.FILENAME1 + "' file.");
				e.printStackTrace();
				System.exit(HW3Constants.REDIRECTFAILURE);
			}
		
		
		
		//BOOK
		List<Book> bookArrayList = new ArrayList<Book>();
		
		List<Book> bookLinkedList = new LinkedList<Book>();

		try {
			
			Scanner file = new Scanner(new File(HW3Constants.FILENAME2));

			while (file.hasNext()) {
				
				String line = file.nextLine();

				System.out.println("Read '" + line + "' from " + HW3Constants.FILENAME2 + " file.");

				String[] commas = line.split(HW3Constants.SEPARATOR);
		
				
				String title = commas[0];

				BookTypes bookType = null;
				bookType = BookTypes.valueOf(commas[1]);
				System.out.println(bookType);

				int numberOfPages = Integer.parseInt(commas[2]);

				double price = Double.parseDouble(commas[3]);

				try {
					
					Book book = new Book(numberOfPages, bookType, title, price);

					bookArrayList.add(book);

					bookLinkedList.add(book);
				} catch (BookException e) {
					System.err.println("FAILED TO CREATE.");
					e.printStackTrace();
				}
			}
			
			file.close();

		} catch (IOException e) {
			System.err.println("Failed to open '" + HW3Constants.FILENAME2 + "' file.");
			e.printStackTrace();
			System.exit(HW3Constants.REDIRECTFAILURE);
		}

		System.out.println("Empty string:\n" + stringArrayList.isEmpty());
		System.out.println("Empty book:\n" + bookArrayList.isEmpty());
		System.out.println("\n");
		
		
		System.out.println("Remove 1 string (using index) :\n" + stringArrayList.remove(1));
		System.out.println("Remove 1 book (using index) :\n" + bookArrayList.remove(1));
		System.out.println("\n");
		
		
		System.out.println("Size of string:\n" + stringArrayList.size());
		System.out.println("Size of book:\n" + bookArrayList.size());
		System.out.println("\n");

		
		for (String string : stringArrayList)
		{
			System.out.println(string);
		}
		System.out.println("\n");

		
		for (Book book : bookArrayList) 
		{
			System.out.println(book);
		}
		System.out.println("\n");
		
		
		
		Iterator<String> iterator1 = stringArrayList.iterator();

		System.out.println("Print values in order");

		while(iterator1.hasNext()) {

		           String value = iterator1.next();

		           System.out.println(value);
		}  



		ListIterator<String> iterator2 = stringArrayList.listIterator();

		System.out.println("Print values in order");

		while(iterator2.hasNext()) {

		           String value = iterator2.next();

		           System.out.println(value);

		}  
		System.out.println("Using ListIterator on stringArrayList in reverse order):");
			
			while (iterator2.hasPrevious()) 
			{
				System.out.println(iterator2.previous());
			}
		System.out.println("\n");

		
		
		ListIterator<Book> iterator3 = bookArrayList.listIterator();

		System.out.println("Print values in order");

		while(iterator3.hasNext()) {

		           Book value = iterator3.next();

		           System.out.println(value);

		} 
		System.out.println("Using ListIterator on bookArrayList in reverse order:");
		
			while (iterator3.hasPrevious()) 
			{
				System.out.println(iterator3.previous());
			}
				System.out.println("\n");

		
				
				ListIterator<String> iterator4 = stringLinkedList.listIterator();

				System.out.println("Print values in order");

				while(iterator4.hasNext()) {

				           String value = iterator4.next();

				           System.out.println(value);

				} 
		System.out.println("Using ListIterator on stringLinkedList in reverse order:");
				
			while (iterator4.hasPrevious()) 
			{
				System.out.println(iterator4.previous());
			}
		System.out.println("\n");

		
		
		ListIterator<Book> iterator5 = bookArrayList.listIterator();

		System.out.println("Print values in order");

		while(iterator5.hasNext()) {

		           Book value = iterator5.next();

		           System.out.println(value);

		} 
		System.out.println("Using ListIterator on bookLinkedList in reverse order:");
				
			while (iterator5.hasPrevious()) 
			{
				System.out.println(iterator5.previous());
			}	
		System.out.println("\n");

			
		System.out.println("Using iterator on stringLinkedList:");
			for (String string : stringLinkedList) 
			{
				System.out.println(string);
			}
		System.out.println("\n");

		
		System.out.println("Using iterator on bookLinkedList:");
			for (Book book : bookLinkedList) 
			{
				System.out.println(book);
			}
		System.out.println("\n");


		
	}

}
