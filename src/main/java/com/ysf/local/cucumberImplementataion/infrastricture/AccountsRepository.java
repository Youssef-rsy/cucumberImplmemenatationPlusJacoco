package com.ysf.local.cucumberImplementataion.infrastricture;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ysf.local.cucumberImplementataion.domaine.Account;

@Repository
public interface AccountsRepository extends JpaRepository<Account, Long>{
}
