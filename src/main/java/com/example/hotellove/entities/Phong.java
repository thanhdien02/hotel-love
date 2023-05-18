package com.example.hotellove.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "phong")
public class Phong {

    @Id
    private String id;

    // Ten phong khong duoc trung nhau
    private String tenPhong;

    private int soGiuong;

    private double giaPhong;

    private String loaiPhong;

}
