package com.compositePrimaryKey.BookDetails;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.compositePrimaryKey.BookDetails.BooksDAO.BookDetailsDAO;
import com.compositePrimaryKey.BookDetails.Entities.*;

@SpringBootApplication
public class BookDetailsApplication implements CommandLineRunner{

	@Autowired
	private BookDetailsDAO bookDetailsDAO;
	public static void main(String[] args) {
		SpringApplication.run(BookDetailsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int choice=0;
		String title,language;
		double price;
		String loop="y";
		while(loop.equalsIgnoreCase("yes")||loop.equalsIgnoreCase("y")) {
			System.out.println("1.insert  2.find  3.update  4.delete  5.findByTitle  6.getBookByPrice");
			choice=scanner.nextInt();
			switch(choice) {
				case 1: 
					System.out.print("Enter Details\n  Enter book title: ");
					scanner.nextLine();
					title=scanner.nextLine();
					System.out.println(title);
					System.out.print("\n  Enter book language: ");
					language=scanner.next();
					System.out.print("\n  Enter book price: ");
					price=scanner.nextDouble();
					BookDetails bd=new BookDetails(title,language,price);
					bookDetailsDAO.saveBooks(bd);
					break;
					
				case 2:
					System.out.println("Enter Details\n  Enter book title: ");
					title=scanner.nextLine();
					scanner.nextLine();
					System.out.println("  Enter book language: ");
					language=scanner.nextLine();
					BookPrimaryKey bpk=new BookPrimaryKey(title,language);
					System.out.println(bookDetailsDAO.findBook(bpk));
					break;
				
				case 3:
					System.out.print("Enter Details\n  Enter book title: ");
					title=scanner.nextLine();
					scanner.nextLine();
					System.out.println("  Enter book language: ");
					language=scanner.nextLine();
					BookPrimaryKey upd_bpk=new BookPrimaryKey(title,language);
					BookDetails upd_bd=bookDetailsDAO.findBook(upd_bpk);
					System.out.println(upd_bd);
					System.out.println("Enter Details\n Enter new price: ");
					price=scanner.nextDouble();
					upd_bd.setPrice(price);
					bookDetailsDAO.updateBooks(upd_bd);
					break;
					
				case 4:
					System.out.println("Enter Details\n  Enter book title:");
					title=scanner.nextLine();
					scanner.nextLine();
					System.out.println("  Enter language: ");
					language=scanner.nextLine();
					BookPrimaryKey del_bpk=new BookPrimaryKey(title,language);
					bookDetailsDAO.deleteBookDetials(del_bpk);
					break;
					
				case 5:
					System.out.println("Enter book title: ");
					scanner.nextLine();
					title=scanner.nextLine();
					System.out.println(bookDetailsDAO.findByTitle(title));
					break;
					
				case 6:
					System.out.print("Enter base price: ");
					price=scanner.nextDouble();
					System.out.println(bookDetailsDAO.getBookByPrice(price));
					break;
					
			}
			System.out.println("Do you want to continue?...(if yes enter yes/y)");
			loop=scanner.next();
		}
	}

}
