package com.info.service;

import com.info.mapper.RoomMapper;
import com.info.model.Enum.RoomStatus;
import com.info.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomStatusService {
    @Autowired
    private RoomMapper roomMapper;

    public List<Room> getAllRoom() {
        return roomMapper.selectRoomWithResidentByModeFee();
    }

    public void updateRoomStatusWithResident() {
        List<Room> roomList = roomMapper.selectRoomWithResidentByModeFee();
        for (Room room : roomList) {
            if (room.getResident().getResidentId() != 0) {
                room.setRoomStatus(RoomStatus.IN_USE);
            } else {
                room.setRoomStatus(RoomStatus.VACANCY);
            }
            roomMapper.updateRoomStatus(room);
        }
    }

    public void updateRoomStatusWithContract() {
        List<Room> roomList = roomMapper.selectRoomWithContractByModFee();
        for (Room room : roomList) {
            if (isUsed(room)) {
                if (room.isShare()) {
                    room.setRoomStatus(RoomStatus.USE_A_PART);
                } else {
                    room.setRoomStatus(RoomStatus.IN_USE);
                }
            } else {
                room.setRoomStatus(RoomStatus.VACANCY);
            }
            roomMapper.updateRoomStatus(room);
        }
    }

    public boolean isUsed(Room room) {
        return roomMapper.isExistContractWithRoom(room.getAptId(), room.getHo1(), room.getHo2());
    }
}
