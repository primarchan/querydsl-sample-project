package com.example.querydslsampleproject.place.reservation.domain;

import com.example.querydslsampleproject.sample.dto.PlaceCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name = "pl_reservation_place_info_history")
@Entity
@NoArgsConstructor
public class ReservationPlaceInfoHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long placeNo;

    private String roomLevel;

    private String placeName;

    private String placeAddress;

    private Long roomNo;

    @Enumerated(EnumType.STRING)
    private PlaceCategory category;

}
