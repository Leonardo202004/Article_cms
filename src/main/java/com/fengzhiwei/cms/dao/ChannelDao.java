package com.fengzhiwei.cms.dao;

import java.util.List;

import com.fengzhiwei.cms.domain.Category;
import com.fengzhiwei.cms.domain.Channel;

public interface ChannelDao {

	List<Channel> channels();
	List<Category> getCategoryByChannelId(Integer ChannelId);
}
