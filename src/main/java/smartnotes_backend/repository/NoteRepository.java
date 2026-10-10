package smartnotes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import smartnotes_backend.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
