package utilityclasses;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	public static String  baseURL="https://reqres.in/api/";
	RequestSpecification httpRequest;
	Response response ;
	
	
	public Response apiCall(String path, Method verb,JSONObject requestParams)
	{
		RestAssured.baseURI =baseURL;
		httpRequest = RestAssured.given();
		httpRequest.header("Content-Type", "application/json");
		if(requestParams!=null)
		 httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(verb, path);
		return response;
		
	}
	
	public Response apiGetCallMethod(String path)
	{		
		return 	apiCall(path,Method.GET, null);
	}
	
		
	public Response apiPostCallMethod(String path,JSONObject requestParams)
	{		
		return 	apiCall(path,Method.POST,requestParams);
	}
		
	public Response apiPutCallMethod(String path,JSONObject requestParams)
	{		
		return 	apiCall(path,Method.PUT,requestParams);		
	}
	
	public Response apiDeleteCallMethod(String path)
	{		
		return 	apiCall(path,Method.DELETE,null);
	}

	
	
}
