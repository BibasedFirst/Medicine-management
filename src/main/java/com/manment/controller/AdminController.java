package com.manment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manment.bean.Drugs;
import com.manment.bean.User;
import com.manment.dao.DrugsDao;
import com.manment.dao.UserDao;
import net.sf.json.JSONArray;

/**
 * 管理员
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("admin")
public class AdminController {

	/*
	 * public static void main(String[] args) throws Exception { User u = new
	 * User(); u.setNickName("小米"); u.setuName("李小"); u.setAnswer("sa");
	 * u.setFreezingTime(new Date()); u.setQuestion("asas");
	 * u.setuPhone("313464"); u.setuPwd("123456"); u.setuType(1); for(int i = 0
	 * ; i < 100;i++){ UserDao.insertDrugs(u); }
	 * 
	 * }
	 */

	// 用户列表
	@RequestMapping("index")
	public String index(HttpServletRequest request) throws Exception {
		List<User> list = null;
		list = UserDao.selectUser();
		ObjectMapper mapper = new ObjectMapper();
		String json1 = mapper.writeValueAsString(list);
		System.out.println(json1);
		request.setAttribute("user", json1);
/*
		String json = JSONArray.fromObject(list).toString();
		
		System.out.println(list);*/
		return "admin/admin";
	}

	// 药品列表
	@RequestMapping("listdrugs")
	public String listdrugs(HttpServletRequest request) throws Exception {
		int page = Integer.parseInt(request.getParameter("page"));
		List<Drugs> list = null;
		try {
			list = DrugsDao.selectDrugsByPage(page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		request.setAttribute("list", list);
		request.setAttribute("sum", DrugsDao.selectDrug().size());
		request.setAttribute("page", page);
		return "admin/listdrugs";
	}

	// 删除药品
	@RequestMapping("deletedrugsbyid")
	public String deletedrugsbyid(HttpServletRequest request) {
		int dID = Integer.parseInt(request.getParameter("id"));
		try {
			DrugsDao.deleteDrugsById(dID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/listdrugs?page=1";
	}

	// 添加药品
	@RequestMapping("postyp")
	public String postyp(Drugs drugs) {
		System.out.println("添加药品" + drugs);
		try {
			DrugsDao.insertDrugs(drugs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/listdrugs?page=1";
	}

	// 根据id查询药品

	@RequestMapping("updatebyid")
	public String updatebyid(HttpServletRequest request) throws Exception {
		int dID = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("Drugs", DrugsDao.selectDrugsById(dID));
		return "admin/update";
	}

	// 更新药品
	@RequestMapping("udpate")
	public String udpate(Drugs drugs) {
		try {
			DrugsDao.updateDrugById(drugs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/listdrugs?page=1";
	}

	// 删除用户
	@RequestMapping("sc")
	public String sc(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			UserDao.deleteByExample(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/index";
	}

	// 冻结用户
	@RequestMapping("dj")
	public String dj(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		try {
			User u = UserDao.selectById(id);
			u.setIsFreezing(0);
			System.out.println("要更新的用户" + u);
			UserDao.updateByID(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/index";
	}

	// 解冻用户
	@RequestMapping("jd")
	public String jd(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		try {
			User u = UserDao.selectById(id);
			System.out.println("要更新的用户" + u);
			u.setIsFreezing(1);
			UserDao.updateByID(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/index";
	}

	// 饼状图
	@RequestMapping("list")
	public String list(HttpServletRequest request) {
		int sum = 0, dj = 0, fdj = 0;
		try {
			sum = UserDao.selectUser().size();
			dj = UserDao.findByIsFreezing(0).size();
			fdj = sum - dj;
			request.setAttribute("sum", sum);
			request.setAttribute("dj", dj);
			request.setAttribute("fdj", fdj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/list";
	}

	// 用户设置冻结时间
		@RequestMapping("adddj")
		public String adddj(HttpServletRequest request,Date date) throws Exception {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				User u = UserDao.selectById(id);
				u.setFreezingTime(date);
				UserDao.updateByID(u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/admin/index";
		}
	//更新个人信息
		@RequestMapping("myme")
		public String myme(HttpServletRequest request,Date date) throws Exception {
			try {
				HttpSession session = request.getSession();
				User user = (User)session.getAttribute("user");
				User u = UserDao.selectById(user.getuID());
				request.setAttribute("u", u);
			} catch (Exception e) {
				User u = UserDao.selectById(6);
				request.setAttribute("u", u);
			}
			return "admin/my";
		}
		
		// 更新个人信息
		@RequestMapping("udpatemy")
		public String udpatemy(User u) {
			System.out.println(u);
			try {
				User user = UserDao.selectById(u.getuID());
				user.setAnswer(u.getAnswer());
				user.setNickName(u.getNickName());
				user.setuPhone(u.getuPhone());
				user.setQuestion(u.getQuestion());
				UserDao.updateByID(user);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/admin/myme";
		}
		
		// 更新个人密码
				@RequestMapping("udpatemymm")
				public String udpatemymm(User u) {
					System.out.println(u);
					try {
						User user = UserDao.selectById(u.getuID());
						if(user.getuPwd().equals(u.getuPwd())){
							user.setuPwd(u.getNickName());
							UserDao.updateByID(user);
						}else{
						}
					} catch (Exception e) {
					}
					return "redirect:/admin/myme";
				}
}
