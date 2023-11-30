package com.challenge.caleta.controller;

import com.challenge.caleta.dto.*;
import com.challenge.caleta.response.WalletGetResponse;
import com.challenge.caleta.response.WalletPostResponse;
import com.challenge.caleta.response.WalletRollbackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.challenge.caleta.service.WalletService;


@RestController
@RequestMapping("/player")
public class WalletController {
    @Autowired
    private WalletService walletService;

    @GetMapping("/balance/{playerId}")
    public WalletGetResponse getBalance(@PathVariable Long playerId) {
        return walletService.getBalance(playerId);
    }

    @PostMapping("/bet")
    public WalletPostResponse makeBet(@RequestBody BetRequest request) {
        return walletService.makeBet(request);
    }

    @PostMapping("/win")
    public WalletPostResponse makeWin(@RequestBody WinRequest request) {
        return walletService.makeWin(request);
    }

    @PostMapping("/rollback")
    public WalletRollbackResponse rollbackTransaction(@RequestBody RollbackRequest request) {
        return walletService.rollbackTransaction(request);
    }
}