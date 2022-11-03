package ws.system.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.franciscocalaca.http.utils.Token;
import com.franciscocalaca.http.utils.UtilHttp;

@Service
public class AuthTokenService {
	
	@Autowired
	private Environment env;

	public Token getToken(String email, String password) {
		String url = env.getProperty("authsystem.auth.url");
		String clientId = env.getProperty("authsystem.auth.clientId");
		String clientSecret = env.getProperty("authsystem.auth.clientSecret");
		
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", UtilHttp.getAuthHeaderBase64(clientId, clientSecret));
		
		Map<String, String> parameters = new HashMap<>();
		parameters.put("grant_type", "password");
		
		try {
			return new Token(url, email, password, headers, parameters);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
