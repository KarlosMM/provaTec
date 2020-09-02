package com.npaw.responseservice.controller;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.npaw.responseservice.bean.ResponseBean;
import com.npaw.responseservice.entities.TargetDevice;
import com.npaw.responseservice.entities.TargetDeviceXCluster;
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

			responseBean.setHost(getHost(targetDeviceEntity.getTargetDevicesXCluster()));
			// If its the same plugin version, then we will user the target ping time, else,
			// we will use the default ping
			responseBean.setPingTime(targetDeviceEntity.getPlugin().getPluginVersion().equals(pluginVersion)
					? targetDeviceEntity.getPingTime()
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

	/**
	 * We will get the host name by cluster's percentage
	 * @param set
	 * @return
	 */
	private String getHost(final Set<TargetDeviceXCluster> set) {
		String clusterName = null;
		final TreeMap<Integer, String> percentageClusterMap = new TreeMap<Integer, String>(set.stream().collect(
				Collectors.toMap(tdc -> tdc.getPercentage().intValue(), tdc -> tdc.getCluster().getClusterName())));

		final Random objGenerator = new Random();
		final int randomNumber = objGenerator.nextInt(100);

		int sumPercentage = 0;
		for (Map.Entry<Integer, String> entry : percentageClusterMap.entrySet()) {
			final Integer percentage = entry.getKey();
			if (randomNumber <= percentage + sumPercentage) {
				clusterName = entry.getValue();
				break;
			} else {
				sumPercentage += percentage;
			}
		}

		return clusterName;
	}

}