package offer.data.model;

import java.io.Serializable;

public class OfferModel implements Serializable {

	private int id;
	private String currency;
	private double price;
	private String description;
	private int productId;
	private ProductModel product;
	 
	public void setId(int id)
	{
		this.id = id;
	}
	 
	public OfferModel() {}

    public OfferModel(String description, double price, String currency, int productId) {
        
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.productId = productId;
    }
    
    public OfferModel(String description, double price, String currency, ProductModel product) {
        
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.product = product;
    }
    
    
  }
