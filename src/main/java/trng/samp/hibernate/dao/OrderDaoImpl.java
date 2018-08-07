package trng.samp.hibernate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import trng.samp.hibernate.pojo.Customers;
import trng.samp.hibernate.pojo.Orders;
import trng.samp.hibernate.utils.HibernateUtils;

@Repository
public class OrderDaoImpl implements OrderDaoInt {
	
	SessionFactory sf;
	
	public OrderDaoImpl() {
		sf = HibernateUtils.getSessionFactory();
	}

	public boolean createOrder(Orders order) {
		System.out.println("Order"+ order);
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.save(order);
		session.getTransaction().commit();
		sf.openSession().close();
		return true;
	}

	public boolean updateOrder(Orders order) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		session.update(order);
		session.getTransaction().commit();
		sf.openSession().close();
		return true;
	}

	public boolean deleteOrder(Long orderID) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		try {
		Query query = session.createQuery("delete Orders where orderId =:orderID");
		query.setParameter("orderID", orderID);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Orders getOrder(Long orderID) {
		Session session = sf.openSession();
		session.getTransaction().begin();
		Orders order = (Orders) session.get(Orders.class, orderID);
		sf.openSession().close();
		return null;
	}
	
	

}
