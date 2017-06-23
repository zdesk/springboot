package org.service.desk.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oauth2AuthController {
	
	@RequestMapping(value="/usr", method = RequestMethod.GET)
    public Principal user(Principal principal) {
      return principal;
    }
    
    
    @RequestMapping(value="/oauth/handler", method=RequestMethod.GET)
    public String accessToken(@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
    	
    	String accessTokenUri= "https://graph.facebook.com/oauth/access_token?client_id=692899840881825&redirect_uri=http://localhost:8080/oauth/handler&client_secret=61ac73198af844fed4b5a19dec8bfe1e&code="+code;

    	String accessToken =  new JSONObject(this.sendGET(accessTokenUri)).getString("access_token");
    	
    	String userInfoUri = "https://graph.facebook.com/me?access_token=" + accessToken;
    	
    	return this.sendGET(userInfoUri);
    }
    
    private String sendGET(String url) throws IOException {
    	System.out.println(url);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
			return response.toString();
		} else {
			System.out.println("GET request not worked");
			return null;
		}
    }

}
