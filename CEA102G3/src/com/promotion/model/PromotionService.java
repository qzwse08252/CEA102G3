package com.promotion.model;

import java.sql.Date;
import java.util.List;



public class PromotionService {
	private PromotionDAO_interface dao;

	public PromotionService() {
//		dao = new PromotionJDBCDAO();
		dao = new PromotionDAO();
	}

	public PromotionVO addPromotion(String promot_Content, Date promot_Start, Date promot_End, Date release_Date, Integer promot_Product_No, Integer promot_Product_Price,
			String promot_Product_Title, byte[] promot_Product_Pic) {
		
		PromotionVO promotionVO = new PromotionVO();

		promotionVO.setPromot_Content(promot_Content);
		promotionVO.setPromot_Start(promot_Start);
		promotionVO.setPromot_End(promot_End);
		promotionVO.setRelease_Date(release_Date);
		promotionVO.setPromot_Product_No(promot_Product_No);
		promotionVO.setPromot_Product_Price(promot_Product_Price);
		promotionVO.setPromot_Product_Title(promot_Product_Title);
		promotionVO.setPromot_Product_Pic(promot_Product_Pic);

		dao.insert(promotionVO);
		return promotionVO;
	}
	

	public PromotionVO updatePromotion(Integer promot_No, String promot_Content, Date promot_Start, Date promot_End, Date release_Date, Integer promot_Product_No, Integer promot_Product_Price, String promot_Product_Title, byte[] promot_Product_Pic) {
		
		PromotionVO promotionVO = new PromotionVO();
		promotionVO.setPromot_No(promot_No);
		promotionVO.setPromot_Content(promot_Content);
		promotionVO.setPromot_Start(promot_Start);
		promotionVO.setPromot_End(promot_End);
		promotionVO.setRelease_Date(release_Date);
		promotionVO.setPromot_Product_No(promot_Product_No);
		promotionVO.setPromot_Product_Price(promot_Product_Price);
		promotionVO.setPromot_Product_Title(promot_Product_Title);
		promotionVO.setPromot_Product_Pic(promot_Product_Pic);

	
		dao.update(promotionVO);
		return promotionVO;
	}
	
	public void deletePromotion(Integer promot_No) {
		dao.delete(promot_No);
	}

	public PromotionVO getOnePromotion(Integer promot_No) {
		return dao.findByPrimaryKey(promot_No);
	}
	
	public List<PromotionVO> findByPromotProductNo(Integer promot_Product_No) {
		return dao.findByPromotProductNo(promot_Product_No);
	}

	public List<PromotionVO> getAll() {
		return dao.getAll();
	}
}
