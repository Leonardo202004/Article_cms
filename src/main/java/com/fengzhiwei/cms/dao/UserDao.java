package com.fengzhiwei.cms.dao;

import java.util.List;

import com.fengzhiwei.cms.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserDao {

	List<User> list(User user);

	int update(User user);

}
