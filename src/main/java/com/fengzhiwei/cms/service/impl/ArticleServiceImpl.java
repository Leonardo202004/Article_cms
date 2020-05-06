package com.fengzhiwei.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengzhiwei.cms.dao.ArticleDao;
import com.fengzhiwei.cms.domain.Article;
import com.fengzhiwei.cms.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao dao;

	@Override
	public PageInfo<Article> list(Article articles, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> list = dao.list(articles);
		return new PageInfo<Article>(list);
	}

	@Override
	public Article ArticleById(Integer id) {
		// TODO Auto-generated method stub
		return dao.ArticleById(id);
	}

	@Override
	public int insert(Article article) {
		// TODO Auto-generated method stub
		return dao.insert(article);
	}

	@Override
	public int update(Article article) {
		// TODO Auto-generated method stub
		return dao.update(article);
	}

}
