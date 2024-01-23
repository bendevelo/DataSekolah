package com.s.insertsekolah.Api.respon;

import java.util.List;

public class ResponString {
    String status;
    List<Data> data;

    public String getStatus() {
        return status;
    }

    public List<Data> getData() {
        return data;
    }

   public class Data{

        String id;
        String name,nama;

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

       public String getNama() {
           return nama;
       }
   }
}
