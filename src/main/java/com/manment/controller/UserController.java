package com.manment.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
/*import javax.security.auth.message.callback.PrivateKeyCallback.Request;*/
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.MidiDevice.Info;
import javax.websocket.Session;

import org.apache.commons.lang.ObjectUtils.Null;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import com.manment.bean.User;
import com.manment.dao.UserDao;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping({"/index","/",""})
	public String index() throws IOException{
		return "/user/index";
	}
	
	@RequestMapping( value ={"/forget"},method= RequestMethod.POST)
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
	
	@RequestMapping( value ={"/forgetOver"},method= RequestMethod.POST)
	public String forgetOver(User u,HttpServletRequest request,Model model){
		String nPwd = null;
		try{
			System.out.println(u.getuName()+","+u.getAnswer());
			nPwd = UserDao.findByNameAndAnswer(u);
			if(nPwd != null){
				requestInfo(model, "悄悄告诉你，你的密码是："+nPwd);
			}else{
				model.addAttribute("uName", u.getuName());
				model.addAttribute("question", u.getQuestion());
				requestInfo(model, "答案不对！╮(╯▽╰)╭");
				return "/user/forgetPassword";
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "/user/index";
	}
	
	
	@RequestMapping( value ={"/register"},method= RequestMethod.POST)
	public String register(User u,HttpServletRequest request,Model model) throws Exception{
		boolean user = true;
		u.setIsFreezing(User.getUser());
		u.setuType(User.getUser());
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
		
		return user?"redirect:/admin/index":"/user/index";
	}
	
	@RequestMapping(value = "/sign",method= RequestMethod.POST)
	public String sign(User u,HttpServletRequest request,Model model,
			@CookieValue(value = "uName",required  = false)String uName,
			@CookieValue(value = "number",required  = false)Integer number
			,HttpServletResponse response) throws Exception{
		removeSession(request.getSession());
		String pageOne = "/user/index";
		User user = null;
		try{
			if(u!=null || !(u.getuName().equals(null) && u.getuPwd().equals(null))){
				user = UserDao.selectUserByLogin(u);
				if(user != null){
					if(user.getIsFreezing()!=1 && user.getIsFreezing() != null){
						if(user.getFreezingTime()!=null){
							if(!compareTime(user.getFreezingTime())){
								requestInfo(model, "你是坏人，已经被我冻结！距离你下次成功登录还有："+(60-compare(user.getFreezingTime()))+"分钟");
								return pageOne;
							}
							user.setIsFreezing(1);
							UserDao.updateByID(user);
						}
					}
					saveSession(request.getSession(), UserDao.selectUserByLogin(u));
					removeCookie(response,"uName");
					removeCookie(response, "number");
					return "redirect:/admin/index";
				}else{
							if(uName == null){
								initCookie(response,u.getuName());
							}else{
								if(number>=2){
									User toFreezing = new User();
									toFreezing.setuName(u.getuName());
									toFreezing = UserDao.findByOther(toFreezing).get(0);
									toFreezing.setFreezingTime(new Date());
									toFreezing.setIsFreezing(1);
									UserDao.updateByID(toFreezing);
									requestInfo(model, "你是坏人吧！~\\(≧▽≦)/~啦啦啦,你被我冻结了:"+(60-compare(toFreezing.getFreezingTime()))+"分钟");
									return pageOne;
								}else{
									String numberValue = String.valueOf(number+1);
									Cookie numberCookie = new Cookie("number", numberValue);
									response.addCookie(numberCookie);
								}
							}
							requestInfo(model, "帐号或密码错误！");
							return pageOne;
						}
			} else return pageOne;
		}catch (Exception e) {
			e.printStackTrace();
			requestSqlError(model);
			return pageOne;
		}
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
		model.addAttribute("request", "alert('哎呀！程序出问题了！-_-。sorry！-_-。sorry！！')");
	}
	
	private boolean compareTime(Date freezingTime) throws ParseException{
		return compare(freezingTime)>60?true:false;
	}
	
	private long compare(Date freezingTime) throws ParseException{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return (format.parse(format.format(new Date())).getTime() - format.parse(format.format(freezingTime)).getTime())/(60*1000);
	}
	
	private void removeCookie(HttpServletResponse response,String cookieName){
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	private void initCookie(HttpServletResponse response,String uName){
		Cookie nameCookie = new Cookie("uName", uName);
		nameCookie.setMaxAge(60*60);
		Cookie numberCookie = new Cookie("number", "0");
		numberCookie.setMaxAge(60*60);
		response.addCookie(numberCookie);
		response.addCookie(nameCookie);
		
	}
	
}

