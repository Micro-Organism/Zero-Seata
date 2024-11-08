package com.zero.seata.balance.controller;

import com.zero.seata.balance.domain.dto.AccountReduceBalanceDTO;
import com.zero.seata.balance.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AccountController {

	@Autowired
	private AccountService accountService;

	@PostMapping("/balance")
	public Boolean reduceBalance(@RequestBody AccountReduceBalanceDTO accountReduceBalanceDTO) {
		log.info("[reduceBalance] 收到减少余额请求, 用户:{}, 金额:{}", accountReduceBalanceDTO.getUserId(),
				accountReduceBalanceDTO.getPrice());
		try {
			accountService.reduceBalance(accountReduceBalanceDTO.getUserId(), accountReduceBalanceDTO.getPrice());
			// 正常扣除余额，返回 true
			return true;
		} catch (Exception e) {
			// 失败扣除余额，返回 false
			return false;
		}
	}
}