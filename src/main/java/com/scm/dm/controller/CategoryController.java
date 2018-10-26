package com.scm.dm.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.scm.dm.domain.Category;
import com.scm.dm.domain.SubCategory;
import com.scm.dm.payload.AddCategoryResponse;
import com.scm.dm.service.CategoryService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class CategoryController {
	
	@Autowired
	private CategoryService _categoryService; 		

	@RequestMapping(value = "/category", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Category>> getCategories(@RequestParam(value = "name", required = false) String name){
		
		List<Category> list = new ArrayList();
		
		if(name == null) {
			
			list = _categoryService.getCategories();
			
			if(list == null || list.isEmpty()) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
			
		} else {
			
			Category category = _categoryService.getCategoryByName(name);
			
			if(category == null) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				
			}
			
			list.add(category);
		}
		
		return new ResponseEntity<List<Category>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(
			value = "/category/{name}", 
			method = RequestMethod.GET, 
			headers = "Accept=application/json")
	public ResponseEntity<Category> getCategoryByName(@PathVariable("name") String nameCategory){
		
		Category category;
					
		if(nameCategory == null) {
			
			return new ResponseEntity(HttpStatus.NO_CONTENT);									
			
		} else {
			
			category = _categoryService.getCategoryByName(nameCategory);
			
			if(category == null) {
				
				return new ResponseEntity(HttpStatus.NO_CONTENT);
				
			}
						
		}
		
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	
	@PostMapping("/category")
	public ResponseEntity<AddCategoryResponse> addCategory(
			@RequestBody Category category, UriComponentsBuilder uriComponentsBuilder){			
		
		if(category == null) {
			
			return new ResponseEntity(HttpStatus.CONFLICT);
			
		}		
		
		Category _category = _categoryService.getCategoryByName(category.getNameCategory()); 
		
		if(_category != null) {						
			
			return new ResponseEntity<AddCategoryResponse>(
					new AddCategoryResponse("The category already exist", _category.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		_categoryService.addCategory(category);
		category.setDateCreation(Calendar.getInstance().getTime());
		
		return new ResponseEntity<AddCategoryResponse>(
				new AddCategoryResponse("The category has been created!", category.toString()), 
				HttpStatus.OK);
	}
	
	@DeleteMapping("/category/{id}")
	public ResponseEntity<AddCategoryResponse> deleteCategory(@PathVariable("id") Integer idCategory){
	
		if(idCategory == null) {
			
			return new ResponseEntity<AddCategoryResponse>(
					new AddCategoryResponse("Id can't be null", idCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		_categoryService.removeCategoryById(idCategory);
		
		return new ResponseEntity<AddCategoryResponse>(
				new AddCategoryResponse("the category was removed", idCategory.toString()), 
				HttpStatus.OK);
	}
	
	@PatchMapping("/category/{id}")
	public ResponseEntity<AddCategoryResponse> updateCategory(
			@PathVariable("id") Integer idCategory,
			@RequestBody Category category){
		
		if(idCategory == null) {
			
			return new ResponseEntity<AddCategoryResponse>(
					new AddCategoryResponse("Id can't be null", idCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		Category _category = _categoryService.getCategoryById(idCategory);
		
		if(category == null) {
			
			return new ResponseEntity<AddCategoryResponse>(
					new AddCategoryResponse("Can't update a non-existent category", idCategory.toString()), 
					HttpStatus.CONFLICT);
			
		}
		
		_categoryService.updateCategory(category);
		
		return new ResponseEntity<AddCategoryResponse>(
				new AddCategoryResponse("the category was updated", category.toString()), 
				HttpStatus.OK);
	}
	
}
