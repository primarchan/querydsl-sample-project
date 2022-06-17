package com.example.querydslsampleproject.sample.service;

import com.example.querydslsampleproject.sample.domain.LeisureOrderOptionSimple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LeisureOrderOptionQueryService {

    private final LeisureOrderOptionSearchService leisureOrderOptionSearchService;

}
