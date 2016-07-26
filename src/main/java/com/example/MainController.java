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
	
	@Autowired
	private PlaceInfoRepository placeInfoRepository;
	
	
	//2016.07.26 seulki
	// login_place
	@RequestMapping("/users_login/place")
	public @ResponseBody String login(@RequestBody PlaceInfo place) {
		PlaceInfo foundPlace = placeInfoRepository.findOne(place.getPlcId());

		// Doesn't exist user info (사용자 정보가 없을 경우)
		if (foundPlace == null)
			return "Doesn't exist ID!";
		else {
			// collect password (패스워드가 일치할 경우)
			if (place.getPlcPw().equals(foundPlace.getPlcPw()))
				return "Success Login!";

			// wrong password (패스워드를 틀렸을 경우)
			else
				return "Wrong Password!";

		}
	}
	
	//2016.07.25 seulki
	//login_user
	@RequestMapping("/users_login/user")
	public
	@ResponseBody
	String login(@RequestBody UserInfo user) {
		UserInfo foundUser = userInfoRepository.findOne(user.getUserId());
		
		//Doesn't exist user info (사용자 정보가 없을 경우)
		if(foundUser==null)
			return "Doesn't exist ID!";
		else
		{
			//collect password (패스워드가 일치할 경우)
			if(user.getUserPW().equals(foundUser.getUserPw()))
				return "Success Login!";
			
			//wrong password (패스워드를 틀렸을 경우)
			else
				return "Wrong Password!";
			
		}
	}
	
	//2016.07.25 seulki
	// return all user list (모든 유저 리스트 반환)
	@RequestMapping("/users")
	public
	@ResponseBody
	List<UserInfo> getUserList() {
		return userInfoRepository.findAll();
	}
	
	//2016.07.25 seulki
	// search user Id and return (userId로 검색해서 반환)
	@RequestMapping("/users/{userId}")
	public
	@ResponseBody
	UserInfo getUser(@PathVariable String userId) {
		return userInfoRepository.findOne(userId);
	}
	
	//2016.07.25 seulki
	// add new user (새로운 유저 추가)
	@RequestMapping(value = "/users/user", method = RequestMethod.POST, consumes = "application/json")
    public UserInfo addUser(@RequestBody UserInfo user) {
        return userInfoRepository.save(user);
    }
	
	//2016.07.26 seulki
	// add new place (새로운 place 추가)
	@RequestMapping(value = "/users/place", method = RequestMethod.POST, consumes = "application/json")
	public UserInfo addUser(@RequestBody PlaceInfo place) {
		return placeInfoRepository.save(place);
	}
}
