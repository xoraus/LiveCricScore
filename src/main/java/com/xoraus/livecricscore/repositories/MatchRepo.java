package com.xoraus.livecricscore.repositories;

import com.xoraus.livecricscore.entites.Match;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchRepo extends JpaRepository<com.xoraus.livecricscore.entites.Match, Integer> {
    Optional<Match> findByTeamHeading(String teamHeading);
}
