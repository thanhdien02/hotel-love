package com.example.hotellove.services.ThanhToan;

import com.example.hotellove.dtos.NhanPhong.NhanPhongDto;
import com.example.hotellove.dtos.ThanhToan.ThanhToanDto;
import com.example.hotellove.entities.NhanPhong;
import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.entities.ThanhToan;

import java.util.List;

public interface ThanhToanService {

    ThanhToan getThanhToan(String id);

    List<ThanhToan> getAll();

    ThanhToan create(ThanhToanDto dto);

    ThanhToan update(String id, ThanhToanDto dto);

    ThanhToan delete (String id);
}
