package com.faq.model;

import java.sql.Date;
import java.util.List;





public class FaqService {
	private FaqDAO_interface dao;

	public FaqService() {
		dao = new FaqDAO();
	}

	public FaqVO addFaq(String question, String answer, Date update_Time) {

		FaqVO faqVO = new FaqVO();

		faqVO.setQuestion(question);
		faqVO.setAnswer(answer);
		faqVO.setUpdate_Time(update_Time);

		dao.insert(faqVO);
		return faqVO;
	}

	public FaqVO updateFaq(Integer question_No,String question, String answer,Date update_Time) {

		FaqVO faqVO = new FaqVO();
		
		faqVO.setQuestion_No(question_No);
		faqVO.setQuestion(question);
		faqVO.setAnswer(answer);
		faqVO.setUpdate_Time(update_Time);
		dao.update(faqVO);

		return faqVO;
	}
	
		public void deleteQuestion(Integer question_No) {
		dao.delete(question_No);
	}
	
		
		public FaqVO getOneQuestion(Integer question_No) {
			return dao.findByPrimaryKey(question_No);
		}

		public List<FaqVO> getAll() {
			return dao.getAll();
		}
		
	}

