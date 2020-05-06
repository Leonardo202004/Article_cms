package com.fengzhiwei.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fengzhiwei.cms.domain.Article;
import com.fengzhiwei.cms.domain.Category;
import com.fengzhiwei.cms.domain.Channel;
import com.fengzhiwei.cms.service.ArticleService;
import com.fengzhiwei.cms.service.ChannelService;
import com.github.pagehelper.PageInfo;
@RequestMapping("my")
@Controller
public class MyController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChannelService channelService;
	/**
	 * 
	 * @Title: index 
	 * @Description: 进入个人页面
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = {"","/","index"})
	public String index() {
		return "my/index";
	}
	/**
	 * 
	 * @Title: list 
	 * @Description: 列表
	 * @param model
	 * @param articles
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: String
	 */
	@RequestMapping("list")
	public String list(Model model,Article articles, @RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "8")Integer pageSize) {
		PageInfo<Article> info = articleService.list(articles, pageNum, pageSize);
		model.addAttribute("info", info);
		return "my/articles";
	}
	/**
	 * 
	 * @Title: ArticleById 
	 * @Description:文章详情
	 * @param id
	 * @return
	 * @return: Article
	 */
	@RequestMapping("article")
	@ResponseBody
	public Article ArticleById(Integer id) {
		return articleService.ArticleById(id);
	}
	/**
	 * 
	 * @Title: publish 
	 * @Description: 进入发布文章
	 * @return
	 * @return: String
	 */
	@RequestMapping("publish")
	public String publish() {
		return "my/publish";
	}
	/**
	 * 
	 * @Title: channels 
	 * @Description: 查询栏目
	 * @return
	 * @return: List<Channel>
	 */
	@ResponseBody
	@RequestMapping("channels")
	public List<Channel> channels(){
		return channelService.channels();
	}
	/**
	 * 
	 * @Title: getCategoryByChannelId 
	 * @Description: 根据栏目查分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	@ResponseBody
	@RequestMapping("getCategoryByChannelId")
	public List<Category> getCategoryByChannelId(Integer channelId){
		return channelService.getCategoryByChannelId(channelId);
	}
	@ResponseBody
	@RequestMapping("insert")
	public int insert(MultipartFile file,Article article) {
		if (file != null && !file.isEmpty()) {
			String path="D:\\img";
			String filename = file.getOriginalFilename();
			String newFileName = UUID.randomUUID()+filename.substring(filename.lastIndexOf("."));
			try {
				file.transferTo(new File(path,newFileName));
				article.setPicture(newFileName);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		article.setUserId(5);
		article.setStatus(0);//0:待审核
		article.setCreated(new Date());//发布时间
		article.setUpdated(new Date());//修改时间
		article.setDeleted(0);//正常
		article.setHot(0);//0：非热门 1：热门
		article.setContentType("0");//0:html 1:json
		return articleService.insert(article);
	}
}
