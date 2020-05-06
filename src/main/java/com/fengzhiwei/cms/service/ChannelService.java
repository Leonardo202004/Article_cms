package com.fengzhiwei.cms.service;

import java.util.List;

import com.fengzhiwei.cms.domain.Category;
import com.fengzhiwei.cms.domain.Channel;

public interface ChannelService {

	List<Channel> channels();
	List<Category> getCategoryByChannelId(Integer ChannelId);
}
