package com.faq.model;

import java.util.List;



public interface FaqDAO_interface {
    public void insert(FaqVO faqVO);
    public void update(FaqVO faqVO);
    public void delete(Integer questionNo);
    public FaqVO findByPrimaryKey(Integer questionNo);
//    public FaqVO findByQuestion(String question);
    public List<FaqVO> getAll();

}
