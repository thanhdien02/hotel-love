package com.example.hotellove.dtos.DatPhong;

import com.example.hotellove.entities.embedded.ThongTinDatPhong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatPhongDto {

    private String tenNguoiDat;

    private String emailNguoiDat;

    private Date ngayDat;

    private List<ThongTinDatPhong> thongTinDatPhongs = new ArrayList<>();

    private boolean tinhTrang = true;
}
