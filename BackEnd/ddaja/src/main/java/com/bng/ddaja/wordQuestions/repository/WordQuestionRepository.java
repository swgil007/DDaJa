package com.bng.ddaja.wordQuestions.repository;

import com.bng.ddaja.common.domain.WordQuestion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordQuestionRepository extends JpaRepository< WordQuestion, Long >{

    public List<WordQuestion> findAll(); 
    public WordQuestion findById( long id ); 
    public List<WordQuestion> findByWId(long id);

}
