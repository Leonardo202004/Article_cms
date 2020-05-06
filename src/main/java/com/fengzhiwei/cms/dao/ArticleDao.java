package com.fengzhiwei.cms.dao;

import java.util.List;

import com.fengzhiwei.cms.domain.Article;

public interface ArticleDao {

	List<Article> list(Article articles);

	Article ArticleById(Integer id);
	
	int insert(Article article);

	int update(Article article);
}
