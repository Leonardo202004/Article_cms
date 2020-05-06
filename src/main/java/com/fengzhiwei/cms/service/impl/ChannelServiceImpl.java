package com.fengzhiwei.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengzhiwei.cms.dao.ChannelDao;
import com.fengzhiwei.cms.domain.Category;
import com.fengzhiwei.cms.domain.Channel;
import com.fengzhiwei.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelDao channelDao;
	@Override
	public List<Channel> channels() {
		// TODO Auto-generated method stub
		return channelDao.channels();
	}

	@Override
	public List<Category> getCategoryByChannelId(Integer ChannelId) {
		// TODO Auto-generated method stub
		return channelDao.getCategoryByChannelId(ChannelId);
	}

}
