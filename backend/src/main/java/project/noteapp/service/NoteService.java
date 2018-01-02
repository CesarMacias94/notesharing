package project.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.noteapp.bean.Note;
import project.noteapp.dao.NoteDAO;

@Service
public class NoteService {

    @Autowired
    NoteDAO noteDAO;

    public Note getNote(String cod_note) {
        return noteDAO.getNote(cod_note);
    }

    public Integer createNote(Note note) {
        return noteDAO.createNote(note);
    }
}