package com.ontap.cuoiki.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ontap.cuoiki.dao.LoaiSPDao;
import com.ontap.cuoiki.entity.LoaiSP;
import com.ontap.cuoiki.entity.SanPham;

@Service
public class LoaiSPServiceImpl implements LoaiSPService{

	private LoaiSPDao loaiSPDao;
	@Autowired
	public LoaiSPServiceImpl(LoaiSPDao loaiSPDao) {
		super();
		this.loaiSPDao = loaiSPDao;
	}

	@Override
	public List<LoaiSP> listLoaiSP() {
		// TODO Auto-generated method stub
		return loaiSPDao.findAll();
	}

	@Override
	public LoaiSP getLoaiSPbyId(int id) {
		// TODO Auto-generated method stub
		Optional<LoaiSP> result=loaiSPDao.findById(id);
		LoaiSP theLoaiSP=null;
		if (result.isPresent()) {
			theLoaiSP=result.get();
		}else {
			throw new RuntimeException("Did not find product id - "+id);
		}
		return theLoaiSP;
	}

	@Override
	public void save(LoaiSP loai) {
		// TODO Auto-generated method stub
		loaiSPDao.save(loai);
	}

}
