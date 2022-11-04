package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.pojo.Note;
import com.example.demo.pojo.Page;
import com.example.demo.serv.NoteServ;
import com.example.demo.serv.PageServ;

@Controller
public class MainController {
	@Autowired
	private PageServ pageServ;
	@Autowired
	private NoteServ noteServ;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Page> pages = pageServ.pickAll();
		model.addAttribute("Pages", pages);
		return "index";
	}
	
	@RequestMapping("/page/{id}")
	public String page(@PathVariable int id,Model model) {
		List<Page> pages = pageServ.pickAll();
		model.addAttribute("Pages", pages);
		
		List<Note> notes = noteServ.pickAll();
		List<Note> newNotes = new ArrayList<>();
		
		for (Note note : notes) {
			Page page = note.getPage();
			if (page.getId() == id) {
				newNotes.add(note);
			}
		}
		
		model.addAttribute("Notes", newNotes);
		return "page";
	}
	@RequestMapping("/create")
	public String createPage() {
		Page page = new Page();
		pageServ.Save(page);
		
		return "redirect:/";
	}
	@RequestMapping("/insertNote/{id}")
	public String insertNote(@PathVariable int id, @RequestBody MultiValueMap<String, String> formData) {
		String noteString = formData.getFirst("note");
		Page page = pageServ.getById(id);
		Note note = new Note(noteString, page);
		noteServ.Save(note);
		return "redirect:/page/{id}";
	}
	@RequestMapping("/deleteNote/{id}")
	public String deleteNote(@PathVariable int id) {
		Note note = noteServ.getById(id);
		Page page = note.getPage();
		int id_page = page.getId();
		String returnString = "redirect:/page/" + id_page;
		
		noteServ.delete(note);
		return returnString;
	}
}
