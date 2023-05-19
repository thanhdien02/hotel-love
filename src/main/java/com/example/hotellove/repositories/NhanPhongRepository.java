package com.example.hotellove.repositories;

import com.example.hotellove.entities.NhanPhong;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NhanPhongRepository extends MongoRepository<NhanPhong, String> {
}
