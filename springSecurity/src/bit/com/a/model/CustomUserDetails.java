package bit.com.a.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/*
DROP TABLE USERTABLE
CASCADE CONSTRAINTS;

CREATE TABLE USERTABLE(
	ID VARCHAR2(100) PRIMARY KEY,
	PASSWORD VARCHAR2(300) NOT NULL,
	NAME VARCHAR2(45) NOT NULL,
	AUTHORITY VARCHAR2(50) NOT NULL,
	ENABLED NUMBER(1)
);

INSERT INTO USERTABLE(ID, PASSWORD, NAME, AUTHORITY, ENABLED)
VALUES('aaa', '111', 'hgd', 'ROLE_USER', 1);

INSERT INTO USERTABLE(ID, PASSWORD, NAME, AUTHORITY, ENABLED)
VALUES('bbb', '222', 'ijm', 'ROLE_MEMBER', 1);

INSERT INTO USERTABLE(ID, PASSWORD, NAME, AUTHORITY, ENABLED)
VALUES('ccc', '333', 'jsd', 'ROLE_ADMIN', 1);

*/
public class CustomUserDetails implements UserDetails, Serializable {

	private String ID;
	private String PASSWORD;
	private String NAME;
	// column 추가 	
	private String AUTHORITY;	// 권한	
	private boolean ENABLED;	// 접근 가능 여부
	
	public CustomUserDetails() {
	}

	@Override	// GrantedAuthority : 허가, 권리
	public Collection<? extends GrantedAuthority> getAuthorities() { // 권한들을 리턴			
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(AUTHORITY));		
		return auth;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return PASSWORD;
	}

	@Override
	public String getUsername() {	// id == name
		// TODO Auto-generated method stub
		return ID;
	}

	@Override
	public boolean isAccountNonExpired() {	// 계정이 만료된 계정인지
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	// 계정이 잠겨 있는지
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 계정의 패스워드가 만료되지 않았는지
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {	// 사용가능 여부
		// TODO Auto-generated method stub
		return true;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}
		
		
}









