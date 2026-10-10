package smartnotes_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smartnotes_backend.entity.Note;
import smartnotes_backend.repository.NoteRepository;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:3001")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    // ADD NOTE
    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    // GET ALL NOTES
    @GetMapping
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // UPDATE NOTE
    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @RequestBody Note note) {

        Note existingNote = noteRepository.findById(id).orElse(null);

        if (existingNote != null) {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());

            return noteRepository.save(existingNote);
        }

        return null;
    }

    // DELETE NOTE
    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id) {

        noteRepository.deleteById(id);

        return "Note deleted successfully";
    }
}

