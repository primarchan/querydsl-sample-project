package com.example.querydslsampleproject.sample.domain;

public enum OrderOptionStatus {
    RESERVATION_REQUESTED, // 요청함
    RESERVATION_SUCCEEDED, // 요청 성공
    RESERVATION_FAILED, // 요청 실패

    CANCEL_REQUESTING, // 예약 취소 요청
    CANCEL_REQUEST_FAILED, // 예약 취소 요청 실퍠
    CANCEL_REQUESTED, // 예약 취소 요청 성공

    CANCELED, // 예약 취소 됨
    CANCEL_FAILED, // 예약 취소 실퍠
    FORCED_CANCELED, // 강제 취소 됨

    RESTORED, // 복구됨

    CONSUMED, // 사용됨

    NOT_USED, //상품 미사용
    USED,  //상품 사용
    CANCELING, //취소 요청
    EXPIRED_CANCELING, //만료된 티켓 자동 취소 요청
    EXPIRED_CANCELING_FAILED, //만료된 티켓 자동 취소 실패
    EXPIRED_CANCELING_SUCCEED, //만료된 티켓 자동 취소 성공

    CANCELING_BATCH, // ETBS 부분 취소 배치 처리

}
