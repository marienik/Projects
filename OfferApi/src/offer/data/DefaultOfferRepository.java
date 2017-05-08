package offer.data;

import offer.data.model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class DefaultOfferRepository implements OfferRepository {
	
	
	public boolean Create(OfferModel offer)
	{
		// getting the next sequence from DB mock
		offer.setId(850);
		
		try {	
			
			ClassLoader classLoader = getClass().getClassLoader();
			File file = new File(classLoader.getResource("offer.txt").getFile());
			FileOutputStream f = new FileOutputStream(file);
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(offer);	

			o.close();
			f.close();
			
			return true;
		}
		catch(Exception ex)
		{			
			return false;
		}
	}
}
