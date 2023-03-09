package com.a2m.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.a2m.dto.Product;


@Controller
public class ProductController {
	List<Product> products = new ArrayList<Product>();

	@RequestMapping(value = { "/list-product" }, method = RequestMethod.GET)
	public String list(final Model model, final HttpServletRequest request, final HttpServletResponse response) {
		Product product = new Product();
		product.setProductName("sdadasd");
		product.setPrice(232);
		products.add(product);
		model.addAttribute("products", products);
		return "product/list-product";
	}

	@RequestMapping(value = { "/form-product" }, method = RequestMethod.GET)
	public String form(final Model model, final HttpServletRequest request, final HttpServletResponse response) {
		Product product = new Product();
		model.addAttribute("product", product);
//		model.addAttribute("products", products);
		return "product/form-product";
	}

	@RequestMapping(value = { "/add_product" }, method = RequestMethod.POST)
	public String add_product(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			final @ModelAttribute("product") Product product) {
		products.add(product);
		model.addAttribute("products", products);

		return "product/list-product";
	}

	@RequestMapping(value = { "/edit_product_form" }, method = RequestMethod.GET)
	public String edit_product_form(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestParam("productName") String productName) {

		for (Product pro : products) {
			if (pro.getProductName().equals(productName)) {
				model.addAttribute("product", pro);
				break;
			}
		}

		return "product/form-product";
	}
	@RequestMapping(value = { "/edit_product" }, method = RequestMethod.GET)
	public String edit_product(final Model model, final HttpServletRequest request, final HttpServletResponse response,
			final @ModelAttribute("product") Product product) {
		int idx = 0;
		for (Product pro : products) {
			if (pro.getProductName().equals(product.getProductName())) {
				idx = products.indexOf(pro);
				break;
			}
		}
		products.get(idx).setPrice(idx);
		
		return "product/form-product";
	}

	@RequestMapping(value = { "/delete_product" }, method = RequestMethod.GET)
	public String delete_product(final Model model, final HttpServletRequest request,
			final HttpServletResponse response, @RequestParam("productName") String productName) {
		int idx = 0;
		for (Product p : products) {
			if (p.getProductName().equalsIgnoreCase(productName)) {
				idx = products.indexOf(p);
				break;
			}
		}
		products.remove(idx);
		
		model.addAttribute("products", products);
		return "product/list-product";
	}

}
