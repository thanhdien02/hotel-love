package com.example.hotellove.services.NhanPhong;

import com.example.hotellove.dtos.NhanPhong.NhanPhongDto;
import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.entities.NhanPhong;
import com.example.hotellove.entities.Phong;
import com.example.hotellove.entities.TaiKhoan;

import java.util.List;

public interface NhanPhongService {

    NhanPhong getNhanPhong(String id);

    List<NhanPhong> getAll();
    NhanPhong create(NhanPhongDto dto);
    NhanPhong update(String id, NhanPhongDto dto);
    NhanPhong delete (String id);
}
