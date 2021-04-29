package com.info.model;

import com.info.model.Enum.RoomStatus;
import com.info.model.Enum.RoomType;
import lombok.Data;


@Data
public class Room {
    private int aptId;
    private String ho1;
    private String ho2;
    private Resident resident;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private boolean isShare;
    private int modeFee;
}
