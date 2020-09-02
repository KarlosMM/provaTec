package com.npaw.responseservice.controller;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.npaw.responseservice.bean.ResponseBean;
import com.npaw.responseservice.entities.TargetDevice;
import com.npaw.responseservice.repositories.AccountRepository;

@RestController
public class ServiceController {

	@Autowired
	private AccountRepository accountRepository;

	@GetMapping(value="/getData", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseBean getData(@RequestParam(required = false) String accountCode,
			@RequestParam(required = false) String targetDevice, @RequestParam(required = false) String pluginVersion) throws Exception {
		final ResponseBean responseBean = new ResponseBean();

		try {

			final TargetDevice targetDeviceEntity = accountRepository.findByAccountCode(accountCode).getTargetDevices()
					.stream().filter(t -> t.getTargetDevice().equals(targetDevice)).findAny().orElseThrow(NullPointerException::new);

			responseBean.setHost("SDD");
			responseBean.setPingTime(String.valueOf(targetDeviceEntity.getPingTime()));
			//Creating view code
			responseBean.setViewCode(UuidUtil.getTimeBasedUuid().toString());
			
			//If we detect any null parameter, we will escape without response
		} catch (NullPointerException nullException) {
			return null;
		}

		return responseBean;
	}
	
}