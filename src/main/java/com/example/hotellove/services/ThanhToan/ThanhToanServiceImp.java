package com.example.hotellove.services.ThanhToan;


import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.dtos.ThanhToan.ThanhToanDto;
import com.example.hotellove.entities.Phong;
import com.example.hotellove.entities.ThanhToan;
import com.example.hotellove.exceptions.InvalidException;
import com.example.hotellove.exceptions.NotFoundException;
import com.example.hotellove.repositories.PhongRepository;
import com.example.hotellove.repositories.ThanhToanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class ThanhToanServiceImp implements ThanhToanService{

    @Autowired
    private ThanhToanRepository thanhToanRepository;

    @Override
    public ThanhToan getThanhToan(String id)
    {
        return thanhToanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Thanh toán có id %s không tồn tại", id)));

    }

    @Override
    public ThanhToan create(ThanhToanDto dto)
    {
        if (ObjectUtils.isEmpty(dto.getTenNguoiThanhToan())) {
            throw new InvalidException("Tên người thanh toán không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNgayThanhToan())) {
            throw new InvalidException("Ngày thanh toán không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinThanhToans())) {
            throw new InvalidException("Thông tin thanh toán không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTienThue())) {
            throw new InvalidException("Tiền thuê không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getSoDienThoai())) {
            throw new InvalidException("Số điện thoại người thanh toán không được bỏ trống");
        }

        ThanhToan thanhToan = new ThanhToan();
        thanhToan.setTenNguoiThanhToan(dto.getTenNguoiThanhToan().trim());
        thanhToan.setNgayThanhToan(dto.getNgayThanhToan());
        thanhToan.setTienThue(dto.getTienThue());
        thanhToan.setSoDienThoai(dto.getSoDienThoai());
        thanhToan.setThongTinThanhToans(dto.getThongTinThanhToans());
        thanhToanRepository.save(thanhToan);
        return thanhToan;
    }

    @Override
    public ThanhToan update(String id, ThanhToanDto dto) {
        ThanhToan thanhToan = getThanhToan(id);
        if (ObjectUtils.isEmpty(dto.getTenNguoiThanhToan())) {
            throw new InvalidException("Tên người thanh toán không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNgayThanhToan())) {
            throw new InvalidException("Ngày thanh toán không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinThanhToans())) {
            throw new InvalidException("Thông tin thanh toán không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTienThue())) {
            throw new InvalidException("Tiền thuê không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getSoDienThoai())) {
            throw new InvalidException("Số điện thoại người thanh toán không được bỏ trống");
        }

        thanhToan.setTenNguoiThanhToan(dto.getTenNguoiThanhToan().trim());
        thanhToan.setNgayThanhToan(dto.getNgayThanhToan());
        thanhToan.setTienThue(dto.getTienThue());
        thanhToan.setSoDienThoai(dto.getSoDienThoai());
        thanhToan.setThongTinThanhToans(dto.getThongTinThanhToans());
        thanhToanRepository.save(thanhToan);
        return thanhToan;
    }

    @Override
    public ThanhToan delete(String id) {
        ThanhToan thanhToan = getThanhToan(id);
        thanhToanRepository.delete(thanhToan);
        return thanhToan;
    }

}
