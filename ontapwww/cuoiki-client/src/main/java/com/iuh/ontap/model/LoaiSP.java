package com.iuh.ontap.model;

import java.io.Serializable;
import java.util.List;


public class LoaiSP{
	private int maLoai;
	private String tenLoaiSP;

	public LoaiSP(int maLoai, String tenLoaiSP, List<SanPham> sanPhams) {
		super();
		this.maLoai = maLoai;
		this.tenLoaiSP = tenLoaiSP;
//		this.sanPhams = sanPhams;
	}

//	public List<SanPham> getSanPhams() {
//		return sanPhams;
//	}
//
//	public void setSanPhams(List<SanPham> sanPhams) {
//		this.sanPhams = sanPhams;
//	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

	public LoaiSP(int maLoai, String tenLoaiSP) {
		super();
		this.maLoai = maLoai;
		this.tenLoaiSP = tenLoaiSP;
	}

	public LoaiSP() {
		super();
	}

	@Override
	public String toString() {
		return "LoaiSP [maLoai=" + maLoai + ", tenLoaiSP=" + tenLoaiSP + "]";
	}

	

}
