package cvut.fel.service;

import cvut.fel.entity.Account;
import cvut.fel.entity.Customer;
import cvut.fel.exception.FieldMissingException;
import cvut.fel.exception.NotFoundException;
import cvut.fel.repository.AccountRepository;
import cvut.fel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountServiceImp {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findById(Long id){
        if (id == null)
            throw new FieldMissingException();
        return accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BOOK_NOT_FOUND"));
    }
}
