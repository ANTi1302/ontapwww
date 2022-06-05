package com.ontap.cuoiki.service;

import java.util.List;

import com.ontap.cuoiki.entity.LoaiSP;
import com.ontap.cuoiki.entity.SanPham;

public interface LoaiSPService {

	public List<LoaiSP> listLoaiSP();
	public LoaiSP getLoaiSPbyId(int id);
	public void save(LoaiSP loai);
}
