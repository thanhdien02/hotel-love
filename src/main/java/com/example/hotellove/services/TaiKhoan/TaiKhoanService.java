package com.example.hotellove.services.TaiKhoan;

import com.example.hotellove.dtos.taikhoan.TaiKhoanDto;
import com.example.hotellove.entities.TaiKhoan;
import org.springframework.stereotype.Service;

import java.security.Principal;

public interface TaiKhoanService {
    TaiKhoan getTaiKhoan(String id);
    TaiKhoan create (TaiKhoanDto dto, Principal principal);

    TaiKhoan update (String id, TaiKhoanDto dto);

    TaiKhoan delete (String id);
}
