package com.ontap.cuoiki.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "loaisanpham")
public class LoaiSP implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ma_loai")
	private int maLoai;
	@Column(name = "ten_loai", columnDefinition = "nvarchar(500)")
	private String tenLoaiSP;
//	 @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//	 @JoinColumn(name="loai_sp")
//	private List<SanPham> sanPhams;


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
