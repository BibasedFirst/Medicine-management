package com.manment.controller;

import java.util.List;

/*import javax.security.auth.message.callback.PrivateKeyCallback.Request;*/
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manment.bean.User;
import com.manment.dao.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/index")
	public String index(){
		return "/user/index";
	}
	
	@RequestMapping("/sign")
	public String sign(User u) throws Exception{
		User user = null;
		try{
			if(u.getuName() != null)
				user = UserDao.selectUserByLogin(u);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
//		if(!user.getuName().equals(null))
//			System.out.println(user.getuID());
		System.out.println("------------------"+user.getuID()!=null?user.getuID():null);
		return "/user/sign";
	}
	
	@RequestMapping("/findAll")
	public String FindAll() throws Exception{
		System.out.println(UserDao.selectUser().get(0).getuID());
		return "index";
	}
}

