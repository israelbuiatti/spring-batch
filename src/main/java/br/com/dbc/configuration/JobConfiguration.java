package br.com.dbc.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableBatchProcessing
public class JobConfiguration {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private Step asyncManagerStep;
	
	@Bean(name = "JobConfiguration")
	public Job asyncJob() {
		return jobBuilderFactory.get("JobConfiguration")
				.incrementer(new RunIdIncrementer())
				.flow(asyncManagerStep)
				.end()
				.build();
	}


}
