package com.scm.dm.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.dm.domain.Document;
import com.scm.dm.service.DocumentService;

@RestController
@RequestMapping("/v1")
public class DocumentController {

	@Autowired
	private DocumentService _documentService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/document")
	public ResponseEntity<List<Document>> getAllDocument(){
		
		List<Document> list = new ArrayList<Document>();
		
		list = _documentService.getAllDocument();
		
		if(list == null || list.isEmpty()) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			
		}		
		
		return new ResponseEntity<List<Document>>(list, HttpStatus.OK);
		
	}	
		
	
}
