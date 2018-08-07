package trng.samp.hibernate.pojo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Order_Products")
public class OrderItems {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderID")
	private long orderId;
	@Column(name = "CustomerID")
	private long custId;
	@Column(name = "ProductID")
	private long productId;
	@Column(name = "Quantity")
	private long quantity;
	
	

	public OrderItems(long orderId, long custId, long productId, long quantity) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getOrderId() {
		return orderId;
	}

	public long getCustId() {
		return custId;
	}

	public long getProductId() {
		return productId;
	}

	public long getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "OrderItems [orderId=" + orderId + ", custId=" + custId + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}
	
	

}
