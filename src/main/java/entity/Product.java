package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank
	@Size(min=5, max=25)
	private String name;
	private Integer product_category;
	@NotBlank
	private String image;	
	@NotBlank
	@Size(min=10)
	private String description;
	@NotBlank
	private Double price;
	

	public Product() {
		super();
	}

	

	public Product(String name, Integer product_category, String image, String description, Double price) {
		super();
		this.name = name;
		this.product_category = product_category;
		this.image = image;
		this.description = description;
		this.price = price;
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
