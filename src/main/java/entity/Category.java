package entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@javax.persistence.Entity
@javax.persistence.Table(name="product_category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotBlank
	@Size(min=4, max=25)
	private String name;	
	
	
	public Category() {
		super();
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
