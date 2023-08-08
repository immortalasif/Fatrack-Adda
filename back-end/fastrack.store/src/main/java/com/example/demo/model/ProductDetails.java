package com.example.demo.model;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Productid;
	//@NotNull(message ="{Please enter name}")
	private String productName;
	@Column(length = 2000000000)
	//@NotNull(message ="{Please enter link}")
	private String image;
	
	private String description;
	//@NotNull(message ="{Please enter price}")
	private double price;
	
	public ProductDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getProductid() {
		return Productid;
	}

	public void setProductid(int productid) {
		Productid = productid;
	}

	public ProductDetails(int productid, String productName, String image, String description, double price) {
		super();
		Productid = productid;
		this.productName = productName;
		this.image = image;
		this.description = description;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "ProductDetails [id=" + Productid + ", productName=" + productName + ", image=" + image + ", description="
				+ description + ", price=" + price + "]";
	}
	
	
	
}
