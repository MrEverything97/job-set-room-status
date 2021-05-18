package com.info.controller;



import com.info.service.RoomStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class RoomStatusController {
    @Autowired
    private RoomStatusService roomStatusService;

    @Scheduled(cron = "0 1 * * * *")
    @GetMapping("/run")
    private ResponseEntity<?> updateRoomStatus() {
        roomStatusService.updateRoomStatusWithResident();
        roomStatusService.updateRoomStatusWithContract();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

