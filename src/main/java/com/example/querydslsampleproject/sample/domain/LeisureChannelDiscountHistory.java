package com.example.querydslsampleproject.sample.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "le_channel_discount")
public class LeisureChannelDiscountHistory implements Serializable {
    private static final long serialVersionUID = 8598799509115039007L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discountAmount;

    private Long policyNo;

    private String policyName;

    private Boolean isCanceled;

    @ManyToOne
    @JoinColumn(name = "order_option_history_id")
    @JsonBackReference
    private LeisureOrderOptionHistory orderOption;

    @Builder
    public LeisureChannelDiscountHistory(BigDecimal discountAmount, Long policyNo,String policyName, LeisureOrderOptionHistory orderOption) {
        this.discountAmount = discountAmount;
        this.policyNo = policyNo;
        this.policyName = policyName;
        this.orderOption = orderOption;
        this.isCanceled = Boolean.FALSE;
    }

}
