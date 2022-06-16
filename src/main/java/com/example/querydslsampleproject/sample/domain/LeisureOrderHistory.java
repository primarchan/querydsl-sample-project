package com.example.querydslsampleproject.sample.domain;

import com.example.querydslsampleproject.common.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "le_order_history")
@Entity
public class LeisureOrderHistory extends BaseTimeEntity implements Serializable {
    private static final long serialVersionUID = 8038076173964653418L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bpOrderId;

    private Long yanOrderId;

    private Long dealId;

    private String dealName;

    private Long customerId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    private List<LeisureOrderOptionHistory> options;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Enumerated(EnumType.STRING)
    private PaymentCancelStatus paymentCancelStatus;

    private String channel;

    private String category;

    private LocalDate reservedDate;

    @Column(precision = 19, scale = 0)
    private BigDecimal totalCostPrice;

    @Column(precision = 19, scale = 0)
    private BigDecimal totalCoverPrice;

    @Column(precision = 19, scale = 0)
    private BigDecimal totalSalePrice;

    @Column(precision = 19, scale = 0)
    private BigDecimal canceledPrice; // 결제한 이후 취소한 금액

    @Column(precision = 19, scale = 0)
    private BigDecimal creditCardAmount;

    @Column(precision = 19, scale = 0)
    private BigDecimal accountAmount;

    @Column(precision = 19, scale = 0)
    private BigDecimal welfarePointAmount;

    public void cancelOption(List<Long> optionIds, String cancelReason, String chargedName) {
        for (LeisureOrderOptionHistory option : options) {
            for (Long optionId : optionIds) {
                if (option.getYanOrderedOptionId() == optionId) {
                    option.setStatus(OrderOptionStatus.CANCEL_REQUESTED);
                    option.setCancelReason(cancelReason);
                    option.setChargedName(chargedName);
                    break;
                }
            }

        }
    }

    public BigDecimal getTotalPrice() {
        return Optional.ofNullable(this.totalSalePrice)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal getCanceledPrice() {
        return Optional.ofNullable(this.canceledPrice)
                .orElse(BigDecimal.ZERO);
    }

    @Builder
    public LeisureOrderHistory(Long bpOrderId, Long yanOrderId, Long dealId, String dealName, Long customerId, List<LeisureOrderOptionHistory> options, OrderStatus status, PaymentCancelStatus paymentCancelStatus, String channel, String category, LocalDate reservedDate, BigDecimal totalCostPrice, BigDecimal totalCoverPrice, BigDecimal totalSalePrice, BigDecimal canceledPrice, BigDecimal creditCardAmount) {
        this.id = id;
        this.bpOrderId = bpOrderId;
        this.yanOrderId = yanOrderId;
        this.dealId = dealId;
        this.dealName = dealName;
        this.customerId = customerId;
        this.options = options;
        this.status = status;
        this.paymentCancelStatus = paymentCancelStatus;
        this.channel = channel;
        this.category = category;
        this.reservedDate = reservedDate;
        this.totalCostPrice = totalCostPrice;
        this.totalCoverPrice = totalCoverPrice;
        this.totalSalePrice = totalSalePrice;
        this.canceledPrice = canceledPrice;
        this.creditCardAmount = creditCardAmount;
        this.accountAmount = accountAmount;
        this.welfarePointAmount = welfarePointAmount;
    }

}
