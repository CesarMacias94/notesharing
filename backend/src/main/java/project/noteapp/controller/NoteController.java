package project.noteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.noteapp.bean.Note;
import project.noteapp.bean.NoteDTO;
import project.noteapp.service.NoteService;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @RequestMapping("api/notescourse/{cod_course}")
    public @ResponseBody ResponseEntity<?> getNotesByCourse(@PathVariable String cod_course) {
        try {
            return new ResponseEntity<List<NoteDTO>>(noteService.getNotesByCourse(cod_course), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("api/note/{cod_note}")
    public @ResponseBody ResponseEntity<?> getNote(@PathVariable String cod_note) {
        try {
            return new ResponseEntity<NoteDTO>(noteService.getNote(cod_note), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "api/addnote", method=RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> createNote(@RequestBody NoteDTO note) {
        try {
            return new ResponseEntity<Integer>(noteService.createNote(note), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}