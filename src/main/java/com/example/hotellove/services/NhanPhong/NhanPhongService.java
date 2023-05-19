package com.example.hotellove.services.NhanPhong;

import com.example.hotellove.dtos.NhanPhong.NhanPhongDto;
import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.entities.NhanPhong;
import com.example.hotellove.entities.Phong;

public interface NhanPhongService {

    NhanPhong getNhanPhong(String id);
    NhanPhong create(NhanPhongDto dto);
    NhanPhong update(String id, NhanPhongDto dto);
    NhanPhong delete (String id);
}
