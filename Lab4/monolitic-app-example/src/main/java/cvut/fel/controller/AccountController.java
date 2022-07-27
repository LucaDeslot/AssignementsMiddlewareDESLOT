package cvut.fel.controller;

import cvut.fel.dto.BookDTO;
import cvut.fel.dto.DTOMapper;
import cvut.fel.service.AccountService;
import cvut.fel.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class AccountController {
    private final AccountService accountService;
    private final DTOMapper dtoMapper;

    @Autowired
    public AccountController(AccountService accountService, DTOMapper dtoMapper) {
        this.accountService = accountService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return ResponseEntity.ok(dtoMapper.bookToDto(accountService.findById(id)));
    }
}
