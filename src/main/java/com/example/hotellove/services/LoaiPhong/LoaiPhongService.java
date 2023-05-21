package com.example.hotellove.services.LoaiPhong;

import com.example.hotellove.dtos.LoaiPhong.LoaiPhongDto;
import com.example.hotellove.dtos.taikhoan.TaiKhoanDto;
import com.example.hotellove.entities.LoaiPhong;
import com.example.hotellove.entities.TaiKhoan;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LoaiPhongService {

    LoaiPhong create(LoaiPhongDto dto);

    LoaiPhong getLoaiPhong(String id);

    List<LoaiPhong> getAll();

    LoaiPhong update (LoaiPhongDto dto, String id);

    LoaiPhong delete (String id);
}
