package offer.data;
import offer.data.model.*;

public class DefaultProductRepository implements ProductRepository {

	public ProductModel GetProductById(int productId)
	{
		//Mocking the database context to return product object		
		return new ProductModel(100, "Product1", 320.60, "Product No.1");
	}
}
