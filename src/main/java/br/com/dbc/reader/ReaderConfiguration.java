package br.com.dbc.reader;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import br.com.dbc.model.Conta;

@Configuration
public class ReaderConfiguration {
	
	@Bean
	@StepScope
	public FlatFileItemReader<Conta> asyncReader(@Value("#{jobParameters['file']}") String file) {
		return new FlatFileItemReaderBuilder<Conta>()
				.name("reader")
				.resource(new FileSystemResource(file))
				.strict(false)
				.encoding("UTF-8")
				.linesToSkip(1)
				.delimited()
				.delimiter(";")
				.names("agencia", "conta", "saldo", "status")
				.targetType(Conta.class)
				.build();
	}
	

}
