package com.energy.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.energy.model.APIResponse;
import com.energy.model.EnergyInputData;
import com.energy.model.VillageVO;
import com.energy.serive.impl.EnergyServiceImpl;

public class EnergyTestServiceImpl {

	@Mock
	EnergyServiceImpl energyTestServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Value("${zenhomes.url}")
	private String zenUrl;
	
	
	@Test
	public void testConsumptionReport() {
		EnergyInputData inputData = new EnergyInputData();
		inputData.setConsumptionAmount(12);
		inputData.setVillageName("village1");
		inputData.setCounterId(12);
		energyTestServiceImpl.saveEnergydata(inputData);
		List<String> expectedResult = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		expectedResult.add("12");
		when(energyTestServiceImpl.getConsumptionReport(12)).thenReturn(expectedResult);
		result = energyTestServiceImpl.getConsumptionReport(12);
		assertEquals(expectedResult.get(0), result.get(0));
	}
	
	
	@Test
	public void testCounterInfo() {
		List<APIResponse> expectedApiResponse = new ArrayList<APIResponse>();	
		List<APIResponse> apiResponse = new ArrayList<APIResponse>();
		APIResponse villarribaVill = new APIResponse();
		VillageVO villarribaVillVo = new VillageVO();
		villarribaVillVo.setName("Villarriba");
		villarribaVillVo.setId("100");
		villarribaVill.setId("1");
		villarribaVill.setVillage(villarribaVillVo);
		expectedApiResponse.add(villarribaVill);
	    when(energyTestServiceImpl.getCounterInfo(1)).thenReturn(expectedApiResponse);
	    apiResponse=energyTestServiceImpl.getCounterInfo(1);
	    assertEquals(expectedApiResponse.get(0).getId(), apiResponse.get(0).getId());
	    assertEquals(expectedApiResponse.get(0).getVillage(), apiResponse.get(0).getVillage());
	}

}
