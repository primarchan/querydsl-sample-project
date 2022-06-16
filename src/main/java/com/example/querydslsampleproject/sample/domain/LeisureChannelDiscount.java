package com.example.querydslsampleproject.sample.domain;

import com.example.querydslsampleproject.common.domain.BaseTimeEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class LeisureChannelDiscount extends BaseTimeEntity implements Serializable {
    private static final long serialVersionUID = 3571422070970705437L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal discountAmount;

    private Long policyNo;

    private String policyName;

    private Boolean isCanceled;

    @ManyToOne
    @JoinColumn(name = "order_option_id")
    @JsonBackReference
    private LeisureOrderOption orderOption;

}
