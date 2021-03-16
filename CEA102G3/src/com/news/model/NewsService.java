package com.news.model;

import java.sql.Date;
import java.util.List;



public class NewsService {
	private NewsDAO_interface dao;

	public NewsService() {

		dao = new NewsDAO();
	}

	public NewsVO addNews(String news_Content, Date release_Date, String news_Title, byte[] news_Pic) {
		
		NewsVO newsVO = new NewsVO();

		newsVO.setNews_Content(news_Content);
		newsVO.setRelease_Date(release_Date);
		newsVO.setNews_Title(news_Title);
		newsVO.setNews_Pic(news_Pic);

		dao.insert(newsVO);
		return newsVO;
	}
	

	public NewsVO updateNews(Integer news_No, String news_Content, Date release_Date, String news_Title, byte[] news_Pic) {
		NewsVO newsVO = new NewsVO();
		newsVO.setNews_No(news_No);
		newsVO.setNews_Content(news_Content);
		newsVO.setRelease_Date(release_Date);
		newsVO.setNews_Title(news_Title);
		newsVO.setNews_Pic(news_Pic);
		
		dao.update(newsVO);
		return newsVO;
	}
	
	public void deleteNews(Integer news_No) {
		dao.delete(news_No);
	}
	
		
		public NewsVO getOneNews(Integer news_No) {
			return dao.findByPrimaryKey(news_No);
		}

		public List<NewsVO> getAll() {
			return dao.getAll();
		}
		
	}
