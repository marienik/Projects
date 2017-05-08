package offer.business;

import offer.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import offer.data.model.*;
import offer.contracts.*;

@Component
public class DefaultOfferService implements OfferService {

	@Autowired
	OfferRepository offerRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public boolean CreateOffer(Offer offer)
	{
		try
		{
			if(offer == null || offer.ProductId <= 0 || offer.FixedPrice <=0 
					|| offer.Descrption == null || offer.Descrption.isEmpty())
				
					throw new Exception("Invalid Request to create offer.");
			
			ProductModel product = productRepository.GetProductById(offer.ProductId);
			
			if(product == null)
				throw new Exception(String.format("Could not find product with ProductId : %d", offer.ProductId));
			
			
			OfferModel offerModel = new OfferModel(offer.Descrption, offer.FixedPrice, offer.Currency, product);
			
			return offerRepository.Create(offerModel);
		}
		
		catch(Exception ex)
		{
			//TODO : Log the exception
			return false;
		}
		
	}
}
