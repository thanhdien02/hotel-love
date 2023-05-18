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
@Document(collection = "loai-phong")
public class LoaiPhong {

    @Id
    private String id;

    private String tenLoaiPhong;

}
