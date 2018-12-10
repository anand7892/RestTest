package testclasses;


import org.testng.Assert;
import org.testng.annotations.Test;
import dataclasses.DataSets;
import io.restassured.response.Response;
import utilityclasses.BaseClass;

public class DeleteAnUser extends BaseClass{

	@Test(description="This test is used to delete an user")
	public void deleteAnUser()  
	{
		
		//Get Test Data
        DataSets data=new DataSets();
		data=data.deleteUserData();		
        String userId=data.getUserId();
       
        //Make Delete Request
        Response response=apiDeleteCallMethod("/users"+userId);
        
        //Check status code
        int statusCode = response.getStatusCode();        
        Assert.assertEquals(statusCode, 204,"Incorrect status code "+statusCode+" found");              
	}
	
}
