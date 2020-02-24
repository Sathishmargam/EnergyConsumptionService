package com.energy.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Component
@JsonInclude(Include.NON_NULL)
public class ZenAPIResponse extends ErrorResponse{

	private List<APIResponse> apiResponse;
	private boolean status;
	public List<APIResponse> getApiResponse() {
		return apiResponse;
	}
	public void setApiResponse(List<APIResponse> apiResponse) {
		this.apiResponse = apiResponse;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	} 
	
	
}
