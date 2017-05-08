package offer.api.Tests;

import org.junit.Test;
import org.junit.runner.*;
import org.mockito.InjectMocks;
import org.mockito.runners.*;
import offer.business.*;
import offer.api.*;
import offer.contracts.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.*;
import org.testng.annotations.*;

import javax.ws.rs.core.Response;

@RunWith(MockitoJUnitRunner.class)
public class OfferControllerTests {
	
	   @InjectMocks
	    private OfferController offerController;

	   @Mock
	    private OfferService offerService;   
	   
	    @BeforeMethod
	    public void initMocks(){
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void offerController_returns_response_with_true_when_offerService_returns_true(){  	        
	        
	    	Mockito.when(offerService.CreateOffer(Mockito.any(Offer.class))).thenReturn(true);	
	    	
	        Response actual = offerController.createOffer(new Offer(200, "offer desc", "GB", 10.00));
	        
	        Assert.assertNotNull(actual);
	        Assert.assertEquals(200, actual.getStatus());
	        
	        String result = actual.getEntity().toString();
	        Assert.assertEquals(true, result.contains("true"));
	    }
	    
	    @Test
	    public void offerController_returns_response_with_false_when_offerService_returns_false(){  	        
	        
	    	Mockito.when(offerService.CreateOffer(Mockito.any(Offer.class))).thenReturn(false);	
	    	
	        Response actual = offerController.createOffer(new Offer(200, "offer desc", "GB", 10.00));
	        
	        Assert.assertNotNull(actual);
	        Assert.assertEquals(200, actual.getStatus());
	        
	        String result = actual.getEntity().toString();
	        Assert.assertEquals(true, result.contains("false"));
	    }   
	    
}
