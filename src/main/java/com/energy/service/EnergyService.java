package com.energy.service;

import java.util.List;

import com.energy.model.APIResponse;
import com.energy.model.EnergyInputData;

public interface EnergyService {

	public void saveEnergydata(EnergyInputData inputData);

	public List<APIResponse> getCounterInfo(Integer counterNumber);

	public List<String> getConsumptionReport(int duration);

}
