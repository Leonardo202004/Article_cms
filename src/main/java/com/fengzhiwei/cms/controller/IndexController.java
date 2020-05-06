package com.fengzhiwei.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fengzhiwei.cms.domain.Channel;
import com.fengzhiwei.cms.service.ChannelService;

@Controller
public class IndexController {
	@Autowired
	private ChannelService channelService;
	@RequestMapping(value = {"/","","index"})
	public String list(Model model) {
		List<Channel> channels = channelService.channels();
		model.addAttribute("channels", channels);
		return "index/index";
	}
}
