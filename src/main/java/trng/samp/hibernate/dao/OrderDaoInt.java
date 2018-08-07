package trng.samp.hibernate.dao;

import trng.samp.hibernate.pojo.Orders;
import trng.samp.hibernate.pojo.Customers;
import trng.samp.hibernate.pojo.OrderItems;

public interface OrderDaoInt {
	
	public boolean createOrder(Orders order);
	public boolean updateOrder(Orders order);
	public boolean deleteOrder(Long orderID);
	public Orders getOrder(Long orderID);
	

}
