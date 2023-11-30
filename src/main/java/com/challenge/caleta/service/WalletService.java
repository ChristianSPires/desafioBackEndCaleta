package com.challenge.caleta.service;

import com.challenge.caleta.dto.*;
import com.challenge.caleta.response.WalletGetResponse;
import com.challenge.caleta.response.WalletPostResponse;
import com.challenge.caleta.response.WalletRollbackResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.challenge.caleta.repository.PlayerRepository;
import com.challenge.caleta.repository.TransactionRepository;
import com.challenge.caleta.model.PlayerEntity;
import com.challenge.caleta.model.TransactionEntity;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public WalletGetResponse getBalance(Long playerId) {
        PlayerEntity playerEntity = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        return new WalletGetResponse(playerId, playerEntity.getBalance());
    }

    public WalletPostResponse makeBet(BetRequest request) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(request.getPlayer());

        if (optionalPlayer.isPresent()) {
            PlayerEntity playerEntity = optionalPlayer.get();

            if (playerEntity.getBalance() >= request.getValue()) {
                // Atualiza o saldo do jogador
                playerEntity.setBalance(playerEntity.getBalance() - request.getValue());
                playerRepository.save(playerEntity);

                // Registra a transação
                TransactionEntity transactionEntity = new TransactionEntity();
                transactionEntity.setPlayerId(request.getPlayer());
                transactionEntity.setValue(request.getValue());
                transactionEntity.setType("bet");
                transactionEntity.setCanceled(false);
                transactionRepository.save(transactionEntity);

                return new WalletPostResponse(request.getPlayer(), playerEntity.getBalance(), transactionEntity.getId());
            } else {
                // Saldo insuficiente
                throw new RuntimeException("Insufficient balance");
            }
        } else {
            // Jogador não encontrado
            throw new RuntimeException("Player not found");
        }
    }

    public WalletPostResponse makeWin(WinRequest request) {
        Optional<PlayerEntity> optionalPlayer = playerRepository.findById(request.getPlayer());

        if (optionalPlayer.isPresent()) {
            PlayerEntity playerEntity = optionalPlayer.get();

            // Atualiza o saldo do jogador
            playerEntity.setBalance(playerEntity.getBalance() + request.getValue());
            playerRepository.save(playerEntity);

            // Registra a transação
            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setPlayerId(request.getPlayer());
            transactionEntity.setValue(request.getValue());
            transactionEntity.setType("win");
            transactionEntity.setCanceled(false);
            transactionRepository.save(transactionEntity);

            return new WalletPostResponse(request.getPlayer(), playerEntity.getBalance(), transactionEntity.getId());
        } else {
            // Jogador não encontrado
            throw new RuntimeException("Player not found");
        }
    }

    public WalletRollbackResponse rollbackTransaction(RollbackRequest request) {
        Optional<TransactionEntity> optionalTransaction = transactionRepository.findById(request.getTxn());

        if (optionalTransaction.isPresent()) {
            TransactionEntity transactionEntity = optionalTransaction.get();

            if (!transactionEntity.isCanceled()) {
                // Reverte a transação
                if ("bet".equals(transactionEntity.getType())) {
                    // Se a transação for uma aposta, adiciona o valor de volta ao saldo do jogador
                    Optional<PlayerEntity> optionalPlayer = playerRepository.findById(request.getPlayer());

                    if (optionalPlayer.isPresent()) {
                        PlayerEntity playerEntity = optionalPlayer.get();
                        playerEntity.setBalance(playerEntity.getBalance() + request.getValue());
                        playerRepository.save(playerEntity);
                    }

                    // Marca a transação como cancelada
                    transactionEntity.setCanceled(true);
                    transactionRepository.save(transactionEntity);

                    return new WalletRollbackResponse("OK", playerRepository.findById(request.getPlayer()).get().getBalance());
                } else if ("win".equals(transactionEntity.getType())) {
                    return new WalletRollbackResponse("Invalid", playerRepository.findById(request.getPlayer()).get().getBalance());
                }
            } else {
                // Transação já cancelada anteriormente
                return new WalletRollbackResponse("OK", playerRepository.findById(request.getPlayer()).get().getBalance());
            }
        } else {
            // Transação não encontrada
            throw new RuntimeException("Transaction not found");
        }
        throw new RuntimeException("ERRO");
    }
}