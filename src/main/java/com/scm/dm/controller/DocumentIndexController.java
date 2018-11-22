package com.scm.dm.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.scm.dm.domain.Document;
import com.scm.dm.domain.DocumentIndex;
import com.scm.dm.service.DocumentIndexService;

@RestController
@RequestMapping("/v1")
public class DocumentIndexController {
	
	@Autowired
	private DocumentIndexService _documentIndexService;
	
	@GetMapping("/document-index")
	public ResponseEntity<List<DocumentIndex>> getAllDocumentIndex(){
	
		List<DocumentIndex> list = new ArrayList<DocumentIndex>();
		
		list = _documentIndexService.getAllDocumentIndex();
		
		if(list == null || list.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
		return new ResponseEntity<List<DocumentIndex>>(list, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/search")
	public ResponseEntity<Set<Document>> serchByIndex(
			@RequestParam Map<String,String> map){
		
		int mapCount = map.size();
	
		List<DocumentIndex> list = new ArrayList<DocumentIndex>();
		
		Set<Document> documentList = new HashSet();
		
		list = _documentIndexService.getAllDocumentIndex();
		
		if(list == null || list.isEmpty()) {
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		
		Document doc = null;
		int validate = 0;
		
		for(DocumentIndex di : list) {				
			
			if(!di.getDocument().equals(doc)) {
				
				validate = 0;
				
			}
			
			doc = di.getDocument();
									
			for (Map.Entry<String, String> entry : map.entrySet()){				
				
				if(di.getSubCategoryIndex().getNameIndex().equals(entry.getKey())
						&&di.getValue().equals(entry.getValue())) {
					
					validate++;
					
				} 
			}	
			
			if(validate==mapCount) {
				
				documentList.add(di.getDocument());				
				
			}					
			
		}
		
		if(documentList.isEmpty() || documentList == null) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);			
			
		}
				
		return new ResponseEntity<Set<Document>>(documentList, HttpStatus.OK);
	}

}
