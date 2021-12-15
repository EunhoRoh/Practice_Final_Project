package com.mycom.mapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//DAO를 사용할 class
@Service
public class UserServiceImpl {
	@Autowired
	UserDAO userDAO;
	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}
}
