import java.util.Scanner;

import TO.User;
import services.BookServices;
import services.UserServices;

public class Runner {

	public static void main(String[] args) {

		int userchoice = 1;

		Scanner sc = new Scanner(System.in);
		while (userchoice != 3) {

			System.out.println("Select 1 for register, 2 for login , 3 for exit");
			userchoice = sc.nextInt();
			UserServices service = new UserServices();

			switch (userchoice) {
			case 1:
				service.register();
				break;

			case 2:
				User user = service.login();

				if (user != null && "admin".equals(user.getRole()))

				{

					System.out.println("Welcome to Osttra Book Store");
					int adminchoice = 3;
					while (adminchoice != 0) {
						System.out.println();
						System.out.println(
								" press 1 for adding book \n press 2 for seeing all books \n press 3 for updating book price \n press 4 for deleting a book(ID REQUIRED) \n press 5 for seeing book(id required)  \n press 6 for seeing all Users\n press "
								+ "0 for exit");

						adminchoice = sc.nextInt();
						BookServices bookser = new BookServices();
						switch (adminchoice) {

						case 1:

							bookser.storeBookInfo();

							break;

						case 2:
							bookser.getAllBooks();
							break;

						case 3:
							bookser.update();
							break;

						case 4:
							bookser.deleteInfo();
							break;

						case 5:
							bookser.getBook();
							break;
						case 6: service.getAllUsers();
							break;

						}

					}

				}

				else if (user != null && "customer".equals(user.getRole())) {
					
					System.out.println("Welcome to Osttra Book Store");
					
					int customerchoice = 1;

					while (customerchoice != 0) {
						System.out.println(
								"Press 5 for seeing all the books \n 6 for seeing specific book available \n 0 for exit");
						customerchoice = sc.nextInt();
						BookServices bookser = new BookServices();

						switch (customerchoice) {
						case 5:
							bookser.getAllBooks();
							break;

						case 6:
							bookser.getBook();
							break;
						case 0:
							break;

						}

					}

				}

				if (user == null)
					System.out.println("wrong credentials");

				break;

			case 3:
				System.out.println("BYE");
				break;
			}

		}

	}
}
