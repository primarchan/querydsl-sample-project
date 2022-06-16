package com.example.querydslsampleproject.sample.domain;

import com.example.querydslsampleproject.common.domain.BaseTimeEntity;
import com.example.querydslsampleproject.sample.dto.ChannelDiscount;
import com.example.querydslsampleproject.sample.dto.YanOrderRefundType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "le_order_option_history")
@Entity
public class LeisureOrderOptionHistory extends BaseTimeEntity implements Serializable {
    private static final long serialVersionUID = 4193903845321986909L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String channel;

    private long optionId; // 딜 옵션의 ID

    private int quantity; // 수량

    @Column(precision = 19, scale = 0)
    private BigDecimal coverPrice;  //정상가

    @Column(precision = 19, scale = 0)
    private BigDecimal costPrice; // 옵션 1개당 정산가 - api 요청에만 사용

    @Column(precision = 19, scale = 0)
    private BigDecimal salePrice; // 판매가격

    @Column(precision = 19, scale = 0)
    private BigDecimal channelDiscountAmount; // 할인금액

    @Enumerated(EnumType.STRING)
    private OrderOptionStatus status;

    private LocalDateTime canceledDate;

    private LocalDateTime consumedDate;

    private String cancelReason;

    private String cancelFailMessage;

    private String chargedName;

    @Enumerated(EnumType.STRING)
    private OrderFailCode orderFailCode;

    @Enumerated(EnumType.STRING)
    private ForcedOrderFailCode forcedOrderFailCode;

    private String optionName;

    @Enumerated(EnumType.STRING)
    private YanOrderRefundType refundType;

    private long yanOrderedOptionId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private LeisureOrderHistory order;


    private LocalDate expiredDate;

    @OneToMany(mappedBy = "orderOption", cascade = CascadeType.ALL)
    @JsonManagedReference
    @Transient
    private List<LeisureChannelDiscountHistory> channelDiscounts;

    @Builder
    public LeisureOrderOptionHistory(long optionId, String channel, int quantity, BigDecimal coverPrice, BigDecimal costPrice, BigDecimal salePrice, OrderOptionStatus status, LocalDateTime canceledDate, LocalDateTime consumedDate, String cancelReason, String cancelFailMessage, String chargedName, OrderFailCode orderFailCode, ForcedOrderFailCode forcedOrderFailCode, String optionName, YanOrderRefundType refundType, long yanOrderedOptionId, LeisureOrderHistory order) {
        this.channel = channel;
        this.optionId = optionId;
        this.quantity = quantity;
        this.coverPrice = coverPrice;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.status = status;
        this.canceledDate = canceledDate;
        this.consumedDate = consumedDate;
        this.cancelReason = cancelReason;
        this.cancelFailMessage = cancelFailMessage;
        this.chargedName = chargedName;
        this.orderFailCode = orderFailCode;
        this.forcedOrderFailCode = forcedOrderFailCode;
        this.optionName = optionName;
        this.refundType = refundType;
        this.yanOrderedOptionId = yanOrderedOptionId;
        this.order = order;
    }

    public BigDecimal getChannelDiscountAmount(){
        return this.channelDiscountAmount == null ? BigDecimal.ZERO: this.channelDiscountAmount;
    }

    public List<ChannelDiscount> getChannelDiscount() {
        if(this.channelDiscounts == null){
            return null;
        }
        return this.channelDiscounts.stream().map(ChannelDiscount::new).collect(Collectors.toList());
    }

}
