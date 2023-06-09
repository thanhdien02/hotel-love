package com.example.hotellove.entities;

import com.example.hotellove.entities.embedded.ThongTinThanhToan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "thanh-toan")
public class ThanhToan {
    @Id
    private String id;

    private String tenNguoiThanhToan;

    private String soDienThoai;

    private Date ngayThanhToan;

    private Double tienThue;

    private List<ThongTinThanhToan> thongTinThanhToans;

}
