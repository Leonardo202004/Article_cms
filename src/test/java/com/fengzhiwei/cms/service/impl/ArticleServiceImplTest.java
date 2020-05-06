package com.fengzhiwei.cms.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fengzhiwei.cms.domain.Article;
import com.fengzhiwei.cms.service.ArticleService;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ArticleServiceImplTest {
	@Autowired
	private ArticleService articleService;

	@Test
	public void testList() {
		PageInfo<Article> info = articleService.list(new Article(), 1, 10);
		System.out.println(info.getList());
	}

}
