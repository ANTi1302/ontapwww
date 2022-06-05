package com.ontap.cuoiki.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ontap.cuoiki.entity.SanPham;

public interface SanPhamDao extends JpaRepository<SanPham, Integer>{
	 @Query(value = "SELECT * FROM SanPham pr WHERE pr.loai_sp = :maLoai",
	            nativeQuery = true)
	    List<SanPham> queryBy(@Param("maLoai") int maLoai);
}
