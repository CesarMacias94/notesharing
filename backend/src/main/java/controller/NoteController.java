package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bean.Note;
import service.NoteService;

@RestController
public class NoteController {

    @Autowired
    NoteService noteService;

    @RequestMapping("api/note/{cod_note}")
    public @ResponseBody ResponseEntity<?> getNote(@PathVariable String cod_note) {
        try {
            return new ResponseEntity<Note>(noteService.getNote(cod_note), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(path = "api/addnote", method=RequestMethod.POST)
    public @ResponseBody ResponseEntity<?> createNote(@RequestBody Note note) {
        try {
            return new ResponseEntity<Integer>(noteService.createNote(note), HttpStatus.OK);
        }
        catch(Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}