package com.energy.model;

import java.util.List;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Component
@JsonInclude(Include.NON_NULL)
public class ConsumptionReportResponse extends ErrorResponse{

	private List<String> consumptionAmount;
	private boolean status;
	public List<String> getConsumptionAmount() {
		return consumptionAmount;
	}
	public void setConsumptionAmount(List<String> consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
		
}
