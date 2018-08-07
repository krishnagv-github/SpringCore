package trng.samp.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import trng.samp.hibernate.dao.*;
import trng.samp.hibernate.pojo.*;

@Configuration
@Component
@ComponentScan({"trng.samp.hibernate","trng.samp.hibernate.dao"})
public class CustomerApp {
	@Autowired
	CustDaoInt cdin;
	static Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public void addCustomer() throws IOException {
		System.out.println("Please enter the details");
		System.out.println("Please enter the first name");
		String fName = br.readLine();
		System.out.println("Please enter the middle name");
		String mName = br.readLine();
		System.out.println("Please enter the last name");
		String lName = br.readLine();
		System.out.println("Please enter the email");
		String email = br.readLine();
		System.out.println("Please enter the company");
		String company = br.readLine();
		System.out.println("Please enter the address");
		String address = br.readLine();
		System.out.println("Please enter the zip code");
		int zipCode = sc.nextInt();
		System.out.println("Please enter the city");
		String city = br.readLine();
		System.out.println("Please enter the state");
		String state = br.readLine();

		Customers cust = new Customers(fName, mName, lName, email, company, address, zipCode, city, state);
		cdin.addCustomer(cust);
	}

	public void deleteCustomer() {

		System.out.println("Please enter the id of the Customer you wish to delete.");
		Long custId = sc.nextLong();
		cdin.deleteCustomerByHql(custId);
	}

	public void loadCustomer() {
		System.out.println("Please enter the id of the Customer you wish to view.");
		Long custId = sc.nextLong();
		cdin.loadCustomer(custId);
	}

	public void updateCustomer() throws IOException {
		System.out.println("Please enter the id of the customer you wish to update.");
		Long custID = sc.nextLong();
		System.out.println("Please enter the details");
		System.out.println("Please enter the first name");
		String fName = br.readLine();
		System.out.println("Please enter the middle name");
		String mName = br.readLine();
		System.out.println("Please enter the last name");
		String lName = br.readLine();
		System.out.println("Please enter the email");
		String email = br.readLine();
		System.out.println("Please enter the company");
		String company = br.readLine();
		System.out.println("Please enter the address");
		String address = br.readLine();
		System.out.println("Please enter the zip code");
		int zipCode = sc.nextInt();
		System.out.println("Please enter the city");
		String city = br.readLine();
		System.out.println("Please enter the state");
		String state = br.readLine();

		Customers cust = new Customers(custID, fName, mName, lName, email, company, address, zipCode, city, state);

		cdin.updateCustomer(cust);
	}

	public void getList() {
		System.out.println("Please enter the Zip Code by which you wish to display the customers.");
		int zipCode = sc.nextInt();
		List<Customers> cList = new ArrayList<Customers>();
		cList = cdin.getZipCustomers(zipCode);
		System.out.println(cList);
	}

	public static int displayOptions() {
		System.out.println("Please enter the option you wish to select");
		System.out.println("1) for adding a Customer");
		System.out.println("2) for viewing a Customer by their ID");
		System.out.println("3) for updating a Customer details");
		System.out.println("4) for deleting a Customer by ID");
		System.out.println("5) for displaying the list of customers by zip code");
		int temp = sc.nextInt();
		return temp;
	}

	public static void main(String[] args) throws IOException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomerApp.class);

		CustomerApp cApp = context.getBean(CustomerApp.class);
		while (true) {
			switch (displayOptions()) {
			case 1:
				cApp.addCustomer();
				break;
			case 2:
				cApp.loadCustomer();
				break;
			case 3:
				cApp.updateCustomer();
				break;
			case 4:
				cApp.deleteCustomer();
				break;
			case 5:
				cApp.getList();
				break;
			}

		}

	}

}
