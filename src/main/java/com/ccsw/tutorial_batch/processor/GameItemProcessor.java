package com.ccsw.tutorial_batch.processor;

import com.ccsw.tutorial_batch.model.Game;
import com.ccsw.tutorial_batch.model.GameBatchItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class GameItemProcessor implements ItemProcessor<Game, GameBatchItem> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameItemProcessor.class);

    @Override
    public GameBatchItem process(final Game game) {

        GameBatchItem gameBatchItem = new GameBatchItem();
        gameBatchItem.setTitle(game.getTitle());
        gameBatchItem.setInStock(game.getStock() > 0);

        LOGGER.info("Converting ( {} ) into ( {} )", game, gameBatchItem);
        return gameBatchItem;
    }
}
