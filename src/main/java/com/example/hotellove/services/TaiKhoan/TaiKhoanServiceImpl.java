package com.example.hotellove.services.TaiKhoan;

import com.example.hotellove.dtos.taikhoan.TaiKhoanDto;
import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.exceptions.InvalidException;
import com.example.hotellove.exceptions.NotFoundException;
import com.example.hotellove.repositories.TaiKhoanRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.security.Principal;
import java.util.List;

@Slf4j
@Service
public class TaiKhoanServiceImpl implements TaiKhoanService{
    private final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanServiceImpl(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public TaiKhoan getTaiKhoan(String id) {
        return taiKhoanRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String
                        .format("Tài khoản có id %s không tồn tại", id)));
    }

    @Override
    public List<TaiKhoan> getAll() {
        return taiKhoanRepository.findAll();
    }


    @Override
    public TaiKhoan create(TaiKhoanDto dto, Principal principal) {
        if (ObjectUtils.isEmpty(dto.getName())) {
            throw new InvalidException("Tên tài khoản không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getEmail())) {
            throw new InvalidException("Email không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getPassword())) {
            throw new InvalidException("Mật khẩu không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getDienThoai())) {
            throw new InvalidException("Điện thoại không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getRoles())) {
            throw new InvalidException("vai trò tài khoản không được bỏ trống");
        }
        if (taiKhoanRepository.kiemTraEmail(dto.getEmail().trim())) {
            throw new InvalidException(String.format("Email %s đã tồn tại",
                    dto.getEmail()));
        }
        TaiKhoan taiKhoan = new TaiKhoan();
        taiKhoan.setName(dto.getName().trim());
        taiKhoan.setEmail(dto.getEmail().trim());
        taiKhoan.setPassword(dto.getPassword());
        taiKhoan.setDienThoai(dto.getDienThoai().trim());
        taiKhoan.setRoles(dto.getRoles());
        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public TaiKhoan update(String id, TaiKhoanDto dto) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        if (ObjectUtils.isEmpty(dto.getName())) {
            throw new InvalidException("Tên tài khoản không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getEmail())) {
            throw new InvalidException("Email không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getPassword())) {
            throw new InvalidException("Mật khẩu không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getDienThoai())) {
            throw new InvalidException("Điện thoại không được bỏ trống");
        }
        if (ObjectUtils.isEmpty(dto.getRoles())) {
            throw new InvalidException("vai trò tài khoản không được bỏ trống");
        }
        if (!taiKhoan.getEmail().equalsIgnoreCase(dto.getEmail().trim())
                && taiKhoanRepository.kiemTraEmail(dto.getEmail().trim())){
            throw new InvalidException(String.format("Email %s đã tồn tại",
                    dto.getEmail()));
        }
        taiKhoan.setName(dto.getName().trim());
        taiKhoan.setEmail(dto.getEmail().trim());
        taiKhoan.setPassword(dto.getPassword());
        taiKhoan.setDienThoai(dto.getDienThoai().trim());
        taiKhoan.setRoles(dto.getRoles());

        taiKhoanRepository.save(taiKhoan);
        return taiKhoan;
    }

    @Override
    public TaiKhoan delete(String id) {
        TaiKhoan taiKhoan = getTaiKhoan(id);
        taiKhoanRepository.delete(taiKhoan);
        return taiKhoan;
    }
}
