package com.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Match;
import com.demo.entities.MatchStatus;


@Repository
public interface MatchRepo extends JpaRepository<Match,Integer> {

	//Derived Query
    Optional<Match> findByTeamHeading(String teamHeading);
   
    List<Match> findByStatus(MatchStatus status);

}
