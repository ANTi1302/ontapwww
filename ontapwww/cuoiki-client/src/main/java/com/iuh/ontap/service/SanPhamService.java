package com.iuh.ontap.service;

import java.util.List;

import com.iuh.ontap.model.SanPham;


public interface SanPhamService {

	public SanPham findSP(int id);
	public void save(SanPham sanPham);
	public void delete(int id);
	public List<SanPham> findTheoMaLoai(int id);
}
