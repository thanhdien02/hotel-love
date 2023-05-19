package com.example.hotellove.entities.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinThanhToan {

    private String loaiPhong;

    private String tenPhong;

    private Double giaPhong;
}
