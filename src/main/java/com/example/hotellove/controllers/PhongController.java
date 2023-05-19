package com.example.hotellove.controllers;


import com.example.hotellove.dtos.Phong.PhongDto;
import com.example.hotellove.dtos.taikhoan.TaiKhoanDto;
import com.example.hotellove.entities.Phong;
import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.services.Phong.PhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/rest/phong")
public class PhongController {

    @Autowired
    private final PhongService phongService;

    public PhongController(PhongService phongService) {
        this.phongService = phongService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phong> getPhong(@PathVariable String id) {
        return new ResponseEntity<>(phongService.getPhong(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Phong> create(@Valid @RequestBody PhongDto dto) {
        return new ResponseEntity<>(phongService.create(dto), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Phong> update(@PathVariable String id, @Valid @RequestBody PhongDto dto) {
        return new ResponseEntity<>(phongService.update(id, dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Phong> delete(@PathVariable String id) {
        return new ResponseEntity<>(phongService.delete(id), HttpStatus.OK);
    }
}
