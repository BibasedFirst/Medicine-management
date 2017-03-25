package com.manment.mapper;

import java.util.List;

import com.manment.bean.User;

public interface UsersMapper {
		//添加用户
		public void insertUser(User user) throws Exception;
		
		//查询用户所有列表
		public List<User> selectUser() throws Exception;
		
		//更新用户
		public Boolean updateUserById() throws Exception;
		
		//用户登录
		public User selectUserByLogin(User user) throws Exception;
		
	    public int updateByPrimaryKey(User record);
}
