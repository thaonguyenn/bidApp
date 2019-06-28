package org.webproject.model;





import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Category")
public class Category {
	@Id
	private String idCategory;
	private String nameCategory;
	public String getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	

}
