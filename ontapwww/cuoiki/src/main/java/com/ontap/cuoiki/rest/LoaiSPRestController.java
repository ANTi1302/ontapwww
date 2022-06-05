package com.ontap.cuoiki.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontap.cuoiki.entity.LoaiSP;
import com.ontap.cuoiki.entity.SanPham;
import com.ontap.cuoiki.service.LoaiSPService;
import com.ontap.cuoiki.service.SanPhamService;

@RestController
@RequestMapping("/api")
public class LoaiSPRestController {

	private LoaiSPService loaiSPService;
	private SanPhamService sanPhamService;

	@Autowired
	public LoaiSPRestController(LoaiSPService loaiSPService,SanPhamService sanPhamService) {
		super();
		this.loaiSPService = loaiSPService;
		this.sanPhamService = sanPhamService;
	}
	
	@GetMapping("/sanpham")
	public List<LoaiSP> findAll() {
		return loaiSPService.listLoaiSP();
	}
	
	@PostMapping("/sanpham/{maLoai}")
	public List<SanPham> findByMaLoai(@PathVariable int maLoai) {
		List<SanPham> theSanPham=sanPhamService.findTheoMaLoai(maLoai);
		if (theSanPham==null) {
			throw new RuntimeException("Product id not found - "+maLoai);
		}
		return theSanPham;
	}
	@GetMapping("/sanpham/{maLoai}")
	public LoaiSP findLoai(@PathVariable int maLoai) {
		LoaiSP theLoaiSP=loaiSPService.getLoaiSPbyId(maLoai);
		if (theLoaiSP==null) {
			throw new RuntimeException("Product id not found - "+maLoai);
		}
		return theLoaiSP;
	}
	@PostMapping("/sanpham")
	public SanPham addSanPham(@RequestBody SanPham theSanPham) {
		theSanPham.setMaSP(0);
		sanPhamService.save(theSanPham);
		return theSanPham;
	}
	
	@PutMapping("/sanpham")
	public SanPham updateEmployee(@RequestBody SanPham theSanPham) {
		sanPhamService.save(theSanPham);
		return theSanPham;
	}
	
	@DeleteMapping("/sanpham/{sanphamId}")
	public String deleteEmployee(@PathVariable int sanphamId) {
		SanPham tempSanPham=sanPhamService.findSP(sanphamId);
		if (tempSanPham==null) {
			throw new RuntimeException("Employee id not found - "+ sanphamId);
		}
		sanPhamService.delete(sanphamId);
		return "Delete employee id -"+ sanphamId;
	}
	@GetMapping("/sanpham/getsanpham/{id}")
	public SanPham getLoaiSanPhamById(@PathVariable int id) {
		return sanPhamService.findSP(id);
	}
}
