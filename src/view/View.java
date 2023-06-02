package view;

import java.sql.SQLException;
import java.util.Scanner;

import Controller.Control;

public class View {

	public View() throws ClassNotFoundException, SQLException {
		menu();
	}

	Scanner sc = new Scanner(System.in);
	Control c = new Control();
	boolean loop = true;

	public void menu() throws ClassNotFoundException, SQLException {
		while (loop) {
			try {
				System.out.println("      * * *           *  * *");
				System.out.println("    *       *       *        *");
				System.out.println("  *           *   *            *");
				System.out.println(" *              *               *");
				System.out.println("*                                *");
				System.out.println("*      WELCOME TO MY PROJECT     *");
				System.out.println(" *                               *");
				System.out.println("  *                             *");
				System.out.println("    *                         *");
				System.out.println("      *                     *");
				System.out.println("        *                 *");
				System.out.println("           *           *");
				System.out.println("              *     *");
				System.out.println("                 *");

				System.out.println("....................");
				System.out.println("1.Insert");
				System.out.println("2.Show");
				System.out.println("3.Update");
				System.out.println("4.Delete");
				System.out.println("5.Search");
				System.out.println("0.Exit");
				System.out.println("....................");

				System.out.print("Enter Your Choice : ");
				int ch = Integer.parseInt(sc.nextLine());

				switch (ch) {
				case 1:
					c.Insert();
					break;
				case 2:
					c.Show();
					break;
				case 3:
					c.Update();
					break;
				case 4:
					c.Delete();
					break;
				case 5:
					c.Search();
					break;
				case 0:
					System.out.println("thank you ~");
					loop = false;
					break;
				default:
					System.out.println("Wrong input...");
				}
			}

			catch (Exception e) {
				System.out.println("plz try Again ---~");
			}
		}
	}

}