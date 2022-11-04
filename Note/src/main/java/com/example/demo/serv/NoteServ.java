package com.example.demo.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Note;
import com.example.demo.repo.NoteRepo;

@Service
public class NoteServ {
	@Autowired
	private NoteRepo noteRepo;
	
	public void Save(Note note) {
		noteRepo.save(note);
	}
	public List<Note> pickAll() {
		return noteRepo.findAll();
	}
	public void delete(Note note) {
		noteRepo.delete(note);
	}
	public Note getById(int id) {
		return noteRepo.getReferenceById(id);
	}
}
