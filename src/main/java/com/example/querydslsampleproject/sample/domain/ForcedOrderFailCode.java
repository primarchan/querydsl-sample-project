package com.example.querydslsampleproject.sample.domain;

public enum ForcedOrderFailCode {
    LESS_VISITOR, // 모객 실패로 인한 일정 취소
    SHOP_REQUESTED, // 시설사 요청으로 인한 취소
    STOCK_FAILED, // 재고 부족
    ORDER_RECOVER_FAILED, // 시설사 연동 실퍠
    RESERVATION_PERIOD_EXPIRED, // 예약기간만료
    VALIDITY_PERIOD_EXPIRED // 유효기간 만료
}