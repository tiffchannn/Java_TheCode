package com.tiffany.thecode;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class Contollers {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/codeSubmission", method=RequestMethod.POST)
	public String codeSubmission(@RequestParam(value="input") String input, RedirectAttributes redirectAttributes, HttpSession session) {

		session.setAttribute("input", input); // saving the info
		
		if (input.equals("bushido")) {
			System.out.print("Correctly guessed Bushido!");
			return "redirect:/code"; // since this is a POST, DO NOT render! redirect to the matching path method which is /code
		} else {

			System.out.print("Try again!");
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
		}
		return "redirect:/";
	}
	
	@RequestMapping("/code") // take us to the path route
	public String success(HttpSession session, Model model) {
		String input = (String) session.getAttribute("input");
		System.out.println("We're in success!");
//		model.addAttribute("input", input); // Allows us to pass the form data into our jsp page
        return "code.jsp";
	}
}
