package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TransactionDetailsRequestDto;
import com.example.demo.dto.TransactionDetailsResponseDto;
import com.example.demo.exception.InsufficientBalanceException;
import com.example.demo.service.TransactionDetailsService;

@RequestMapping("/transaction")
@RestController
public class TransactionController {
	@Autowired
	TransactionDetailsService transactionDetailsService;

	@PostMapping("/transactionDetails")
	public ResponseEntity<TransactionDetailsResponseDto> transactions(
			@RequestBody TransactionDetailsRequestDto transactionDetailsRequestDto)
			throws InsufficientBalanceException {
		TransactionDetailsResponseDto transactionDetailsResponseDto = transactionDetailsService
				.trasactions(transactionDetailsRequestDto);
		return new ResponseEntity<TransactionDetailsResponseDto>(transactionDetailsResponseDto, HttpStatus.OK);

	}
}

