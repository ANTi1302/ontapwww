package com.iuh.ontap.service;

import java.util.List;
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
public class LoaiSPServiceImpl implements LoaiSPService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = (Logger) java.util.logging.Logger.getLogger(getClass().getName());
	@Autowired
	public LoaiSPServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Logger property: crm.rest.url= " + crmRestUrl);

	}

	@Override
	public List<LoaiSP> listLoaiSP() {
		ResponseEntity<List<LoaiSP>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<LoaiSP>>() {
				});
		List<LoaiSP> loaiSPs = responseEntity.getBody();
		return loaiSPs;
	}

	@Override
	public LoaiSP getLoaiSPbyId(int id) {
		// TODO Auto-generated method stub
		LoaiSP loaiSP = restTemplate.getForObject(crmRestUrl + "/" + id, LoaiSP.class);
		return loaiSP;
	}

	@Override
	public void save(LoaiSP loai) {
		int id=loai.getMaLoai();
		if (id==0) {
			restTemplate.postForEntity(crmRestUrl, id, String.class);
		}else {
			restTemplate.put(crmRestUrl, id);
		}		
	}

}
