package com.example.hotellove.services.Phong;

import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.entities.Phong;
import com.example.hotellove.entities.TaiKhoan;

public interface PhongService {

    Phong getPhong(String id);
    Phong create(PhongDto dto);
    Phong update(String id, PhongDto dto);

    Phong delete (String id);

    boolean kiemTraTenPhongGiaTienVaLoaiPhong(String tenPhong, Double giaPhong, String loaiPhong);
}
