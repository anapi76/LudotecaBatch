package com.ccsw.tutorial_batch.config;

import com.ccsw.tutorial_batch.listener.JobGameCompletionNotificationListener;
import com.ccsw.tutorial_batch.model.Game;
import com.ccsw.tutorial_batch.model.GameBatchItem;
import com.ccsw.tutorial_batch.processor.GameItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class GameBatchConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public ItemReader<Game> readerGame() {
        return new JdbcCursorItemReaderBuilder<Game>().dataSource(this.dataSource).name("readerGame").sql("select title, age, stock from GAME").rowMapper(new BeanPropertyRowMapper<>(Game.class)).build();
    }

    @Bean
    public ItemProcessor<Game, GameBatchItem> processorGame() {
        return new GameItemProcessor();
    }

    @Bean
    public ItemWriter<GameBatchItem> writerGame() {
        return new FlatFileItemWriterBuilder<GameBatchItem>().name("writerGame").resource(new FileSystemResource("target/test-outputs/game-output.txt")).lineAggregator(new PassThroughLineAggregator<>()).build();
    }

    @Bean
    public Step step1Game(JobRepository jobRepository, PlatformTransactionManager transactionManager, ItemReader<Game> readerGame, ItemProcessor<Game, GameBatchItem> processorGame, ItemWriter<GameBatchItem> writerGame) {
        return new StepBuilder("step1Game", jobRepository).<Game, GameBatchItem>chunk(10, transactionManager).reader(readerGame).processor(processorGame).writer(writerGame).build();
    }

    @Bean
    public Job jobGame(JobRepository jobRepository, JobGameCompletionNotificationListener listener, Step step1Game) {
        return new JobBuilder("jobGame", jobRepository).incrementer(new RunIdIncrementer()).listener(listener).flow(step1Game).end().build();
    }
}
