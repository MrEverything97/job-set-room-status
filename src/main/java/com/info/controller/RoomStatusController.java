package com.info.controller;


import com.info.model.Room;
import com.info.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class RoomStatusController {
    @Autowired
    private RoomStatusService roomStatusService;

    @GetMapping("/run")
    private ResponseEntity<?> updateRoomStatus() {
        roomStatusService.updateRoomStatusWithResident();
        roomStatusService.updateRoomStatusWithContract();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/test")
    private ResponseEntity<?> test() {
        List<Room> roomList = roomStatusService.getAllRoom();
        if (roomList.size()>0) {
            return new ResponseEntity<>(roomList, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
