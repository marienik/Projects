package offer.business.Tests;

import org.junit.Test;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.mockito.runners.*;
import offer.data.*;
import offer.data.model.*;
import offer.business.*;
import offer.contracts.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.*;
import org.testng.annotations.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultOfferServiceTest {
	
	   @InjectMocks
	    private DefaultOfferService offerService;

	   @Mock
	    private ProductRepository productRepository;
	   
	   @Mock
	    private OfferRepository offerRepository;	

	    @BeforeMethod
	    public void initMocks(){
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void offerService_returns_false_when_offer_is_null(){  	        
	        
	        boolean actual = offerService.CreateOffer(null);

	        Assert.assertEquals(false, actual);
	    }
	    
	    @Test
	    public void offerService_returns_false_when_productId_not_valid(){  	        
	        
	        boolean actual = offerService.CreateOffer(new Offer(0, "offer desc", "GB", 10.00));

	        Assert.assertEquals(false, actual);
	    }
	    
	    @Test
	    public void offerService_returns_false_when_offer_description_is_null(){  	        
	       
	        boolean actual = offerService.CreateOffer(new Offer(200, null, "GB", 10.00));

	        Assert.assertEquals(false, actual);
	    }
	    
	    @Test
	    public void offerService_returns_false_when_offer_description_is_empty(){  	        
	       
	        boolean actual = offerService.CreateOffer(new Offer(200, "", "GB", 10.00));

	        Assert.assertEquals(false, actual);
	    }
	    
	    @Test
	    public void offerService_returns_false_when_offer_price_not_valid(){  	        
	        
	        boolean actual = offerService.CreateOffer(new Offer(200, "offer desc", "GB", 0));

	        Assert.assertEquals(false, actual);
	    }
	    
	    @Test
	    public void offerService_returns_false_when_product_not_found(){
	    	
	    	int productId = 200;
	        ProductModel product = null; 
	        Mockito.when(productRepository.GetProductById(productId)).thenReturn(product);        
	        
	       
	        boolean actual = offerService.CreateOffer(new Offer(productId, "offer desc", "GB", 10.00));

	        Assert.assertEquals(false, actual);
	    }
	    
	    @Test
	    public void offerService_returns_true_when_offerRepository_returns_true(){
	    	
	    	int productId = 200;
	        ProductModel product = new ProductModel(200, "Product1", 20.00, "Product 1 desc");
	        Mockito.when(productRepository.GetProductById(productId)).thenReturn(product);
	        
	        Mockito.when(offerRepository.Create(Mockito.any(OfferModel.class))).thenReturn(true);	        
	        
	        boolean actual = offerService.CreateOffer(new Offer(productId, "offer desc", "GB", 10.00));

	        Assert.assertEquals(true, actual);
	    }
	    
	    @Test
	    public void offerService_returns_false_when_offerRepository_returns_false(){
	    	
	    	int productId = 200;
	        ProductModel product = new ProductModel(200, "Product1", 20.00, "Product 1 desc");
	        Mockito.when(productRepository.GetProductById(productId)).thenReturn(product);
	        
	        Mockito.when(offerRepository.Create(Mockito.any(OfferModel.class))).thenReturn(false);	        
	        
	        boolean actual = offerService.CreateOffer(new Offer(productId, "offer desc", "GB", 10.00));

	        Assert.assertEquals(false, actual);
	    }  

}
