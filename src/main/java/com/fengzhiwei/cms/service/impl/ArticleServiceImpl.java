package com.fengzhiwei.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengzhiwei.cms.dao.ArticleDao;
import com.fengzhiwei.cms.domain.Article;
import com.fengzhiwei.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao dao;
	@Override
	public List<Article> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

}
