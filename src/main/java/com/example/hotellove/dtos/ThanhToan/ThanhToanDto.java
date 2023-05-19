package com.example.hotellove.dtos.ThanhToan;

import com.example.hotellove.entities.embedded.ThongTinThanhToan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThanhToanDto {

    private String tenNguoiThanhToan;

    private String soDienThoai;

    private Date ngayThanhToan;

    private Double tienThue;

    private List<ThongTinThanhToan> thongTinThanhToans;
}
