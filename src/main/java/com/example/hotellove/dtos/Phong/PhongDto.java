package com.example.hotellove.dtos.Phong;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhongDto {

    // Ten phong khong duoc trung nhau
    private String tenPhong;

    private int soGiuong;

    private double giaPhong;


    private String loaiPhong;
}
