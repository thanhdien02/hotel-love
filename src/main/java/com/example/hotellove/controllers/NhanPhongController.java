package com.example.hotellove.controllers;

import com.example.hotellove.dtos.DatPhong.DatPhongDto;
import com.example.hotellove.dtos.NhanPhong.NhanPhongDto;
import com.example.hotellove.entities.NhanPhong;
import com.example.hotellove.entities.TaiKhoan;
import com.example.hotellove.services.NhanPhong.NhanPhongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/nhan-phong")
public class NhanPhongController {
    @Autowired
    private final NhanPhongService nhanPhongService;

    public NhanPhongController(NhanPhongService nhanPhongService) {
        this.nhanPhongService = nhanPhongService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<NhanPhong> getNhanPhong(@PathVariable String id) {
        return new ResponseEntity<>(nhanPhongService.getNhanPhong(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<NhanPhong>> getAll() {
        return new ResponseEntity<>(nhanPhongService.getAll(), HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<NhanPhong> create(@Valid @RequestBody NhanPhongDto dto) {
        return new ResponseEntity<>(nhanPhongService.create(dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<NhanPhong> update(@PathVariable String id, @Valid @RequestBody NhanPhongDto dto) {
        return new ResponseEntity<>(nhanPhongService.update(id, dto), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<NhanPhong> delete(@PathVariable String id) {
        return new ResponseEntity<>(nhanPhongService.delete(id), HttpStatus.OK);
    }
}
