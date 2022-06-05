package com.iuh.ontap.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

public class SanPham {
	private int maSP;
	@NotNull(message = "is required")
	@Size(min=1, message = "is required")
	private String tenSP;
	@NotNull(message = "is required")
	@Range(min=1, message = ">0")
	private double donGia;
	private LoaiSP loaiSP;
	public SanPham() {
		super();
	}
	public SanPham(int maSP, String tenSP, double donGia) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
	}
	
	public SanPham( String tenSP, double donGia) {
		super();
	
		this.tenSP = tenSP;
		this.donGia = donGia;
	}
	public LoaiSP getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(LoaiSP loaiSP) {
		this.loaiSP = loaiSP;
	}
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", donGia=" + donGia + "]";
	}
	
	
	

}
