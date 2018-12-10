package testclasses;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import dataclasses.DataSets;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilityclasses.BaseClass;

public class CheckPresenceOfAnUser extends BaseClass{

	@Test(description="This test is used to check weather an user's data is present in the response")
	public void checkSpecificUser()  
	{		
		//Get Test Data
		DataSets data=new DataSets();
		data=data.getUserFName();		
		String userName=data.getUserFirstName();
		
		//Make Get Request
		Response response=apiGetCallMethod("users");
		String responseBody = response.getBody().asString();
        System.out.println("Response for Test checkSpecificUser is \n"+responseBody);
        Reporter.log("Response for Test checkSpecificUser is -> "+responseBody);
        
        //Check status code
		Assert.assertEquals(response.getStatusCode(),200);				
		
		 //Assert on Response
	    Assert.assertTrue(responseBody.contains(userName),"User "+userName+" is not present in the response");	
	    JsonPath jsonRes=new JsonPath(responseBody);
		int dataSize=jsonRes.getInt("data.size");	
		Boolean found=false;
		for(int i=0;i<dataSize;i++)
		{			
			if(jsonRes.getString("data["+i+"].first_name").equals(userName))
				{
				  found=true;
				   break;
				}			
		}
		
		 Assert.assertTrue(found,"Data for user "+userName+" is not present");
	}
}
