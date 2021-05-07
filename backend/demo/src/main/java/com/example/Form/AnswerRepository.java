package com.example.Form;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.Form.Answer;
import com.example.Form.Question;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.query.Param;
// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AnswerRepository extends CrudRepository<Answer, Long> {
	List<Answer> findByAnswerFormIdOrderByOrderInForm(Long answerFormId);
	
	@Query("SELECT a FROM Answer a Where a.questionId=:questionId")
	List<Answer> getAnswersByAnswerFormId(@Param("questionId")Long questionId);
}
