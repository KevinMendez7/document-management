package com.scm.dm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.dm.domain.SubCategoryIndex;
import com.scm.dm.service.SubCategoryIndexService;

@RestController
@RequestMapping("/v1")
public class SubCategoryIndexController {
	
	@Autowired
	private SubCategoryIndexService _subCategoryIndexService;
	
	@GetMapping("/index")	
	public ResponseEntity<List<SubCategoryIndex>> getAllSubCategoryIndex(){
		
		List<SubCategoryIndex> list = new ArrayList<SubCategoryIndex>();
				
		list = _subCategoryIndexService.getAllSubCategoryIndex();
		
		if(list == null || list.isEmpty()) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<SubCategoryIndex>>(list, HttpStatus.OK);
	}
	
	

}
