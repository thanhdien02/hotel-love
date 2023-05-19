package com.example.hotellove.entities;

import com.example.hotellove.entities.embedded.ThongTinDatPhong;
import com.example.hotellove.entities.embedded.ThongTinNhanPhong;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "nhan-phong")
public class NhanPhong {

    @Id
    private String id;

    private String tenNguoiNhan;

    private String soDienThoai;

    private Date ngayNhan;

    private List<ThongTinNhanPhong> thongTinNhanPhongs = new ArrayList<>();

}
