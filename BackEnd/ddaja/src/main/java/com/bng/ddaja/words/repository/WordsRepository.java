package com.bng.ddaja.words.repository;

import com.bng.ddaja.common.domain.Word;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordsRepository extends JpaRepository< Word, Long >{
    
    public Word findById(long id);

    public Word findByTitle(String title);

    public List<Word> findAll();
}