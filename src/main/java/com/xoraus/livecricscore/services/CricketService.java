package com.xoraus.livecricscore.services;

import com.xoraus.livecricscore.entites.Match;

import java.util.List;

public interface CricketService {
    List<Match> getLiveMatchScores();
    List<List<String>> getCWC2023PointTable();
    List<Match> getAllMatches();

}
