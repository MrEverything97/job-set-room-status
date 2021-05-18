package com.info.mapper;

import com.info.model.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface RoomMapper {

    List<Room> selectRoomWithExpiredConTract();

    List<Room> selectRoomWithValidContract();

    List<Room> selectRoomHasContractor();

    List<Room> selectRoomHasNoContractor();

    void updateBatchRoom(@Param("list") List<Room> list);

    void updateRoom(Room room);

}
