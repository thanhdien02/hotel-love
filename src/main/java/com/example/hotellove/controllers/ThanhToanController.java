package com.example.hotellove.controllers;


import com.example.hotellove.dtos.ThanhToan.ThanhToanDto;
import com.example.hotellove.entities.ThanhToan;
import com.example.hotellove.services.ThanhToan.ThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/thanh-toan")
public class ThanhToanController {
    @Autowired
    private final ThanhToanService thanhToanService;

    public ThanhToanController(ThanhToanService thanhToanService) {
        this.thanhToanService = thanhToanService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ThanhToan> getPhong(@PathVariable String id) {
        return new ResponseEntity<>(thanhToanService.getThanhToan(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ThanhToan> create(@Valid @RequestBody ThanhToanDto dto) {
        return new ResponseEntity<>(thanhToanService.create(dto), HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ThanhToan> update(@PathVariable String id, @Valid @RequestBody ThanhToanDto dto) {
        return new ResponseEntity<>(thanhToanService.update(id, dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ThanhToan> delete(@PathVariable String id) {
        return new ResponseEntity<>(thanhToanService.delete(id), HttpStatus.OK);
    }
}
