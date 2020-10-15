package br.com.dbc.step;

import java.util.concurrent.Future;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.TaskExecutor;

import br.com.dbc.model.Conta;

@Configuration
public class StepConfiguration {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private FlatFileItemReader<Conta> asyncReader;
	
	@Autowired
	private AsyncItemProcessor<Conta, Conta> asyncProcessor;
	
	@Autowired
	private AsyncItemWriter<Conta> asyncWriter;
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	
	@Bean
	public Step asyncManagerStep() {
		return stepBuilderFactory.get("asyncManagerStep")
				.<Conta, Future<Conta>>chunk(1000)
				.reader(asyncReader)
				.processor(asyncProcessor)
				.writer(asyncWriter)
				.taskExecutor(taskExecutor)
				.build();
	}
	

}
