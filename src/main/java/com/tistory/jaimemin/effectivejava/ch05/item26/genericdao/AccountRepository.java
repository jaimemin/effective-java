package com.tistory.jaimemin.effectivejava.ch05.item26.genericdao;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * AccountRepository와 MessageRepository는 코드가 거의 같음
 * Entity만 다름
 */
public class AccountRepository {

	private Set<Account> accounts;

	public AccountRepository() {
		this.accounts = new HashSet<>();
	}

	public Optional<Account> findById(Long id) {
		return accounts.stream().filter(a -> a.getId().equals(id)).findAny();
	}

	public void add(Account account) {
		this.accounts.add(account);
	}
}

/**
 * 클래스가 늘어나면 늘어날수록 제너릭의 위대함을 알 수 있음 (생산성 증가)
 */
// public class AccountRepository extends GenericRepository<Account> {
//
// }
