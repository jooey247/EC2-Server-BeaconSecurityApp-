package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	
	//login
	@RequestMapping("/users_login")
	public
	@ResponseBody
	String login(@RequestBody UserInfo user) {
		UserInfo foundUser = userInfoRepository.findOne(user.getUserID());
		
		//Doesn't exist user info (사용자 정보가 없을 경우)
		if(foundUser==null)
			return "Doesn't exist ID!";
		else
		{
			//collect password (패스워드가 일치할 경우)
			if(user.getUserPW().equals(foundUser.getUserPW()))
				return "Success Login!";
			
			//wrong password (패스워드를 틀렸을 경우)
			else
				return "Wrong Password!";
			
		}
	}
	
	// return all user list (모든 유저 리스트 반환)
	@RequestMapping("/users")
	public
	@ResponseBody
	List<UserInfo> getUserList() {
		return userInfoRepository.findAll();
	}
	
	// search user Id and return (userId로 검색해서 반환)
	@RequestMapping("/users/{userId}")
	public
	@ResponseBody
	UserInfo getUser(@PathVariable String userId) {
		return userInfoRepository.findOne(userId);
	}
	
	// add new user (새로운 유저 추가)
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    public UserInfo addUser(@RequestBody UserInfo user) {
        return userInfoRepository.save(user);
    }
}