package com.example.demo.serv;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.pojo.Page;
import com.example.demo.repo.PageRepo;

@Service
public class PageServ {
	@Autowired
	private PageRepo pageRepo;
	
	public void Save(Page page) {
		pageRepo.save(page);
	}
	public List<Page> pickAll() {
		return pageRepo.findAll();
	}
	public void delete(Page page) {
		pageRepo.delete(page);
	}
	public Page getById(int id) {
		return pageRepo.getReferenceById(id);
	}
}
