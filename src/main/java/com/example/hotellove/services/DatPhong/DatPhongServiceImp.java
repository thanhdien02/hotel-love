package com.example.hotellove.services.DatPhong;

import com.example.hotellove.dtos.DatPhong.DatPhongDto;
import com.example.hotellove.entities.DatPhong;
import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.exceptions.InvalidException;
import com.example.hotellove.exceptions.NotFoundException;
import com.example.hotellove.repositories.DatPhongRepository;
import com.example.hotellove.repositories.LoaiPhongRepository;
import com.example.hotellove.repositories.PhongRepository;
import com.example.hotellove.services.Phong.PhongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Slf4j
@Service
public class DatPhongServiceImp implements DatPhongService{

    private final DatPhongRepository datPhongRepository;

    private final LoaiPhongRepository loaiPhongRepository;

    private final PhongRepository phongRepository;

    private final PhongService phongService;

    public DatPhongServiceImp(DatPhongRepository datPhongRepository, LoaiPhongRepository loaiPhongRepository, PhongRepository phongRepository, PhongService phongService) {
        this.datPhongRepository = datPhongRepository;
        this.loaiPhongRepository = loaiPhongRepository;
        this.phongRepository = phongRepository;
        this.phongService = phongService;
    }


    @Override
    public DatPhong getDatPhong(String id)
    {
        return datPhongRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Đặt Phòng có id %s không tồn tại", id)));
    }

    @Override
    public List<DatPhong> getAll() {
        return datPhongRepository.findAll();
    }
    @Override
    public DatPhong create(DatPhongDto dto)
    {
        if (ObjectUtils.isEmpty(dto.getEmailNguoiDat())) {
            throw new InvalidException("Email người đặt phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNgayDat())) {
            throw new InvalidException("Ngày đặt phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinDatPhongs())) {
            throw new InvalidException("Thông tin đặt phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTenNguoiDat())) {
            throw new InvalidException("Tên người đặt phòng không được bỏ trống");
        }
        // kiểm tra trong thông tin đặt phòng loại phòng, tên phòng, giá phòng có
        // tồn tại trong các bản tường ứng của nó hay không

        // Lấy số lượng phòng dặt
        int soluongdat = dto.getThongTinDatPhongs().size();

        for(int i = 0; i < soluongdat; i++)
        {
            if (!phongRepository.kiemTraTenPhong(dto.getThongTinDatPhongs().get(i).getTenPhong().trim())) {
                throw new InvalidException(String.format("Tên Phòng %s không tồn tại trong danh sách phòng",
                        dto.getThongTinDatPhongs().get(i).getTenPhong()));
            }
            if (!loaiPhongRepository.kiemTraTenLoaiPhong(dto.getThongTinDatPhongs().get(i).getLoaiPhong().trim())) {
                throw new InvalidException(String.format("Tên loại phòng %s không tồn tại trong danh sách loại phòng",
                        dto.getThongTinDatPhongs().get(i).getLoaiPhong()));
            }
            // Kiem tra gia phong co hop le hay khong.
            if (!phongService.kiemTraTenPhongGiaTienVaLoaiPhong(dto.getThongTinDatPhongs().get(i).getTenPhong().trim(), dto.getThongTinDatPhongs().get(i).getGiaPhong(), dto.getThongTinDatPhongs().get(i).getLoaiPhong().trim())) {
                throw new InvalidException(String.format("Phòng %s với giá tiền và loại phòng không hợp lệ",
                        dto.getThongTinDatPhongs().get(i).getTenPhong()));
            }
        }

        DatPhong datPhong = new DatPhong();
        datPhong.setEmailNguoiDat(dto.getEmailNguoiDat());
        datPhong.setTenNguoiDat(dto.getTenNguoiDat());
        datPhong.setNgayDat(dto.getNgayDat());
        datPhong.setThongTinDatPhongs(dto.getThongTinDatPhongs());
        datPhongRepository.save(datPhong);
        return datPhong;
    }

    @Override
    public DatPhong update(String id, DatPhongDto dto)
    {
        if (ObjectUtils.isEmpty(dto.getEmailNguoiDat())) {
        throw new InvalidException("Email người đặt phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getNgayDat())) {
            throw new InvalidException("Ngày đặt phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getThongTinDatPhongs())) {
            throw new InvalidException("Thông tin đặt phòng không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getTenNguoiDat())) {
            throw new InvalidException("Tên người đặt phòng không được bỏ trống");
        }

        DatPhong datPhong = getDatPhong(id);
        datPhong.setEmailNguoiDat(dto.getEmailNguoiDat());
        datPhong.setTenNguoiDat(dto.getTenNguoiDat());
        datPhong.setNgayDat(dto.getNgayDat());
        datPhong.setThongTinDatPhongs(dto.getThongTinDatPhongs());

        datPhongRepository.save(datPhong);
        return datPhong;
    }

    @Override
    public DatPhong delete(String id) {
        DatPhong datPhong = getDatPhong(id);
        datPhongRepository.delete(datPhong);
        return datPhong;
    }

}
