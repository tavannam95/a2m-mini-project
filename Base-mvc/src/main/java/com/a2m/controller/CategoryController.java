package com.a2m.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.a2m.dao.CategoryDAO;
import com.a2m.dto.Category;

@Controller
public class CategoryController {
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	   public ModelAndView categoryPage() {
	      ModelAndView mav = new ModelAndView("category/index");
	      return mav;
	   }
	@RequestMapping(value = "/category/create", method = RequestMethod.GET)
	   public ModelAndView createCategoryPage() {
	      ModelAndView mav = new ModelAndView("category/create");
	      return mav;
	   }
	@RequestMapping(value = "/category/create", method = RequestMethod.POST)
	   public ModelAndView createCategoryForm(@ModelAttribute Category category) {
			CategoryDAO dao = new CategoryDAO();
			dao.createCategory(category);
	      	ModelAndView mav = new ModelAndView("category/index");
	      	return mav;
	   }
	@RequestMapping(value = "/category/delete/{categoryId}", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("categoryId") String categoryId) {
		CategoryDAO dao = new CategoryDAO();
		dao.delete(categoryId);
		ModelAndView mav = new ModelAndView("category/index");
      	return mav;
	}
	@RequestMapping(value = "/category/edit/{categoryId}", method = RequestMethod.GET)
	   public ModelAndView editCategoryForm(@PathVariable("categoryId") String categoryId) {
			CategoryDAO dao = new CategoryDAO();
			Category category = dao.findCategory(categoryId);
	      	ModelAndView mav = new ModelAndView("category/edit");
	      	mav.addObject("categoryId",category.getCategoryId());
	      	mav.addObject("name",category.getName());
	      	
	      	return mav;
	   }
	
}
