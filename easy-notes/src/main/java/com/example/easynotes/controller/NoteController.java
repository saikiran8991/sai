package com.example.easynotes.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NotesRepository;
 
@RestController   
@RequestMapping("/api")
public class NoteController {
	   
	@Autowired
	NotesRepository notesRepository;
	 
	@GetMapping("/notes")
	public List<Note> findAll(){
		
	return notesRepository.findAll();
	}
	@GetMapping
	public Optional<Note> findById(@PathVariable (value = "/id") Long noteId) {
		return notesRepository.findById(noteId);
		
	}
	@PostMapping ("/notes")
		public Note createNote(@Valid @RequestBody Note note) {
			return notesRepository.save(note);
		}
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Note> deleteNote(@PathVariable(value = "id") Long noteId) {
	    Optional<Note> note = notesRepository.findById(noteId);
	    notesRepository.deleteById(noteId);
	    return ResponseEntity.ok().build();
	}
		
	
}
