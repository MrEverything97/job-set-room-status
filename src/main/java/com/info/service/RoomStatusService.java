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

    public void updateRoomStatusWithResident() {
        List<Room> noContractorList = roomMapper.selectRoomHasNoContractor();
        noContractorList.forEach(room -> room.setRoomStatus(RoomStatus.VACANCY));

        List<Room> hasContractorList = roomMapper.selectRoomHasContractor();
        hasContractorList.forEach(room -> room.setRoomStatus(RoomStatus.IN_USE));

        roomMapper.updateBatchRoom(noContractorList);
        roomMapper.updateBatchRoom(hasContractorList);
    }

    public void updateRoomStatusWithContract() {
        List<Room> roomExpiredContractList = roomMapper.selectRoomWithExpiredConTract();
        roomExpiredContractList.forEach(room -> room.setRoomStatus(RoomStatus.VACANCY));

        List<Room> roomValidContractList = roomMapper.selectRoomWithValidContract();
        roomValidContractList.forEach(room -> {
            if (room.isShare()) {
                room.setRoomStatus(RoomStatus.USE_A_PART);
            }else {
                room.setRoomStatus(RoomStatus.IN_USE);
            }
        });

        roomMapper.updateBatchRoom(roomExpiredContractList);
        roomMapper.updateBatchRoom(roomValidContractList);
    }

}
