package com.example.hotellove;

import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.repositories.TaiKhoanRepository;
import com.example.hotellove.utils.EnumRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HotelLoveApplication implements CommandLineRunner {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public static void main(String[] args) {
        SpringApplication.run(HotelLoveApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        if(taiKhoanRepository.count()==0){
            TaiKhoan taiKhoan = new TaiKhoan("diennt","20110458@student.hcmute.edu.vn","123456789",
                    Arrays.asList(EnumRole.ROLE_ADMIN.name()));
            taiKhoanRepository.save(taiKhoan);
        }
    }
}
