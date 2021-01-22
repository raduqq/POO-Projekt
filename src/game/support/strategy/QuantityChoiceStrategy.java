package game.support.strategy;

import game.database.Producers;
import game.support.Producer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class QuantityChoiceStrategy implements EnergyChoiceStrategy {
    @Override
    public Producer chooseEnergyStrategy() {
        // Sort by quantity -> desc
        Comparator<Producer> qtyProdCmp = Comparator.comparing(Producer::getEnergyPerDistributor,
                Comparator.reverseOrder())
                // By ID -> asc
                .thenComparing(Producer::getId);

        return Producers.getInstance().getProducerList().stream()
                .sorted(qtyProdCmp)
                .collect(Collectors.toList())
                .get(0);
    }
}