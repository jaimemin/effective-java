package com.tistory.jaimemin.effectivejava.ch05.item26.genericdao;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

class AccountRepositoryTest {

	@Test
	void findById() {
		AccountRepository accountRepository = new AccountRepository();
		Account account = new Account(1L, "jaimemin");
		accountRepository.add(account);

		Optional<Account> byId = accountRepository.findById(1L);
		assertThat(byId.isPresent());
	}
}