package com.example.hotellove.services.Phong;


import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.entities.Phong;
import com.example.hotellove.repositories.PhongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PhongServiceImp implements PhongService {

    @Autowired
    private PhongRepository phongRepository;

    @Override
    public Phong create(PhongDto dto)
    {
        Phong phong = new Phong();

//        phong.setTenPhong(dto);

        return phong;
    }


}
