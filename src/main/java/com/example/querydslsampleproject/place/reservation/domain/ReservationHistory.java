package com.example.querydslsampleproject.place.reservation.domain;

import com.example.querydslsampleproject.discount.domain.PlaceChannelDiscountHistory;
import com.example.querydslsampleproject.sample.domain.PaymentCancelStatus;
import com.example.querydslsampleproject.sample.dto.ChannelDiscount;
import com.example.querydslsampleproject.sample.dto.ReservationStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Table(name = "pl_reservation_history")
@Entity
@Getter
@NoArgsConstructor
public class ReservationHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long bpReservationNo;

    @Column(unique = true)
    private Long yanReservationNo;

    private LocalDateTime checkIn;

    private LocalDateTime checkOut;

    private boolean hasVehicle;

    @Column(precision = 19, scale = 0)
    private BigDecimal roomPrice;

    @Column
    private Long couponId;

    @Column(precision = 19, scale = 0)
    private BigDecimal couponPrice;

    @Column(precision = 19, scale = 0)
    private BigDecimal paymentPrice;

    @Column(length = 20)
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;

    private LocalDateTime canceledDate;

    private LocalDateTime reservationDate;

    private boolean isDeleted = false;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "place_info_id")
    private ReservationPlaceInfoHistory placeInfo;

    private String channel;

    private LocalDateTime reservationRequestTime;

    private LocalDateTime paymentTime;

    private LocalDateTime reservationConfirmTime;

    private LocalDateTime cancelTime;

    private String cancelReason;

    @Column(precision = 19, scale = 0)
    private BigDecimal penaltyFee;

    @Enumerated(EnumType.STRING)
    private PaymentCancelStatus paymentCancelStatus;

    private String browserId;

    private boolean isConsecutiveNight;

    @Column(precision = 19, scale = 0)
    private BigDecimal creditCardAmount;

    @Column(precision = 19, scale = 0)
    private BigDecimal welfarePoint;

    @Column(precision = 19, scale = 0)
    private BigDecimal account;

    @Column(precision = 19, scale = 0)
    private BigDecimal channelDiscountAmount;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL)
    private List<PlaceChannelDiscountHistory> placeChannelDiscounts;


    public BigDecimal getChannelDiscountAmount(){
        return this.channelDiscountAmount == null ? BigDecimal.ZERO: this.channelDiscountAmount;
    }

    public List<ChannelDiscount> getChannelDiscount() {
        return this.placeChannelDiscounts.stream().map(ChannelDiscount::new).collect(Collectors.toList());
    }
}