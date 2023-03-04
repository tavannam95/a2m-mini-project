package com.a2m.dao;

import java.util.ArrayList;
import java.util.List;

import com.a2m.dto.Category;

public class CategoryDAO {
	public static List<Category> listCate = new ArrayList<>();
	
	public Category findCategory(String categoryId) {
		for (int i = 0; i < listCate.size(); i++) {
			if (listCate.get(i).getCategoryId().equalsIgnoreCase(categoryId)) {
				return listCate.get(i);
			}
		}
		return null;
	}
	
	public int updateCategory(Category category) {
		for (int i = 0; i < listCate.size(); i++) {
			if (listCate.get(i).getCategoryId().equalsIgnoreCase(category.getCategoryId())) {
				listCate.set(i, category);
				return i;
			}
		}
		return -1;
	}
	
	public int createCategory(Category category) {
		if (findCategory(category.getCategoryId())!=null) {
			updateCategory(category);
		}else {
			listCate.add(category);
		}
		return 1;
	}
	
	public int delete(String categoryId) {
		Category category = findCategory(categoryId);
		if (category!= null) {
			listCate.remove(category);
			return 1;
		}
		return -1;
	}
	
	public List<Category> getAll() {
		return listCate;
	}
}
