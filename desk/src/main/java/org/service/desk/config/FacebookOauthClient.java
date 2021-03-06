package org.service.desk.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

@Configuration
@PropertySource("classpath:facebookoauth2.properties")
public class FacebookOauthClient {	
	

	
	@Bean
    @ConfigurationProperties("facebook.client")
    public AuthorizationCodeResourceDetails facebook() {	
		/*String clientId;
		String clientSecret;
		String accessTokenUri;
		String userAuthorizationUri;
		String tokenName;
		String response_type;
		String authenticationScheme;
		String clientAuthenticationScheme;		
		AuthorizationCodeResourceDetails fbAuthCodeResource = new AuthorizationCodeResourceDetails();*/
		
		return new AuthorizationCodeResourceDetails();
    }
    
    @Bean
    @ConfigurationProperties("facebook.resource")
    public ResourceServerProperties facebookResource() {
      return new ResourceServerProperties();
    }

    
    @Bean
    public FilterRegistrationBean oauth2ClientFilterRegistration(
        OAuth2ClientContextFilter filter) {
      FilterRegistrationBean registration = new FilterRegistrationBean();
      registration.setFilter(filter);
      registration.setOrder(-100);
      return registration;
    }
    
}
