package trng.samp.hibernate.pojo;

import java.util.List;
import javax.persistence.*;

//@Data
@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CustomerID")
	private Long custId;
	@Column(name = "FirstName", nullable = false)
	private String firstName;
	@Column(name = "MiddleName")
	private String middleName;
	@Column(name = "LastName", nullable = false)
	private String lastName;
	@Column(name = "EmailID", nullable = false)
	private String emailId;
	@Column(name = "Company")
	private String company;
	@Column(name = "Address")
	private String address;
	@Column(name = "ZipCode")
	private int zipCode;
	@Column(name = "City")
	private String city;
	@Column(name = "State")
	private String state;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "custId")
	private List<Orders> orders;
	
	
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customers(Long custId, String firstName, String middleName, String lastName, String emailId, String company,
			String address, int zipCode, String city, String state) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.company = company;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
	}
	
	

	public Customers(String firstName, String middleName, String lastName, String emailId, String company,
			String address, int zipCode, String city, String state) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.company = company;
		this.address = address;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Customers [custId=" + custId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", emailId=" + emailId + ", company=" + company + ", address=" + address + ", zipCode="
				+ zipCode + ", city=" + city + ", state=" + state + "]";
	}

//	public List<Orders> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<Orders> orders) {
//		this.orders = orders;
//	}
	
	

}
