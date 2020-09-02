package com.npaw.responseservice.controller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/getData")
	@ResponseBody
	public ResponseBean getData(@RequestParam(required = false) String accountCode,
			@RequestParam(required = false) String targetDevice, @RequestParam(required = false) String pluginVersion) throws Exception {
		final ResponseBean responseBean = new ResponseBean();

		try {
			if (accountCode == null || targetDevice == null || pluginVersion == null) {
				return null;
			}
			final TargetDevice targetDeviceEntity = accountRepository.findByAccountCode(accountCode).getTargetDevices()
					.stream().filter(t -> t.getTargetDevice().equals(targetDevice)).findAny().orElseThrow(NullPointerException::new);

			responseBean.setHost("SDD");
			responseBean.setPingTime(String.valueOf(targetDeviceEntity.getPingTime()));
			responseBean.setViewCode("SADSD");
	        JAXBContext jaxbContext = JAXBContext.newInstance(ResponseBean.class);
	        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	       //jaxbMarshaller.marshal(responseBean, responseBean);
		} catch (NullPointerException nullException) {
			return null;
		}

		return responseBean;
	}
}