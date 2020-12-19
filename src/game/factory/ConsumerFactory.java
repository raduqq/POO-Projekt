package game.factory;

import game.player.Consumer;
import game.player.Distributor;
import game.player.Player;

public class ConsumerFactory implements PlayerFactory{
    @Override
    public Player create(String[] args) {
        int id = Integer.parseInt(args[0]);
        int budget = Integer.parseInt(args[1]);
        int monthlyIncome = Integer.parseInt(args[2]);

        return new Consumer(id, budget, monthlyIncome);
    }
}