package eu.maryns.fix.account.repository;

import eu.maryns.fix.account.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "account",path = "account")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {
}
