package com.npaw.responseservice.controller;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npaw.responseservice.bean.ResponseBean;
import com.npaw.responseservice.entities.TargetDevice;
import com.npaw.responseservice.repositories.AccountRepository;

@RestController
public class ServiceController {

	private final static Short DEFAULT_PING = 5;
	@Autowired
	private AccountRepository accountRepository;

	@GetMapping(value = "/getData", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseBean getData(@RequestParam(required = false) String accountCode,
			@RequestParam(required = false) String targetDevice, @RequestParam(required = false) String pluginVersion)
			throws Exception {
		final ResponseBean responseBean = new ResponseBean();

		try {

			final TargetDevice targetDeviceEntity = accountRepository.findByAccountCode(accountCode).getTargetDevices()
					.stream().filter(t -> t.getTargetDevice().equals(targetDevice)).findAny()
					.orElseThrow(NullPointerException::new);

			responseBean.setHost("SDD");
			// If its the same plugin version, then we will user the target ping time, else,
			// we will use the default ping
			responseBean.setPingTime(
					targetDeviceEntity.getPluginVersion().equals(pluginVersion) ? targetDeviceEntity.getPingTime()
							: DEFAULT_PING);
			// Creating view code
			responseBean.setViewCode(UuidUtil.getTimeBasedUuid().toString());

			// If we detect any null parameter or any non existing entity, we will escape
			// without response
		} catch (NullPointerException nullException) {
			return null;
		} catch (Exception exception) {
			throw new RuntimeException(exception);
		}

		return responseBean;
	}

}