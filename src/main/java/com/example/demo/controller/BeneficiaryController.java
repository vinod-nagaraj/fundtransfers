package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BeneficiaryRequestDto;
import com.example.demo.dto.BeneficiaryResponseDto;
import com.example.demo.exception.UnsuccessfulRegistrationException;
import com.example.demo.service.BeneficiaryService;

@RequestMapping("/transaction")
@RestController
public class BeneficiaryController {

	@Autowired
	BeneficiaryService beneficiaryService;

	@PostMapping("/addBeneficiary")
	public ResponseEntity<BeneficiaryResponseDto> addBeneficiaries(
			@RequestBody BeneficiaryRequestDto beneficiaryRequestDto) throws UnsuccessfulRegistrationException {
		BeneficiaryResponseDto beneficiaryResponseDto = beneficiaryService.addBeneficiary(beneficiaryRequestDto);
		return new ResponseEntity<BeneficiaryResponseDto>(beneficiaryResponseDto, HttpStatus.CREATED);

	}

}