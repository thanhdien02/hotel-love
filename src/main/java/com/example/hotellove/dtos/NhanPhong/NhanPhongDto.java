package com.example.hotellove.dtos.NhanPhong;

import com.example.hotellove.entities.embedded.ThongTinDatPhong;
import com.example.hotellove.entities.embedded.ThongTinNhanPhong;
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
public class NhanPhongDto {

    private String tenNguoiNhan;

    private String soDienThoai;

    private Date ngayNhan;

    private List<ThongTinNhanPhong> thongTinNhanPhongs = new ArrayList<>();
}
