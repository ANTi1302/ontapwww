package com.iuh.ontap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iuh.ontap.model.LoaiSP;
import com.iuh.ontap.model.SanPham;
import com.iuh.ontap.service.LoaiSPService;
import com.iuh.ontap.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
	private int id;
	@Autowired
	private LoaiSPService loaiSPService;
	@Autowired
	private SanPhamService sanPhamService;

	@PostMapping("/saveSanPham")
	public String saveCustomer(Model theModel,@ModelAttribute("sanpham") @Valid SanPham theSanPham,BindingResult result) {
		if (result.hasErrors()) {
			return "sanpham-form";
		}else {
			LoaiSP loaiSP=loaiSPService.getLoaiSPbyId(id);
			theSanPham.setLoaiSP(loaiSP);
			sanPhamService.save(theSanPham);
			return "redirect:/sanpham/list";
		}
		
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("maSP") int theId, Model theModel) {
		SanPham theSanPham = sanPhamService.findSP(theId);
		theModel.addAttribute("sanpham", theSanPham);
		// set customer as a model attribute to pre-populate the form
		return "sanpham-form";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		SanPham theSanPham = new SanPham();
		theModel.addAttribute("sanpham", theSanPham);
		theModel.addAttribute("listLoaiSP",  loaiSPService.listLoaiSP());
		return "sanpham-form";
	}
	@GetMapping("/showSPbyID")
	public String showSPbyID(Model theModel,@RequestParam("maLoai") int maLoai) {
		List<SanPham> loaiSPs = sanPhamService.findTheoMaLoai(maLoai);
		// add the customers to the model
		theModel.addAttribute("sanpham", loaiSPs);
		id=maLoai;
		return "list-sanpham";
	}
	

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("maSP") int theId) {
		sanPhamService.delete(theId);
		return "redirect:/sanpham/list";
	}

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		// get customers from the service
		List<LoaiSP> loaiSPs = loaiSPService.listLoaiSP();
		// add the customers to the model
		theModel.addAttribute("sanpham", loaiSPs);
		return "list-loaisanpham";
	}

}
