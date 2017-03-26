package com.manment.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manment.bean.Drugs;
import com.manment.bean.User;
import com.manment.dao.DrugsDao;
import com.manment.dao.UserDao;

@Controller
@RequestMapping("jhy")
public class JhyController {

	
	// 药品列表
		@RequestMapping("index")
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
			return "jhy/jhy";
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
			return "redirect:/jhy/index?page=1";
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
			return "redirect:/jhy/index?page=1";
		}

		// 根据id查询药品

		@RequestMapping("updatebyid")
		public String updatebyid(HttpServletRequest request) throws Exception {
			int dID = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("Drugs", DrugsDao.selectDrugsById(dID));
			return "jhy/update";
		}

		// 更新药品
		@RequestMapping("udpate")
		public String udpate(Drugs drugs) {
			try {
				DrugsDao.updateDrugById(drugs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/jhy/index?page=1";
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
					return "jhy/my";
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
					return "redirect:/jhy/myme";
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
							return "redirect:/jhy/myme";
						}
}

