package com.fengzhiwei.cms.service;

import com.fengzhiwei.cms.domain.Article;
import com.github.pagehelper.PageInfo;

public interface ArticleService {

	PageInfo<Article> list(Article articles, Integer pageNum, Integer pageSize);

	Article ArticleById(Integer id);

	int insert(Article article);

	int update(Article article);
}
