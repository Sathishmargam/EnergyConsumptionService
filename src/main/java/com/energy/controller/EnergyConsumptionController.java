package com.energy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.energy.constants.EnergyConstants;
import com.energy.exception.EnergyServiceException;
import com.energy.model.APIResponse;
import com.energy.model.CallbackCounterResponse;
import com.energy.model.ConsumptionReportResponse;
import com.energy.model.EnergyInputData;
import com.energy.model.ZenAPIResponse;
import com.energy.repository.EnergyConsumptionRepository;
import com.energy.service.EnergyService;

@RestController
@RequestMapping(EnergyConstants.API_MAPPING)
public class EnergyConsumptionController {


	//status
	//gdisgf
	private final Logger LOG = LoggerFactory.getLogger(EnergyConsumptionController.class);

	@Autowired
	EnergyService energyService;

	@Autowired
	EnergyConsumptionRepository repository;

	@Autowired
	CallbackCounterResponse counterResponse;

	@Autowired
	ZenAPIResponse response;
	
	@Autowired
	ConsumptionReportResponse consumptionReport;

	@PostMapping(path = EnergyConstants.COUNTER_CALLBACK)
	public ResponseEntity<CallbackCounterResponse> postElectricityData(@RequestBody EnergyInputData inputData) {

		if (inputData.getConsumptionAmount() == 0 | inputData.getCounterId() == 0) {
			throw new EnergyServiceException(EnergyConstants.INPUT_VALIDATION_MESSAGE);
		}
		LOG.info("Input received with Amount :" + inputData.getConsumptionAmount() + "  for the counter :"
				+ inputData.getCounterId());
		energyService.saveEnergydata(inputData);
		counterResponse.setMessage(EnergyConstants.DATA_SUCCESS_MESSAGE);
		counterResponse.setStatus(true);
		return new ResponseEntity<CallbackCounterResponse>(counterResponse, HttpStatus.OK);
	}

	@GetMapping(path = EnergyConstants.GET_INFO)
	public ResponseEntity<ZenAPIResponse> getExistingVillageInfo(@RequestHeader Integer counterNumber) {
		LOG.info("Counter number received is " + counterNumber);
		response.setApiResponse(energyService.getCounterInfo(counterNumber));
		response.setStatus(true);
		return new ResponseEntity<ZenAPIResponse>(response, HttpStatus.OK);
	}

	@GetMapping(path = EnergyConstants.GET_CONSUMPTION_INFO)
	public ResponseEntity<ConsumptionReportResponse> getConsumptionReport(@RequestParam int duration) {
		LOG.info("duration received is " + duration);
		if (duration != 24) {
			throw new EnergyServiceException(EnergyConstants.DURATION_ERROR_MESSAGE);
		}
		consumptionReport.setConsumptionAmount(energyService.getConsumptionReport(duration));
		consumptionReport.setStatus(true);
		return new ResponseEntity<ConsumptionReportResponse>(consumptionReport, HttpStatus.OK);
	}

}
