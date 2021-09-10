package PIZZAManage.PIZZAManage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table (name="PIZZALIST")



public class PIZZA {
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Id
	@Column(name= "id")
	private String id;
	
	@Column(name= "product")

	private String product;
	
	@Column(name= "price")

	private String price;
	
	

}
