package com.s.insertsekolah.Api.respon;

import com.s.insertsekolah.Api.model.sekolah;

import java.util.ArrayList;
import java.util.List;

public class Respon {
    int status;
    String message;
    ArrayList<sekolah> data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<sekolah> getData() {
        return data;
    }
}
