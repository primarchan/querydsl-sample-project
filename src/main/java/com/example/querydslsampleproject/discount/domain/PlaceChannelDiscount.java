package com.example.querydslsampleproject.discount.domain;

import com.amazonaws.services.ec2.model.Reservation;
import com.example.querydslsampleproject.common.domain.BaseTimeEntity;
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
@Table(name = "pl_channel_discount")
public class PlaceChannelDiscount extends BaseTimeEntity implements Serializable {
    private static final long serialVersionUID = -2964463823588888588L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discountAmount;

    private String policyName;

    private Long policyNo;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Builder
    public PlaceChannelDiscount(BigDecimal discountAmount, Long policyNo, String policyName) {
        this.discountAmount = discountAmount;
        this.policyNo = policyNo;
        this.policyName = policyName;
    }

}