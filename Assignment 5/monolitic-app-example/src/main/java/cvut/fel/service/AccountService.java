package cvut.fel.service;

import cvut.fel.entity.Account;
import cvut.fel.entity.Customer;

public interface AccountService {
    Account findById(Long id);
}
