package trng.samp.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import trng.samp.hibernate.dao.*;
import trng.samp.hibernate.pojo.*;
import trng.samp.hibernate.utils.*;

public class OrderApp {
	
	static Scanner sc = new Scanner(System.in);
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException, ParseException {

		OrderApp oApp = new OrderApp();
		while (true) {
			switch (displayOptions()) {
			case 1:
				oApp.addOrder();
				break;
			case 2:
				oApp.loadOrder();
				break;
			case 3:
				oApp.updateOrder();
				break;
			case 4:
				oApp.deleteOrder();
				break;
			}

		}

	}
	
	public static int displayOptions() {
		System.out.println("Please enter the option you wish to select");
		System.out.println("1) for adding an Order");
		System.out.println("2) for viewing an Order by their ID");
		System.out.println("3) for updating an Order details");
		System.out.println("4) for deleting an Order by ID");
		int temp = sc.nextInt();
		return temp;
	}
	
	public void addOrder() throws IOException, ParseException {
		System.out.println("Please enter the details");
		System.out.println("Please enter the Customer ID");
		Long custID = sc.nextLong();
		
		System.out.println("Please enter the Invoice Creation Date");
		String date1 = br.readLine();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date invDate = sdf.parse(date1);
		
		System.out.println("Please enter the delivery date");
		String date2 = br.readLine();
		Date deliveryDate = sdf.parse(date2);
		
		System.out.println("Please enter the payment date");
		String date3 = br.readLine();
		Date paymentDate = sdf.parse(date3);
		
		Orders order = new Orders(custID, invDate, deliveryDate, paymentDate);

		OrderDaoImpl odi = new OrderDaoImpl();
		odi.createOrder(order);
	}
	
	public void loadOrder() {
		System.out.println("Please enter the id of the order you wish to view.");
		Long orderId = sc.nextLong();
		OrderDaoImpl odi = new OrderDaoImpl();
		odi.getOrder(orderId);
	}
	
	public void deleteOrder() {

		System.out.println("Please enter the id of the order you wish to delete.");
		Long orderId = sc.nextLong();
		OrderDaoImpl odi = new OrderDaoImpl();
		odi.deleteOrder(orderId);
	}
	
	public void updateOrder() throws IOException, ParseException {
		System.out.println("Please enter the id of the order you wish to update.");
		Long orderID = sc.nextLong();
		System.out.println("Please enter the details");
		System.out.println("Please enter the Customer ID");
		Long custID = sc.nextLong();
		
		System.out.println("Please enter the Invoice Creation Date");
		String date1 = br.readLine();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date invDate = sdf.parse(date1);
		
		System.out.println("Please enter the delivery date");
		String date2 = br.readLine();
		Date deliveryDate = sdf.parse(date2);
		
		System.out.println("Please enter the payment date");
		String date3 = br.readLine();
		Date paymentDate = sdf.parse(date3);
		
		Orders order = new Orders(orderID, custID, invDate, deliveryDate, paymentDate);
		
		OrderDaoImpl odi = new OrderDaoImpl();
		odi.updateOrder(order);
	}
	
	
}
