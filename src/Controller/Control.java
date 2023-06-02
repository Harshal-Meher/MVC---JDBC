package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.xdevapi.PreparableStatement;

import model.Employee;

public class Control {
	Employee e[];

	public Control() {
		e = new Employee[50];
	}

	Scanner sc = new Scanner(System.in);
	int n = 0, k = 0;

	public static Connection connect() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/e1", uname = "root", pass = "abc123";

		Class.class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);

		return con;
	}

	public void Insert() throws SQLException, ClassNotFoundException {
		try {
			Loding();
			System.out.print("\nEnter the number of Employees:");
			n = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < n; i++) {
				System.out.print("Enter Your Id : ");
				int eid = Integer.parseInt(sc.nextLine());
				System.out.print("Enter your name : ");
				String name = sc.nextLine();
				System.out.print("Enter your Address : ");
				String address = sc.nextLine();
				System.out.print("Enter Your Salary : ");
				int salary = Integer.parseInt(sc.nextLine());

				e[i] = new Employee();
				e[i].setEid(eid);
				e[i].setName(name);
				e[i].setAddress(address);
				e[i].setSalary(salary);

				Connection con = Control.connect();// step 2

				PreparedStatement ps = con.prepareStatement("insert into t2 values(?,?,?,?)");
				ps.setInt(1, eid);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setInt(4, salary);

				int a = ps.executeUpdate();

				if (a > 0) {
					System.out.println("Data Insert ~ ");
				} else {
					System.out.println("Data Not Insert ~");
				}
			}
		}

		catch (Exception e) {
			System.out.println("Exception " + e);
		}
		System.out.println("...................................|");
	}

	public void Show() throws ClassNotFoundException, SQLException {

		Connection con = Control.connect();// step 2

		PreparedStatement ps = con.prepareStatement("select * from  t2 ");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			System.out.println("Eid : " + rs.getInt(1) + " , Name : " + rs.getString(2) + "\nAddress : "
					+ rs.getString(3) + ", Salary : " + rs.getInt(4) + "");
			System.out.println("...........................|");
		}
	}

	public void Update() throws ClassNotFoundException, SQLException {
		try {
			System.out.println("Enter Eid : ");
			int i = Integer.parseInt(sc.nextLine());
			Loding();

			System.out.println("\nEnter Update name : ");
			String un = sc.nextLine();

			Connection con1 = Control.connect();// step 2

			PreparedStatement ps1 = con1.prepareStatement("update t2 set name='" + un + "' where eid=" + i + "");

			int a = ps1.executeUpdate();
			if (a > 0) {
				System.out.println("Update name ~");
			} else {
				System.out.println("plz..try again..~");
			}
		} catch (Exception e) {
			System.out.println("Exception " + e);

		}
	}

	public void Delete() throws ClassNotFoundException, SQLException {
		try {
			boolean l = true;
			while (l) {
				System.out.println("Enter Eid : ");
				int i = Integer.parseInt(sc.nextLine());
				Loding();

				Connection con2 = Control.connect();// step 2

				PreparedStatement ps2 = con2.prepareStatement("\nDelete from t2 where eid=" + i + "");
				int a = ps2.executeUpdate();

				if (a > 0) {
					System.out.println("\nDelete Data ~");
					l = false;
				} else {
					System.out.println("\nplz..try again..~");
				}
			}
		}

		catch (Exception e) {
			System.out.println("Exception " + e);
			System.out.println(".........................|");
		}

	}

	public void Search() throws ClassNotFoundException, SQLException {
		try {
			boolean found = false;

			System.out.print("Enter eid : ");
			int i = Integer.parseInt(sc.nextLine());
			Loding();
			Connection con4 = Control.connect();// step 2

			PreparedStatement ps4 = con4.prepareStatement("Select * from where eid=" + i + "");

			ResultSet rs = ps4.executeQuery("Select* from t2 where eid=" + i + "");
			while (rs.next()) {
				System.out.println("\nEid : " + rs.getInt(1) + " , Name : " + rs.getString(2) + "\nAddress : "
						+ rs.getString(3) + ", Salary : " + rs.getInt(4) + "");
				System.out.println("...........................|");
				found = true;
			}
			if (!found) {
				System.out.println("\nEmployee Not Found  ~ ");
				System.out.println(".........................|");

			}
		} catch (Exception e) {
			System.out.println("Exception " + e);
			System.out.println(".........................|");

		}
	}

	public void Loding() throws InterruptedException {
		System.out.print("Loding");

		for (int i = 0; i < 5; i++) {
			System.out.print(".");

			Thread.sleep(150);
		}

	}

}
