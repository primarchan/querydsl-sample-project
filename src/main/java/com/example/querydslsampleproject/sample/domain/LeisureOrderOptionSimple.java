package com.example.querydslsampleproject.sample.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class LeisureOrderOptionSimple {
    @Id
    private Long id;
    private String channel;
    private Long bpOrderId;
    private Long yanOrderId;
    private Long customerId;
    private LocalDateTime createdDate;
    private LocalDateTime consumedDate;
    private LocalDateTime canceledDate;
    private String dealName;
    private String optionName;
    private Long yanOrderedOptionId;
    private BigDecimal salePrice;
    private BigDecimal channelDiscountAmount;
    private BigDecimal creditCardAmount;
    private BigDecimal welfarePointAmount;
    private BigDecimal accountAmount;
    private BigDecimal totalSalePrice;

    @Enumerated(EnumType.STRING)
    private OrderOptionStatus status;

    public LeisureOrderOptionSimple(LeisureOrderOption leisureOrderOption) {
        this.id = leisureOrderOption.getId();
        this.channel = leisureOrderOption.getChannel();
        this.bpOrderId = leisureOrderOption.getOrder().getBpOrderId();
        this.yanOrderId = leisureOrderOption.getOrder().getYanOrderId();
        this.customerId = leisureOrderOption.getOrder().getCustomerId();
        this.createdDate = leisureOrderOption.getCreatedDate();
        this.consumedDate = leisureOrderOption.getConsumedDate();
        this.canceledDate = leisureOrderOption.getCanceledDate();
        this.dealName = leisureOrderOption.getOrder().getDealName();
        this.optionName = leisureOrderOption.getOptionName();
        this.salePrice = leisureOrderOption.getSalePrice();
        this.channelDiscountAmount = leisureOrderOption.getChannelDiscountAmount();
        this.status = leisureOrderOption.getStatus();
        this.yanOrderedOptionId = leisureOrderOption.getYanOrderedOptionId();
        this.creditCardAmount = leisureOrderOption.getOrder().getCreditCardAmount();
        this.welfarePointAmount = leisureOrderOption.getOrder().getWelfarePointAmount();
        this.accountAmount = leisureOrderOption.getOrder().getAccountAmount();
        this.totalSalePrice = leisureOrderOption.getOrder().getTotalSalePrice();
    }

    public LeisureOrderOptionSimple(LeisureOrderOptionHistory leisureOrderOption) {
        this.id = leisureOrderOption.getId();
        this.channel = leisureOrderOption.getChannel();
        this.bpOrderId = leisureOrderOption.getOrder().getBpOrderId();
        this.yanOrderId = leisureOrderOption.getOrder().getYanOrderId();
        this.customerId = leisureOrderOption.getOrder().getCustomerId();
        this.createdDate = leisureOrderOption.getCreatedDate();
        this.consumedDate = leisureOrderOption.getConsumedDate();
        this.canceledDate = leisureOrderOption.getCanceledDate();
        this.dealName = leisureOrderOption.getOrder().getDealName();
        this.optionName = leisureOrderOption.getOptionName();
        this.salePrice = leisureOrderOption.getSalePrice();
        this.channelDiscountAmount = leisureOrderOption.getChannelDiscountAmount();
        this.status = leisureOrderOption.getStatus();
        this.yanOrderedOptionId = leisureOrderOption.getYanOrderedOptionId();
        this.creditCardAmount = leisureOrderOption.getOrder().getCreditCardAmount();
        this.welfarePointAmount = leisureOrderOption.getOrder().getWelfarePointAmount();
        this.accountAmount = leisureOrderOption.getOrder().getAccountAmount();
        this.totalSalePrice = leisureOrderOption.getOrder().getTotalSalePrice();
    }

}
