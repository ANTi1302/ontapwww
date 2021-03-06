package com.iuh.ontap.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iuh.ontap.model.LoaiSP;
import com.iuh.ontap.model.SanPham;


@Service
public class SanPhamServiceImpl implements SanPhamService{

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = (Logger) java.util.logging.Logger.getLogger(getClass().getName());
	@Autowired
	public SanPhamServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Logger property: crm.rest.url= " + crmRestUrl);

	}

	@Override
	public SanPham findSP(int id) {
		SanPham theSanPham = restTemplate.getForObject(crmRestUrl+ "/getsanpham/" + id, SanPham.class);
		return theSanPham;
	}

	

	@Override
	public void save(SanPham sanPham) {
		int id=sanPham.getMaSP();
		if (id==0) {
			restTemplate.postForEntity(crmRestUrl, sanPham, String.class);
		}else {
			restTemplate.put(crmRestUrl, sanPham);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		restTemplate.delete(crmRestUrl+"/"+id);
	}

	@Override
	public List<SanPham> findTheoMaLoai(int id) {
		ResponseEntity<List<SanPham>> responseEntity = restTemplate.exchange(crmRestUrl+"/" + id, HttpMethod.POST, null,
				new ParameterizedTypeReference<List<SanPham>>() {
				});
		List<SanPham> sanPhams = responseEntity.getBody();
		
		return sanPhams;
	}

}
