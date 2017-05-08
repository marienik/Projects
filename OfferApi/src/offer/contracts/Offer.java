package offer.contracts;

public class Offer {

	public int ProductId;	
	public String Descrption;
	public String Currency;
	public double FixedPrice;
	
	 public Offer() {
	    }
	 
	 public Offer(int productId, String desc, String currency, double fixedPrice) {
		 
		 this.ProductId = productId;
		 this.Descrption = desc;
		 this.Currency = currency;
		 this.FixedPrice = fixedPrice;
		 
	    }
}
