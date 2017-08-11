package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	private Integer id;
	private Integer product_category;
	private String name;
	private String description;
	private Double price;
	private String image;

	public Product() {
		super();
	}

	public Product(Integer id, Integer product_category, String name, String description, Double price, String image) {
		super();
		this.id = id;
		this.product_category = product_category;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProduct_category() {
		return product_category;
	}

	public void setProduct_category(Integer product_category) {
		this.product_category = product_category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
