package com.iuh.ontap.service;

import java.util.List;

import com.iuh.ontap.model.LoaiSP;
import com.iuh.ontap.model.SanPham;


public interface LoaiSPService {

	public List<LoaiSP> listLoaiSP();
	public LoaiSP getLoaiSPbyId(int id);
	public void save(LoaiSP loai);
}
