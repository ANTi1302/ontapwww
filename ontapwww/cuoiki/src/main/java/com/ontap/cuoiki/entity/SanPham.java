package com.ontap.cuoiki.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sanpham")
public class SanPham implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_sp")
	private int maSP;
	@Column(name = "ten_sp", columnDefinition = "nvarchar(500)")
	private String tenSP;
	@Column(name = "don_gia")
	private double donGia;
	@ManyToOne
	@JoinColumn(name = "loai_sp")
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
	
	public SanPham( String tenSP, double donGia, LoaiSP loaiSP) {
		super();
	
		this.tenSP = tenSP;
		this.donGia = donGia;
		this.loaiSP = loaiSP;
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
