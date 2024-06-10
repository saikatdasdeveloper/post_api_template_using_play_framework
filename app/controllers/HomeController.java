package controllers;

import javax.inject.Inject;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import response.PersonDetails;


public class HomeController extends Controller {

	@Inject
	PersonDetails personDetails;
	
    public Result index() {
    	
    	personDetails.setAge(22);
    	personDetails.setName("Ram");
    	
        return ok(Json.toJson(personDetails));
    }
    
    public Result postRequest() {
    	JsonNode body = request().body().asJson();
    	PersonDetails person = Json.fromJson(body, PersonDetails.class);
    	
    	System.out.println("name "+person.getName()+" age "+person.getAge());
    	return ok(Json.toJson(person));
    }
}
