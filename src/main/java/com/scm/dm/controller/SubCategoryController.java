package com.scm.dm.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.scm.dm.domain.Category;
import com.scm.dm.domain.SubCategory;
import com.scm.dm.payload.AddCategoryResponse;
import com.scm.dm.payload.AddSubCategoryResponse;
import com.scm.dm.service.CategoryService;
import com.scm.dm.service.SubCategoryService;

@RestController
@RequestMapping("/v1")
public class SubCategoryController {
	
	@Autowired
	private CategoryService _categoryService;
	
	@Autowired
	private SubCategoryService _subCategoryService;	
	
	@GetMapping("/category/{name}/subcategory")
	public ResponseEntity<List<SubCategory>> getSubCategories(
			@PathVariable("name") String nameCategory, 
			@RequestParam(value = "name", required = false) String nameSubCategory ){
		
		List<SubCategory> list = new ArrayList<>();
		
		if(nameCategory == null) {
			
			return new ResponseEntity(HttpStatus.CONFLICT);						
			
		} else {
			
			Category category = _categoryService.getCategoryByName(nameCategory);
			
			if(category == null) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			if(nameSubCategory != null) {
				
				SubCategory subCategory = _subCategoryService.getSubCategoryByName(nameSubCategory);
				
				if(subCategory != null && category.getSubCategory().contains(subCategory)) {
					
					list.add(subCategory);					
					return new ResponseEntity<List<SubCategory>>(list, HttpStatus.OK);
					
				}
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				
			}
			
			list.addAll(category.getSubCategory());
			
			if(list == null || list.isEmpty()) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
												
		}
		
		return new ResponseEntity<List<SubCategory>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/category/{name}/subcategory/{nameSub}")
	public ResponseEntity<SubCategory> getSubCategoryById(
			@PathVariable("name") String nameCategory, 
			@PathVariable("nameSub") String nameSubCategory ){
		
		SubCategory subCategory;
		
		if(nameCategory == null || nameSubCategory == null) {
		
			return new ResponseEntity(HttpStatus.CONFLICT);
			
		}
			
		Category category = _categoryService.getCategoryByName(nameCategory);
			
		if(category == null) {
				
			return new ResponseEntity(HttpStatus.NO_CONTENT);
				
		}							
					
		subCategory = _subCategoryService.getSubCategoryByName(nameSubCategory);
					
		if(subCategory != null && category.getSubCategory().contains(subCategory)) {
															
			return new ResponseEntity<SubCategory>(subCategory, HttpStatus.OK);
						
		}	
					
		return new ResponseEntity(HttpStatus.NO_CONTENT);								
					 																						
	}
	
	@PostMapping("/category/{name}/subcategory")
	public ResponseEntity<AddSubCategoryResponse> addSubCategory(
			@PathVariable("name") String nameCategory,
			@RequestBody SubCategory subCategory, UriComponentsBuilder uriComponentsBuilder){				
		
		if(nameCategory == null) {
			
			return new ResponseEntity(HttpStatus.CONFLICT);
			
		}		
		
		Category category = _categoryService.getCategoryByName(nameCategory); 
		
		if(category == null) {	
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse(
							"Can't add subcategory to a non-existent category: " 
									+nameCategory.toString(), 
							subCategory.toString()), 
					HttpStatus.CONFLICT);
		
		}
		
		SubCategory _subCategory = _subCategoryService.getSubCategoryByName(subCategory.getNameSubCategory());
			
		if(category.getSubCategory().contains(_subCategory)) {
				
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("The subcategory already exist", 
							subCategory.toString()), 
					HttpStatus.CONFLICT);
				
		}			
						
		_subCategoryService.addSubCategory(subCategory);
		subCategory.setDateCreation(Calendar.getInstance().getTime());
		
		return new ResponseEntity<AddSubCategoryResponse>(
				new AddSubCategoryResponse("The subcategory has been created!", 
						subCategory.toString()), 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{name}/subcategory/{id}")
	public ResponseEntity<AddSubCategoryResponse> deleteSubCategory(
			@PathVariable("name") String nameCategory,
			@PathVariable("id") Integer idSubCategory){
	
		if(nameCategory == null) {
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("category name can't be null", 
							nameCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		Category category = _categoryService.getCategoryByName(nameCategory);
		
		if(category == null) {
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("Can't remove a subcategory "
							+ "from an non-existent category", nameCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		if(idSubCategory == null) {
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("Id can't be null", idSubCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		SubCategory subCategory = _subCategoryService.getSubCategoryById(idSubCategory);
		
		if(category.getSubCategory().contains(subCategory)) {
			
			_subCategoryService.removeSubCategoryById(idSubCategory);
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("the subcategory was removed", subCategory.toString()), 
					HttpStatus.OK);
			
		}
		
		return new ResponseEntity<AddSubCategoryResponse>(
				new AddSubCategoryResponse("Can't remove an non-existent subcategory", 
						nameCategory.toString()), 
				HttpStatus.NO_CONTENT);
				
	}
	
	@PatchMapping("/category/{name}/subcategory/{id}")
	public ResponseEntity<AddSubCategoryResponse> updateSubCategory(
			@PathVariable("name") String nameCategory,
			@PathVariable("id") Integer idSubCategory,
			@RequestBody SubCategory subCategory){
	
		if(nameCategory == null) {
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("category name can't be null", 
							nameCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		Category category = _categoryService.getCategoryByName(nameCategory);
		
		if(category == null) {
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("Can't update a subcategory "
							+ "from an non-existent category", nameCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		if(idSubCategory == null) {
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("Id can't be null", idSubCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		SubCategory _subCategory = _subCategoryService.getSubCategoryById(idSubCategory);
		
		if(category.getSubCategory().contains(_subCategory)) {
			
			_subCategoryService.updateSubCategory(subCategory);
			
			return new ResponseEntity<AddSubCategoryResponse>(
					new AddSubCategoryResponse("the subcategory was updated", subCategory.toString()), 
					HttpStatus.OK);
			
		}
		
		return new ResponseEntity<AddSubCategoryResponse>(
				new AddSubCategoryResponse("Can't update an non-existent subcategory", 
						subCategory.toString()), 
				HttpStatus.NO_CONTENT);
				
	}

}
