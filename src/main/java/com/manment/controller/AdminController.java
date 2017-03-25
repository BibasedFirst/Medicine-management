package com.manment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manment.bean.Drugs;
import com.manment.dao.DrugsDao;

/**
 * 管理员
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("admin")
public class AdminController {

	// 用户列表
	@RequestMapping("index")
	public String index(HttpServletRequest request) {

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
	
	//删除药品
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
	
	//添加药品 
	@RequestMapping("postyp")
	public String postyp(Drugs drugs) {
		System.out.println("添加药品"+drugs);
		try {
			DrugsDao.insertDrugs(drugs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/admin/listdrugs?page=1";
	}
}
