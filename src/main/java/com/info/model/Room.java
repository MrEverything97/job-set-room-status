package com.info.model;

import com.info.model.Enum.RoomStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Room {
    private int aptId;
    private String ho1;
    private String ho2;
    private Resident resident;
    private RoomStatus roomStatus;
    private boolean isShare;
    private int modeFee;
    private LocalDate endDate;
}
