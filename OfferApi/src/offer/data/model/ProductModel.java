package offer.data.model;

import java.io.Serializable;

public class ProductModel implements Serializable{

	private int id;
	private String name;
	private double price;
	private String description;
	 
	 
	public ProductModel() {}

    public ProductModel(int id, String name, double price, String description ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
