package smartnotes_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import smartnotes_backend.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
