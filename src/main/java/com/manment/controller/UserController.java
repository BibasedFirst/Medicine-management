package com.manment.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/*import javax.security.auth.message.callback.PrivateKeyCallback.Request;*/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiDevice.Info;
import javax.websocket.Session;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.manment.bean.User;
import com.manment.dao.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping({"/index","/",""})
	public String index() throws IOException{
		System.out.println(UserDao.findByIsFreezing(1).size());
		return "/user/index";
	}
	
	@RequestMapping({"/forget"})
	public String forget(User u,HttpServletRequest request,Model model){
		String question = null;
		try {
			question = UserDao.findByName(u.getuName());
			if(question != null){
				model.addAttribute("uName", u.getuName());
				model.addAttribute("question", question);
			}else{
				requestInfo(model,"看看你的帐号是不是正确的！");
				return "/user/index";
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/user/forgetPassword";
	}
	
	
	@RequestMapping({"/register"})
	public String register(User u,HttpServletRequest request,Model model) throws Exception{
		boolean user = true;
		try{
			if(!UserDao.insert(u)){
				requestInfo(model, "注册失败！请重新注册！");
				user = false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			requestSqlError(model);
		}
		if(user)
			saveSession(request.getSession(), UserDao.selectUserByLogin(u));
		
		return user?"index":"/user/index";
	}
	
	@RequestMapping("/sign")
	public String sign(User u,HttpServletRequest request,Model model) throws Exception{
		removeSession(request.getSession());
		User user = null;
		try{
			if(!(u.getuName().equals(null) && u.getuPwd().equals(null)))
				user = UserDao.selectUserByLogin(u);
			if(user != null)
				saveSession(request.getSession(), UserDao.selectUserByLogin(u));
			else{
				requestInfo(model, "帐号或密码错误！");
				return "/user/index";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			requestSqlError(model);
		}
		return "index";
	}
	
		
	@RequestMapping("/logout")
    public String logout(HttpServletRequest request,Model model) {
		removeSession(request.getSession());
		requestInfo(model,"注销成功！");
        return "/user/index";
    }
	
	
	private void removeSession(HttpSession session){
		session.removeAttribute("user");
		session.invalidate();
	}
	
	private void saveSession(HttpSession session,User user){
		session.setAttribute("user", user);
	}
	
	private void requestInfo(Model model,String info){
		model.addAttribute("request", "alert('"+info+"')");
	}
		
	private void requestSqlError(Model model) {
		model.addAttribute("request", "alert('哎呀！数据库出问题了！-_-。sorry！-_-。sorry！！')");
	}
}

