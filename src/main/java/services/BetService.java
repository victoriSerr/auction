package services;

import models.Bet;

public class BetService {
    private ConnectBd connectBd = new ConnectBd();

    public void saveBet(Bet bet) {
        connectBd.betRepository.save(bet);
    }

    public Bet findLatest(Long id) {
        return connectBd.betRepository.findLatest(id);
    }
}
