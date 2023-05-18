package com.example.hotellove.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tai-khoan")
public class TaiKhoan {
    @Id
    private String id;

    private String name;

    // email không được trùng nhau
    private String email;

    @JsonIgnore
    private String password;

    private String dienThoai;

    private List<String> roles = new ArrayList<>();

    private boolean trangThai = true;

    public TaiKhoan(String name, String email, String password, List<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
}
