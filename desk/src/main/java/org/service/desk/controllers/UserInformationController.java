package org.service.desk.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.service.desk.services.UserInformationService;


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
		private UserInformationService userInformationService;
	
	    
	    @ResponseBody
	    @RequestMapping(value = "/addUser", method= RequestMethod.POST, produces = "application/json")
	    public boolean addUserInformation(@RequestBody User userInfo) {
	    	return userInformationService.insertUserInfo(userInfo);
	    }
	    
	    @ResponseBody
	    @RequestMapping(value = "/getUser/{userName}", method= RequestMethod.GET, produces = "application/json")
	    public User getUserByFirstName(@PathVariable String userName) {
	    	return userInformationService.findUserByUserName(userName);	    	
	    }
	    
	    
	    
	    @ResponseBody
	    @RequestMapping(value = "/updateUser", method= RequestMethod.PUT, produces = "application/json")
	    public boolean updateUserById(@RequestBody User userInfo) {
	    	return userInformationService.insertUserInfo(userInfo);
	    }


}
