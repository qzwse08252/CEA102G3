package com.functions.model;

import java.util.*;

public interface FunctionsDAO_interface {
	public void insert(FunctionsVO functionsVO);
	public void update(FunctionsVO functionsVO);
	public void delete(Integer funct_No);
	public FunctionsVO findByPrimaryKey(Integer funct_No);
	public List<FunctionsVO> getAll();
}
