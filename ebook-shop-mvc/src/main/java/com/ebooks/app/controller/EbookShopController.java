package com.ebooks.app.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ebooks.app.model.EbookShop;
import com.ebooks.app.service.EbookService;

@Controller
public class EbookShopController {
	@Autowired
	private EbookService ebookService;
	
	@GetMapping(value = {"/ebooks" })
	public String ebooks(Model model) throws Exception {
		List<EbookShop> findAllEbooks = ebookService.findAllEbooks();
		model.addAttribute("ebookList", findAllEbooks);
		return "ebooks_list";
	}
	
	@GetMapping(value = { "/","/register" })
	public String registrationPage(@ModelAttribute("ebookCmd") EbookShop ebookShop, Model model) throws Exception {
		model.addAttribute("idKey", 0);
		
		return "ebookRegistration";
	}
	
	
	@PostMapping(value = {"/register"})
	public String saveUpdateEbook(Model model, @ModelAttribute("ebookCmd") EbookShop ebookShop, BindingResult bindingResult) throws Exception {
		ebookShop = ebookService.saveEbookshop(ebookShop);
		return "redirect:/ebooks";
	}
	
	@GetMapping(value = { "/ebooks/delete/{id}" })
	public String deleteEbook(@PathVariable("id") Integer id) throws Exception {
		ebookService.deleteEbook(id);
		return "redirect:/ebooks";

	}
	
	@GetMapping(value = { "/ebooks/edit/{id}"})
	public String editEbookPage(Model model, @PathVariable("id") Integer id, @ModelAttribute("ebookCmd") EbookShop ebookShop,BindingResult bindingResult) throws Exception {
		
		
		if(bindingResult.hasErrors()) {
			System.out.println("stop here");
		}
		EbookShop findEbookById = ebookService.findEbookById(id);
		
		if(StringUtils.isEmpty(findEbookById.getBookId())) {
			return "redirect:/register";
		}
		BeanUtils.copyProperties(findEbookById, ebookShop);
		model.addAttribute("idKey", ebookShop.getBookId());
		return "ebookRegistration";
	}
	@PostMapping(value = { "/ebooks/edit/{id}" })
	public String updateEbook(Model model,  @ModelAttribute("ebookCmd") EbookShop ebookShop,BindingResult bindingResult) throws Exception {
		
		
		if(bindingResult.hasErrors()) {
			System.out.println("stop here");
		}
		ebookShop = ebookService.saveEbookshop(ebookShop);
		return "redirect:/ebooks";
	}

}
