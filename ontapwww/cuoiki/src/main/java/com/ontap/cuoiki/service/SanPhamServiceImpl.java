package com.ontap.cuoiki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontap.cuoiki.dao.LoaiSPDao;
import com.ontap.cuoiki.dao.SanPhamDao;
import com.ontap.cuoiki.entity.LoaiSP;
import com.ontap.cuoiki.entity.SanPham;

@Service
public class SanPhamServiceImpl implements SanPhamService{

	private SanPhamDao sanPhamDao;
	private LoaiSPDao loaiSPDao;
	@Autowired
	public SanPhamServiceImpl(SanPhamDao sanPhamDao,LoaiSPDao loaiSPDao) {
		super();
		this.sanPhamDao = sanPhamDao;
		this.loaiSPDao = loaiSPDao;
	}

	@Override
	public SanPham findSP(int id) {
		Optional<SanPham> result=sanPhamDao.findById(id);
		SanPham theSanPham=null;
		if (result.isPresent()) {
			theSanPham=result.get();
		}else {
			throw new RuntimeException("Did not find product id - "+id);
		}
		return theSanPham;
	}

	@Override
	public void save(SanPham sanPham) {
		sanPhamDao.save(sanPham);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sanPhamDao.deleteById(id);;
	}

	@Override
	public List<SanPham> findTheoMaLoai(int id) {
		return  sanPhamDao.queryBy(id);
	}

}
