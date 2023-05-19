package com.example.hotellove.services.Phong;


import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.dtos.taikhoan.TaiKhoanDto;
import com.example.hotellove.entities.Phong;
import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.exceptions.InvalidException;
import com.example.hotellove.exceptions.NotFoundException;
import com.example.hotellove.repositories.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service

public class PhongServiceImp implements PhongService {

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public Phong create(PhongDto dto)
    {
        if (ObjectUtils.isEmpty(dto.getTenPhong())) {
            throw new InvalidException("Tên Phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getSoGiuong())) {
            throw new InvalidException("Số giường không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getGiaPhong())) {
            throw new InvalidException("Giá phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getLoaiPhong())) {
            throw new InvalidException("Loại phòng không được bỏ trống");
        }
        if (phongRepository.kiemTraTenPhong(dto.getTenPhong().trim())) {
            throw new InvalidException(String.format("Email %s đã tồn tại",
                    dto.getTenPhong()));
        }
        Phong phong = new Phong();
        phong.setTenPhong(dto.getTenPhong().trim());
        phong.setGiaPhong(dto.getGiaPhong());
        phong.setLoaiPhong(dto.getLoaiPhong());
        phong.setSoGiuong(dto.getSoGiuong());
        phongRepository.save(phong);
        return phong;
    }

    @Override
    public Phong getPhong(String id)
    {
        return phongRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Phòng có id %s không tồn tại", id)));

    }

    @Override
    public Phong update(String id, PhongDto dto) {
        Phong phong = getPhong(id);
        if (ObjectUtils.isEmpty(dto.getTenPhong())) {
            throw new InvalidException("Tên Phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getSoGiuong())) {
            throw new InvalidException("Số giường không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getGiaPhong())) {
            throw new InvalidException("Giá phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getLoaiPhong())) {
            throw new InvalidException("Loại phòng không được bỏ trống");
        }

        phong.setTenPhong(dto.getTenPhong().trim());
        phong.setLoaiPhong(dto.getLoaiPhong().trim());
        phong.setSoGiuong(dto.getSoGiuong());
        phong.setGiaPhong(dto.getGiaPhong());

        phongRepository.save(phong);
        return phong;
    }

    @Override
    public Phong delete(String id) {
        Phong phong = getPhong(id);
        phongRepository.delete(phong);
        return phong;
    }

}
