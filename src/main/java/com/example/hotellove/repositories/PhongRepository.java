package com.example.hotellove.repositories;

import com.example.hotellove.entities.Phong;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhongRepository extends MongoRepository<Phong, String> {


}
