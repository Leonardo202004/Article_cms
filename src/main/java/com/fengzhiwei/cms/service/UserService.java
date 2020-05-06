package com.fengzhiwei.cms.service;

import java.util.List;

import com.fengzhiwei.cms.domain.User;
import com.github.pagehelper.PageInfo;

public interface UserService {
	PageInfo<User> list(User user,Integer pageNum,Integer pageSize);

	int update(User user);
}
