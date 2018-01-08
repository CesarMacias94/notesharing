package project.noteapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.noteapp.bean.Note;
import project.noteapp.bean.NoteDTO;
import project.noteapp.dao.NoteDAO;

import java.util.List;

@Service
public class NoteService {

    @Autowired
    NoteDAO noteDAO;

    public List<NoteDTO> getNotesByCourse(String cod_course) {
        return noteDAO.getNotesByCourse(cod_course);
    }

    public NoteDTO getNote(String cod_note) {
        return noteDAO.getNote(cod_note);
    }

    public Integer createNote(NoteDTO note) {
        return noteDAO.createNote(note);
    }
}