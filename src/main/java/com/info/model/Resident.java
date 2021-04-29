package com.info.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Resident {
    private int aptId;
    private int residentId;
    private String ho1;
    private String ho2;
    private String ho3;
    private String residentName;
    private boolean contractor;
    private LocalDate buyAt;
    private LocalDate sellAt;
}
