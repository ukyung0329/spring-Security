package bit.com.a.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bit.com.a.model.CustomUserDetails;

@Repository
public class CustomUserDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public CustomUserDetails getUserById(String username) {		
		return session.selectOne("CustUser.selectUserById", username);
	}
	
}










