package com.fengzhiwei.cms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengzhiwei.cms.domain.Article;
import com.fengzhiwei.cms.domain.User;
import com.fengzhiwei.cms.service.ArticleService;
import com.fengzhiwei.cms.service.UserService;
import com.github.pagehelper.PageInfo;

@RequestMapping("admin")
@Controller
public class AdminController {
	@Resource
	private ArticleService articleService;
	@Resource
	private UserService userService;

	@RequestMapping(value = { "", "/", "index" })
	public String index() {
		return "admin/index";
	}

	@RequestMapping("list")
	public String list(Model model, Article articles, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "8") Integer pageSize) {
		PageInfo<Article> info = articleService.list(articles, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("articles", articles);
		return "admin/articles";
	}
	@RequestMapping("users")
	public String users(Model model, User user, @RequestParam(defaultValue = "1") Integer pageNum,
			@RequestParam(defaultValue = "8") Integer pageSize) {
		PageInfo<User> info = userService.list(user, pageNum, pageSize);
		model.addAttribute("info", info);
		model.addAttribute("user", user);
		return "admin/users";
	}
	@RequestMapping("updateArticle")
	@ResponseBody
	public int update(Article article) {
		return articleService.update(article);
	}
	@RequestMapping("updateUser")
	@ResponseBody
	public int update(User user) {
		return userService.update(user);
	}
	@RequestMapping("article")
	@ResponseBody
	public Article article(Integer id) {
		return articleService.ArticleById(id);
	}
}
