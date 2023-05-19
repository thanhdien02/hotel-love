package com.example.hotellove.services.LoaiPhong;


import com.example.hotellove.dtos.LoaiPhong.LoaiPhongDto;
import com.example.hotellove.entities.LoaiPhong;
import com.example.hotellove.exceptions.InvalidException;
import com.example.hotellove.exceptions.NotFoundException;
import com.example.hotellove.repositories.LoaiPhongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
@Slf4j
@Service
public class LoaiPhongServiceImp implements LoaiPhongService{
    private final LoaiPhongRepository  loaiPhongRepository;

    public LoaiPhongServiceImp(LoaiPhongRepository loaiPhongRepository) {
        this.loaiPhongRepository = loaiPhongRepository;
    }

    @Override
    public LoaiPhong create(LoaiPhongDto dto)
    {
        if (ObjectUtils.isEmpty(dto.getTenLoaiPhong())) {
            throw new InvalidException("Tên loại phòng không được bỏ trống");
        }

        if (loaiPhongRepository.kiemTraTenLoaiPhong(dto.getTenLoaiPhong().trim())) {
            throw new InvalidException(String.format("Tên loại phòng %s đã tồn tại",
                    dto.getTenLoaiPhong()));
        }
        LoaiPhong loaiPhong = new LoaiPhong();
        loaiPhong.setTenLoaiPhong(dto.getTenLoaiPhong());
        loaiPhongRepository.save(loaiPhong);
        return loaiPhong;
    }

    @Override
    public LoaiPhong getLoaiPhong(String id)
    {
        return loaiPhongRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Loại Phòng có id %s không tồn tại", id)));
    }

    @Override
    public LoaiPhong update(LoaiPhongDto dto, String id)
    {

        LoaiPhong loaiPhong = getLoaiPhong(id);
        if (ObjectUtils.isEmpty(dto.getTenLoaiPhong())) {
            throw new InvalidException("Tên phòng không được bỏ trống");
        }
        if (!loaiPhong.getTenLoaiPhong().equalsIgnoreCase(dto.getTenLoaiPhong().trim())
                && loaiPhongRepository.kiemTraTenLoaiPhong(dto.getTenLoaiPhong().trim())){
            throw new InvalidException(String.format("Tên phòng %s đã tồn tại",
                    dto.getTenLoaiPhong()));
        }
        loaiPhong.setTenLoaiPhong(dto.getTenLoaiPhong().trim());

        loaiPhongRepository.save(loaiPhong);
        return loaiPhong;
    }

    @Override
    public LoaiPhong delete(String id) {
        LoaiPhong loaiPhong = getLoaiPhong(id);
        loaiPhongRepository.delete(loaiPhong);
        return loaiPhong;
    }

}
