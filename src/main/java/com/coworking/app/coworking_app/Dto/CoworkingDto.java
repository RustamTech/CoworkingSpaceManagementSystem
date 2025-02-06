package com.coworking.app.coworking_app.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoworkingDto {
    private int id;
    private String workSpaceName;
    private int amountOfRooms;
    private LocalDateTime reservationTime;
    private int userId;
}