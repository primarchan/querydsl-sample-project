package com.example.querydslsampleproject.sample.dto;

import com.example.querydslsampleproject.discount.domain.PlaceChannelDiscount;
import com.example.querydslsampleproject.discount.domain.PlaceChannelDiscountHistory;
import com.example.querydslsampleproject.sample.domain.LeisureChannelDiscount;
import com.example.querydslsampleproject.sample.domain.LeisureChannelDiscountHistory;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ChannelDiscount {
    private BigDecimal discountAmount;

    private Long policyNo;

    private String policyName;


    public ChannelDiscount(PlaceChannelDiscount discount) {
        this.discountAmount = discount.getDiscountAmount();
        this.policyNo = discount.getPolicyNo();
        this.policyName = discount.getPolicyName();
    }

    public ChannelDiscount(PlaceChannelDiscountHistory discount) {
        this.discountAmount = discount.getDiscountAmount();
        this.policyNo = discount.getPolicyNo();
        this.policyName = discount.getPolicyName();
    }

    public ChannelDiscount(LeisureChannelDiscountHistory discount) {
        this.discountAmount = discount.getDiscountAmount();
        this.policyNo = discount.getPolicyNo();
        this.policyName = discount.getPolicyName();
    }

    public ChannelDiscount(LeisureChannelDiscount discount) {
        this.discountAmount = discount.getDiscountAmount();
        this.policyNo = discount.getPolicyNo();
        this.policyName = discount.getPolicyName();
    }

}
