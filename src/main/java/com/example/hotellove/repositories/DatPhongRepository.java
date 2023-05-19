package com.example.hotellove.repositories;

import com.example.hotellove.entities.DatPhong;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DatPhongRepository extends MongoRepository<DatPhong, String> {

}
