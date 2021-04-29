package com.info.mapper;

import com.info.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface RoomMapper {
    @Select("SELECT * FROM BA_ROOM")
    List<Room> selectRoomWithResidentByModeFee();

    List<Room> selectRoomWithContractByModFee();

    void updateRoomStatus(Room jobRoom);

    boolean isExistContractWithRoom(int aptId, String ho1, String ho2);
}
