package com.example.querydslsampleproject.sample.dto;

public enum YanOrderRefundType {
    REFUND_NOW, // 즉시 환불
    REFUND_IN_1D, // 24시간 이후 자동 환불
    REFUND_IN_7D, // 운영팀이 환불 가능 여부를 확인한 후에 취소요청 승인
    FAIL // 네트워크나 서버 장애, API 연동실패, 이미 취소된 주문, 이미 사용된 주문 등의 이유로 취소처리 실패
}
