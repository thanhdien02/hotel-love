package com.example.hotellove.repositories;

import com.example.hotellove.entities.Phong;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PhongRepository extends MongoRepository<Phong, String> {


    @Query(value = "{'tenPhong': ?0}", exists = true)
    boolean kiemTraTenPhong(String tenPhong);

    @Query(value = "{'tenPhong': ?0, 'giaPhong':  ?0}", exists = true)
    boolean kiemTraGiaPhong(String tenPhong, Double giaPhong);

    Phong findBytenPhong(String tenPhong);
}
