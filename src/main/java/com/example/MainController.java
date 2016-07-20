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
	
	// 모든 유저 리스트 반환
	@RequestMapping("/users")
	public
	@ResponseBody
	List<UserInfo> getUserList() {
		return userInfoRepository.findAll();
	}
	
	// userId로 검색해서 반환
	@RequestMapping("/users/{userId}")
	public
	@ResponseBody
	UserInfo getUser(@PathVariable String userId) {
		return userInfoRepository.findOne(userId);
	}
	
	// 새로운 유저 추가
	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    public UserInfo addUser(@RequestBody UserInfo user) {
        return userInfoRepository.save(user);
    }
}
