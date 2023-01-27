package com.example.manitto.services;

import com.example.manitto.dtos.Match;
import com.example.manitto.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Created by jonghyeon on 2023/01/25,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    
    public List<Match> getMatchListActive(){
    		return matchRepository.getMatchListActive();
    }
}
