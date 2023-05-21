package com.example.hotellove.services.DatPhong;

import com.example.hotellove.dtos.DatPhong.DatPhongDto;
import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.entities.DatPhong;
import com.example.hotellove.entities.Phong;
import com.example.hotellove.entities.TaiKhoan;

import java.util.List;

public interface DatPhongService {

    DatPhong getDatPhong(String id);

    List<DatPhong> getAll();
    DatPhong create(DatPhongDto dto);

    DatPhong update(String id, DatPhongDto dto);

    DatPhong delete (String id);
}
