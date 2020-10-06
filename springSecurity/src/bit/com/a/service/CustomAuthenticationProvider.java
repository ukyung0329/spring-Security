package bit.com.a.service;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import bit.com.a.HelloController;
import bit.com.a.model.CustomUserDetails;
				// Authentication:확증 	Provider:제공
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private static Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	private UserDetailsService userDeSer;
	
	public boolean matchPassword(String loginPwd, String password) {
		logger.info("matchPassword check!");
		return loginPwd.equals(password);
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	// 인증 함수
		
		// 입력된 정보
		String username = (String)authentication.getPrincipal();	// id
		String password = (String)authentication.getCredentials();	// password
		
		logger.info("CustomAuthenticationProvider authenticate");
		logger.info("username:" + username);
		logger.info("password:" + password);
		
		// DB로부터
		CustomUserDetails user = (CustomUserDetails)userDeSer.loadUserByUsername(username); 
		Collection<GrantedAuthority> authotities = (Collection<GrantedAuthority>)user.getAuthorities();
		
		if(!matchPassword(password, user.getPassword())) { // 패스워드가 다른 경우
			throw new BadCredentialsException(username);
		}
		
		if(!user.isEnabled()) {
			throw new BadCredentialsException(username);
		}
				
		return new UsernamePasswordAuthenticationToken(username, password, authotities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}






