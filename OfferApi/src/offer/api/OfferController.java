package offer.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import offer.business.OfferService;
import offer.contracts.*;



@Component
@Path("/offerservice")
public class OfferController {
	
	@Autowired
	OfferService offerService;
	
	
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response createOffer(Offer offer) {		
		
		JSONObject jsonObject = new JSONObject();	
		boolean result = offerService.CreateOffer(offer);
		jsonObject.put("Success", result); 		
		return Response.status(200).entity(jsonObject.toString()).build();
	}

}
