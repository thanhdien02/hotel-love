package com.example.hotellove.repositories;

import com.example.hotellove.entities.ThanhToan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ThanhToanRepository extends MongoRepository<ThanhToan, String> {

}
