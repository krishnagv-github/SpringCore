package trng.samp.hibernate.pojo;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OrderID")
	private long orderId;
	@Column(name = "CustomerID")
	private long custId;
	@Column(name = "InvoiceCreationDate")
	private Date invDate;
	@Column(name = "DeliveryDueDate")
	private Date deliveryDate;
	@Column(name = "PaymentDueDate")
	private Date paymentDate;
	@Column(name = "custommessage")
	private String customMessage;

	@OneToMany
	@JoinColumn(name = "orderId")
	private List<OrderItems> orderItems;

	public Orders(long orderId, long custId, Date invDate, Date deliveryDate, Date paymentDate) {
		super();
		this.orderId = orderId;
		this.custId = custId;
		this.invDate = invDate;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
	}

	public Orders(long custId, Date invDate, Date deliveryDate, Date paymentDate) {
		super();
		this.custId = custId;
		this.invDate = invDate;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", custId=" + custId + ", invDate=" + invDate + ", deliveryDate="
				+ deliveryDate + ", paymentDate=" + paymentDate + ", customMessage=" + customMessage + "]";
	}
	
	

}
