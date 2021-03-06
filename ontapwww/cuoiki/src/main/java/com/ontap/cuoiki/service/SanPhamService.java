package com.ontap.cuoiki.service;

import java.util.List;

import com.ontap.cuoiki.entity.SanPham;

public interface SanPhamService {

	public SanPham findSP(int id);
	public void save(SanPham sanPham);
	public void delete(int id);
	public List<SanPham> findTheoMaLoai(int id);
}
