package com.example.manitto.services;

import com.example.manitto.repositories.UserMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by jonghyeon on 2023/01/24,
 * Package : com.example.manitto.services
 */
@Service
@RequiredArgsConstructor
public class UserMatchService {
    private final UserMatchRepository userMatchRepository;
    
}
