package com.harsha.personmovie.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harsha.personmovie.entity.PersonMovieRel;

@Repository
public interface PersonMovieRepo extends JpaRepository<PersonMovieRel, Integer> {

	List<PersonMovieRel> findByPersonId(Long personId);

}
