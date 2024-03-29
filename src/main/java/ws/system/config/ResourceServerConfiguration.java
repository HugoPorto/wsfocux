package ws.system.config;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	@Value("${authsystem.auth.accessCheckTokenUri}")
	private String accessTokenUri;
	
	@Value("${authsystem.auth.clientId}")
	private String clientId;
	
	@Value("${authsystem.auth.clientSecret}")
	private String clientSecret;

	@Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers(
                    "/wsmedical_api1/usuarios/**",
                    "/wsmedical_api1/pacientes/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login1/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login2/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('read')")
                .antMatchers(HttpMethod.GET, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.POST, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PATCH, "/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.PUT, "/rest/**").access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.DELETE, "/**").access("#oauth2.hasScope('write')");
    }
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
       resources.resourceId("todo-services").tokenServices(tokenService());
	}
	
	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
	    RemoteTokenServices tokenService = new RemoteTokenServices();
	    tokenService.setCheckTokenEndpointUrl(accessTokenUri);
	    tokenService.setClientId(clientId);
	    tokenService.setClientSecret(clientSecret);
	    tokenService.setAccessTokenConverter(getAccessTokenConverter());
	    return tokenService;
	}

	private Map<String, Object> getDetailsMap(Map<String, ?> map){
		Map<String, Object> ret = new HashMap<>();
		ret.put("tenant", map.get("tenant"));
		return ret;
	}

	private AccessTokenConverter getAccessTokenConverter() {
		return new DefaultAccessTokenConverter() {
			@Override
			public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
				OAuth2Authentication oauth = super.extractAuthentication(map);
				oauth.setDetails(getDetailsMap(map));
				return oauth;
			}
		};
	}
}
