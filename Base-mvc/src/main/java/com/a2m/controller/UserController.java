package com.a2m.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.a2m.dao.CategoryDAO;
import com.a2m.dto.Category;

import Service.Person;

@Controller
public class UserController {

	public static ArrayList<Person> persons = new ArrayList<>();
	static {
		persons.add(new Person("A", "B"));
		persons.add(new Person("C", "D"));
	}

	@RequestMapping(value = "/UserPage", method = RequestMethod.GET)
	public ModelAndView categoryPage() {
		ModelAndView mav = new ModelAndView("User/UserPage");
		mav.addObject("persons", persons);
		return mav;
	}

	@GetMapping(value = "create")
	public String CreateUserPage() {
		return "User/CreateUser";
	}

	@PostMapping(value = "insert", params = "add")
	public String insertUser(@RequestParam("ID") String id, @RequestParam("Name") String name, Model model) {
		Person person = new Person(id, name);
		persons.add(person);
		model.addAttribute("persons", persons);
		return "User/UserPage";
	}

	@RequestMapping(value = "Edit/{ID}", method = RequestMethod.GET)
	public ModelAndView EditUser(@PathVariable("ID") String id) {
		for (Person p : persons) {
			if (p.getId().equalsIgnoreCase(id)) {
				ModelAndView mav = new ModelAndView("User/UserEdit");
				mav.addObject("ID", p.getId());
				mav.addObject("Name", p.getName());
				return mav;
			}
		}
		return null;
	}

	@PostMapping(value = "Edit", params = "update")
	public String Edit(@RequestParam("ID") String id, @RequestParam("Name") String name, Model model) {
		for (Person p : persons) {
			if (p.getId().equalsIgnoreCase(id)) {
				p.setName(name);
				break;
			}
		}
		model.addAttribute("persons", persons);
		return "redirect:/UserPage";
	}
}