package com.example.querydslsampleproject.discount.domain;

import com.example.querydslsampleproject.common.domain.BaseTimeEntity;
import com.example.querydslsampleproject.place.reservation.domain.ReservationHistory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "pl_channel_discount_history")
public class PlaceChannelDiscountHistory extends BaseTimeEntity implements Serializable {
    private static final long serialVersionUID = -2964463823588888588L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discountAmount;

    private String policyName;

    private Long policyNo;

    @ManyToOne
    @JoinColumn(name = "reservation_history_id")
    private ReservationHistory reservation;

    @Builder
    public PlaceChannelDiscountHistory(BigDecimal discountAmount, Long policyNo, String policyName) {
        this.discountAmount = discountAmount;
        this.policyNo = policyNo;
        this.policyName = policyName;
    }

}

