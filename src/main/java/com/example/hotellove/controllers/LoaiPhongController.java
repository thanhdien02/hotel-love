package com.example.hotellove.controllers;

import com.example.hotellove.dtos.LoaiPhong.LoaiPhongDto;
import com.example.hotellove.entities.LoaiPhong;
import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.services.LoaiPhong.LoaiPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/rest/loai-phong")
public class LoaiPhongController {
    @Autowired
    private final LoaiPhongService loaiPhongService;

    public LoaiPhongController(LoaiPhongService loaiPhongService) {
        this.loaiPhongService = loaiPhongService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoaiPhong> getTaiKhoan(@PathVariable String id) {
        return new ResponseEntity<>(loaiPhongService.getLoaiPhong(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<LoaiPhong>> getAll() {
        return new ResponseEntity<>(loaiPhongService.getAll(), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<LoaiPhong> create(@Valid @RequestBody LoaiPhongDto dto) {
        return new ResponseEntity<>(loaiPhongService.create(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<LoaiPhong> update(@PathVariable String id, @Valid @RequestBody LoaiPhongDto dto) {
        return new ResponseEntity<>(loaiPhongService.update(dto, id), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<LoaiPhong> delete(@PathVariable String id) {
        return new ResponseEntity<>(loaiPhongService.delete(id), HttpStatus.OK);
    }
}
