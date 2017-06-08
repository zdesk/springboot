package org.service.desk.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
@Component
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfull"),
        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
}
)
public class ServiceDesk {
	    @RequestMapping(value = "/", method= RequestMethod.GET, produces = "application/json")
	    public String list() throws JSONException {
		 	JSONObject response =  new JSONObject();
	        response.put("name", "Welcome User");
	        response.put("Swagger", "/swagger-ui.html");
	        return response.toString();
	    }
	    
	    @RequestMapping(value = "/", method= RequestMethod.POST, produces = "application/json")
	    public String list(@RequestBody JSONObject payloads) throws JSONException {
	    	
	    	if(payloads.get("name")==null){
	    		payloads.put("name", "NEW USER");
	    	}
	    	JSONObject response =  new JSONObject();
	        response.put("name", payloads.get("name"));
	        response.put("Swagger", "/swagger-ui.html");
	        return response.toString();
	    }

}
