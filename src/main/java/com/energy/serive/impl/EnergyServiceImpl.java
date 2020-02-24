package com.energy.serive.impl;

import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.energy.constants.EnergyConstants;
import com.energy.entity.EnergyDataEntity;
import com.energy.exception.EnergyServiceException;
import com.energy.model.APIResponse;
import com.energy.model.EnergyInputData;
import com.energy.repository.EnergyConsumptionRepository;
import com.energy.service.EnergyService;
import com.google.gson.Gson;

@Service
public class EnergyServiceImpl implements EnergyService {

	private final Logger LOG = LoggerFactory.getLogger(EnergyServiceImpl.class);

	@Autowired
	EnergyConsumptionRepository repository;

	ModelMapper modelMapper = new ModelMapper();

	@Value("${zenhomes.url}")
	private String zenUrl;

	@Override
	public void saveEnergydata(EnergyInputData inputData) {
		try {
			EnergyDataEntity energyData = modelMapper.map(inputData, EnergyDataEntity.class);
			repository.save(energyData);
		} catch (Exception e) {
			throw new EnergyServiceException(EnergyConstants.DATA_INSERTION_FAILURE);
		}
		LOG.info("data has been inserted into the table");
	}

	@Override
	public List<APIResponse> getCounterInfo(Integer counterNumber) {
		if (counterNumber != 0) {
			zenUrl = zenUrl + "/" + counterNumber;
		}
		RestTemplate restTemplate = new RestTemplate();
		URI url = null;
		List<APIResponse> apiResponse;
		try {
			url = new URI(zenUrl);
			String response = restTemplate.getForObject(url, String.class);
			Gson gson = new Gson();
			if (counterNumber != 0) {
				apiResponse = Arrays.asList(gson.fromJson(response, APIResponse.class));
			} else {
				apiResponse = Arrays.asList(gson.fromJson(response, APIResponse[].class));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new EnergyServiceException(EnergyConstants.ZEN_SERVER_ERROR);
		}
		return apiResponse;
	}

	@Override
	public List<String> getConsumptionReport(int duration) {
		return repository.findByLastUpdatedDate(new Date());
	}
}
