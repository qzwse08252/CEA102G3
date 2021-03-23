package com.promotion.model;

import java.util.List;


public interface PromotionDAO_interface {
	public void insert(PromotionVO promotionVO);
	public void update(PromotionVO promotionVO);
	public void delete(Integer promot_No);
	public PromotionVO findByPrimaryKey(Integer promot_No);
	public List<PromotionVO> findByPromotProductNo(Integer promot_Product_No);
	public List<PromotionVO> getAll();
}
