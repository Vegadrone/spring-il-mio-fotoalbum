package org.generation.italy.controller;

import java.util.List;

import org.generation.italy.pojo.Category;
import org.generation.italy.pojo.Photo;
import org.generation.italy.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService cS;
	
	@GetMapping("")
	public String index(Model model) {
		List<Category> categories = cS.findAll();
		model.addAttribute("categories", categories);
		return "category-index";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		Category cat = new Category();
		model.addAttribute("category", cat);
		return "category-create";
	}
	
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/category";
		}
		
		cS.save(category);
		return "redirect:/category";
	}
	
	@GetMapping("/edit/{id}")
	public String edit (@PathVariable("id") int id, Model model) {
		Category cat = cS.findCategoryById(id).get();
		model.addAttribute("category", cat);
		
		return "category-edit";
	}
	
	@GetMapping("/edit")
	public String update (@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {

			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/category/edit/" + category.getId();
		}
		
		cS.save(category);
		return "redirect:/category";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePhoto(@PathVariable("id") int id) {
		cS.deleteById(id);
		return "redirect:/category";
	}
}
