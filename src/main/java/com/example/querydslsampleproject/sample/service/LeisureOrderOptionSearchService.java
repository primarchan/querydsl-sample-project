package com.example.querydslsampleproject.sample.service;

import com.example.querydslsampleproject.sample.domain.LeisureOrderOptionSimple;
import com.example.querydslsampleproject.sample.dto.SearchType;
import com.example.querydslsampleproject.sample.repository.LeisureOrderUnionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LeisureOrderOptionSearchService {
    private final LeisureOrderUnionRepository leisureOrderUnionRepository;
    // private final LeisureOrderUnionNonPagingRepository leisureOrderUnionNonPagingRepository;

    // 예약 상태 (ALL)
    public PageImpl<LeisureOrderOptionSimple> searchAllReservationByReservationDate(LocalDateTime dateFrom, LocalDateTime dateTo, String keyword, SearchType searchType, Pageable pageable) {
        PageImpl<LeisureOrderOptionSimple> leisureOrderList;

        if (keyword.isEmpty()) { // 예약 상태 (전체) + 예약일 + 전체 채널 + 검색조건 없음
            leisureOrderList = leisureOrderUnionRepository.findByReservationDate(dateFrom, dateTo, pageable);
        } else {
            switch (searchType){
                default:
                case CHANNEL_RESERVATION_NO: // 예약 상태 (전체) + 예약일 + 전체 채널 + 검색조건 (채널 예약 번호)
                    leisureOrderList = leisureOrderUnionRepository.findByReservationDateAndBpReservationNo(dateFrom, dateTo, keyword, pageable);
                    break;

                case YAN_RESERVATION_NO: // 예약 상태 (전체) + 예약일 + 전체 채널 + 검색조건 (야놀자 예약 번호)
                    leisureOrderList = leisureOrderUnionRepository.findByReservationDateAndYanReservationNo(dateFrom, dateTo, keyword, pageable);
                    break;
            }
        }
        return leisureOrderList;
    }

}
