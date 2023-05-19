package com.example.hotellove.services.ThanhToan;

import com.example.hotellove.dtos.NhanPhong.NhanPhongDto;
import com.example.hotellove.dtos.ThanhToan.ThanhToanDto;
import com.example.hotellove.entities.NhanPhong;
import com.example.hotellove.entities.ThanhToan;

public interface ThanhToanService {

    ThanhToan getThanhToan(String id);

    ThanhToan create(ThanhToanDto dto);

    ThanhToan update(String id, ThanhToanDto dto);

    ThanhToan delete (String id);
}
