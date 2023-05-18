package com.example.hotellove.repositories;

import com.example.hotellove.entities.LoaiPhong;
import com.example.hotellove.entities.TaiKhoan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface LoaiPhongRepository extends MongoRepository<LoaiPhong, String> {

    @Query(value = "{'tenLoaiPhong': ?0}", exists = true)
    boolean kiemTraTenLoaiPhong(String tenLoaiPhong);
}
