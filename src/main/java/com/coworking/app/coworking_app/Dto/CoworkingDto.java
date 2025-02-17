package com.coworking.app.coworking_app.Dto;

import com.coworking.app.coworking_app.Model.Coworking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
public class CoworkingDto {
    private Long id;
    private String workSpaceName;
    private int amountOfRooms;
    private LocalDateTime reservationTime;
    private Long userId;
    public CoworkingDto(Coworking coworking) {
        this.id = coworking.getId();
        this.workSpaceName = coworking.getWorkSpaceName();
        this.amountOfRooms = coworking.getAmountOfRooms();
        this.reservationTime = coworking.getReservationTime();
        this.userId = coworking.getUser().getId();
    }
}
