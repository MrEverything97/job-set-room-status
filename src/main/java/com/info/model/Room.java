package com.info.model;

import com.info.model.Enum.RoomStatus;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Room {
    private int aptId;
    private String ho1;
    private String ho2;
    private RoomStatus roomStatus;
    private boolean isShare;

    @Override
    public String toString() {
        return aptId + " " + ho1 + " " + ho2;
    }
}
