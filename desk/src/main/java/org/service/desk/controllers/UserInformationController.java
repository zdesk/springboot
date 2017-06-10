package org.service.desk.controllers;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.service.desk.entities.models.*;
import org.service.desk.services.UserInfoService;

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
public class UserInformationController {
	
		@Autowired
		private UserInfoService userInfoService;
	
	    @RequestMapping(value = "/", method= RequestMethod.GET, produces = "application/json")
	    public String list() {
	    	return "<h2>"
	    			+"<h2> Welcome to REST API Gateway of SERVICE AT YOUR DESK</h2>"
	    			+"<a href='/swagger-ui.html'> please navigate to swagger</a>"
	    			+ "</h2>";
	    }
	    
	    @ResponseBody
	    @RequestMapping(value = "/addUser", method= RequestMethod.PUT, produces = "application/json")
	    public boolean addUserInformation(@RequestBody UserInformation userInfo) throws JSONException {
	    	return userInfoService.insertUserInfo(userInfo);
	    }
	    
	    @ResponseBody
	    @RequestMapping(value = "/getUserByFirstName/{firstName}", method= RequestMethod.GET, produces = "application/json")
	    public List<UserInformation> getUserByFirstName(@RequestParam String firstName) {
	    	return userInfoService.findUserByFirstName(firstName);	    	
	    }
	    
	    @ResponseBody
	    @RequestMapping(value = "/getUserByUserIdentity/{userIdentity}", method= RequestMethod.GET, produces = "application/json")
	    public List<UserInformation> getUserByUserIdentiy(@RequestParam String userIdentity) {
	    	return userInfoService.findUserByUserIdentity(userIdentity);	    	
	    }
	    
	    @ResponseBody
	    @RequestMapping(value = "/getUserByLastName/{lastName}", method= RequestMethod.GET, produces = "application/json")
	    public List<UserInformation> getUserByLastName(@RequestParam(value="lastName", required=false) String lastName) {
	    	return userInfoService.findUserByLastName(lastName);	    	
	    }
	    
	    @ResponseBody
	    @RequestMapping(value = "/updateUser", method= RequestMethod.PUT, produces = "application/json")
	    public boolean updateUserById(@RequestBody UserInformation userInfo) {
	    	return userInfoService.insertUserInfo(userInfo);
	    }


}
