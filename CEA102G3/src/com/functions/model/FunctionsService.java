package com.functions.model;

import java.util.List;


public class FunctionsService {
	private FunctionsDAO_interface dao;

	public FunctionsService() {
		dao = new FunctionsDAO();

	}

	public FunctionsVO addFunctions(String funct_Name) {
		
		FunctionsVO functionsVO = new FunctionsVO();
		
		functionsVO.setFunct_Name(funct_Name);
	
		dao.insert(functionsVO);
		return functionsVO;
	}
	
	public FunctionsVO updateFunctions(Integer funct_No, String funct_Name) {
		FunctionsVO functionsVO = new FunctionsVO();
		
		functionsVO.setFunct_No(funct_No);
		functionsVO.setFunct_Name(funct_Name);
		
		dao.update(functionsVO);
		return functionsVO;
	}
	
	public void deleteFunctions(Integer funct_No) {
		dao.delete(funct_No);
	}

	public FunctionsVO getOneFunctions(Integer funct_No) {
		return dao.findByPrimaryKey(funct_No);
	}
	

	public List<FunctionsVO> getAll() {
		return dao.getAll();
	}
}