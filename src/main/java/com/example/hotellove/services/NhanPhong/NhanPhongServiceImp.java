package com.example.hotellove.services.NhanPhong;

import com.example.hotellove.dtos.NhanPhong.NhanPhongDto;
import com.example.hotellove.entities.NhanPhong;
import com.example.hotellove.exceptions.InvalidException;
import com.example.hotellove.exceptions.NotFoundException;
import com.example.hotellove.repositories.LoaiPhongRepository;
import com.example.hotellove.repositories.NhanPhongRepository;
import com.example.hotellove.repositories.PhongRepository;
import com.example.hotellove.services.Phong.PhongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
public class NhanPhongServiceImp implements NhanPhongService{


    private final NhanPhongRepository nhanPhongRepository;

    private final LoaiPhongRepository loaiPhongRepository;

    private final PhongRepository phongRepository;

    private final PhongService phongService;

    public NhanPhongServiceImp(NhanPhongRepository nhanPhongRepository, LoaiPhongRepository loaiPhongRepository, PhongRepository phongRepository, PhongService phongService) {
        this.nhanPhongRepository = nhanPhongRepository;
        this.loaiPhongRepository = loaiPhongRepository;
        this.phongRepository = phongRepository;
        this.phongService = phongService;
    }

    @Override
    public NhanPhong getNhanPhong(String id)
    {
        return nhanPhongRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Nhận phòng có id %s không tồn tại", id)));

    }
    @Override
    public NhanPhong create(NhanPhongDto dto)
    {
        if (ObjectUtils.isEmpty(dto.getTenNguoiNhan())) {
            throw new InvalidException("Tên người nhận phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNgayNhan())) {
            throw new InvalidException("Ngày nhận phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinNhanPhongs())) {
            throw new InvalidException("Thông tin nhận phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getSoDienThoai())) {
            throw new InvalidException("Số điện thoại người nhận phòng không được bỏ trống");
        }
        // Kiểm tra cái loại phòng đã tồn tại hay chưa. Thông qua tên phòng.

        int soluongdat = dto.getThongTinNhanPhongs().size();

        for(int i = 0; i < soluongdat; i++)
        {
            if (!phongRepository.kiemTraTenPhong(dto.getThongTinNhanPhongs().get(i).getTenPhong().trim())) {
                throw new InvalidException(String.format("Tên Phòng %s không tồn tại trong danh sách phòng",
                        dto.getThongTinNhanPhongs().get(i).getTenPhong()));
            }
            if (!loaiPhongRepository.kiemTraTenLoaiPhong(dto.getThongTinNhanPhongs().get(i).getLoaiPhong().trim())) {
                throw new InvalidException(String.format("Tên loại phòng %s không tồn tại trong danh sách loại phòng",
                        dto.getThongTinNhanPhongs().get(i).getLoaiPhong()));
            }
            // Kiem tra gia phong co hop le hay khong.
            if (!phongService.kiemTraTenPhongGiaTienVaLoaiPhong(dto.getThongTinNhanPhongs().get(i).getTenPhong().trim(),
                    dto.getThongTinNhanPhongs().get(i).getGiaPhong(), dto.getThongTinNhanPhongs().get(i).getLoaiPhong().trim())) {
                throw new InvalidException(String.format("Phòng %s với giá tiền và loại phòng không hợp lệ",
                        dto.getThongTinNhanPhongs().get(i).getTenPhong()));
            }
        }

        NhanPhong nhanPhong = new NhanPhong();
        nhanPhong.setTenNguoiNhan(dto.getTenNguoiNhan().trim());
        nhanPhong.setNgayNhan(dto.getNgayNhan());
        nhanPhong.setThongTinNhanPhongs(dto.getThongTinNhanPhongs());
        nhanPhong.setSoDienThoai(dto.getSoDienThoai());
        nhanPhongRepository.save(nhanPhong);
        return nhanPhong;
    }

    @Override
    public NhanPhong update(String id, NhanPhongDto dto) {
        NhanPhong nhanPhong = getNhanPhong(id);
        if (ObjectUtils.isEmpty(dto.getTenNguoiNhan())) {
            throw new InvalidException("Tên người nhận phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNgayNhan())) {
            throw new InvalidException("Ngày nhận phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinNhanPhongs())) {
            throw new InvalidException("Thông tin nhận phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getSoDienThoai())) {
            throw new InvalidException("Số điện thoại người nhận phòng không được bỏ trống");
        }

        nhanPhong.setTenNguoiNhan(dto.getTenNguoiNhan().trim());
        nhanPhong.setNgayNhan(dto.getNgayNhan());
        nhanPhong.setThongTinNhanPhongs(dto.getThongTinNhanPhongs());
        nhanPhong.setSoDienThoai(dto.getSoDienThoai());
        nhanPhongRepository.save(nhanPhong);
        return nhanPhong;
    }
    @Override
    public NhanPhong delete(String id) {
        NhanPhong nhanPhong = getNhanPhong(id);
        nhanPhongRepository.delete(nhanPhong);
        return nhanPhong;
    }
}
