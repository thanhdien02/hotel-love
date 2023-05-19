package com.example.hotellove.controllers;

import com.example.hotellove.dtos.DatPhong.DatPhongDto;
import com.example.hotellove.entities.DatPhong;
import com.example.hotellove.services.DatPhong.DatPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/dat-phong")
public class DatPhongController {

    @Autowired
    private final DatPhongService datPhongService;

    public DatPhongController(DatPhongService datPhongService) {
        this.datPhongService = datPhongService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DatPhong> getPhong(@PathVariable String id) {
        return new ResponseEntity<>(datPhongService.getDatPhong(id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<DatPhong> create(@Valid @RequestBody DatPhongDto dto) {
        return new ResponseEntity<>(datPhongService.create(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<DatPhong> update(@PathVariable String id, @Valid @RequestBody DatPhongDto dto) {
        return new ResponseEntity<>(datPhongService.update(id, dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<DatPhong> delete(@PathVariable String id) {
        return new ResponseEntity<>(datPhongService.delete(id), HttpStatus.OK);
    }
}
