package br.com.dbc.writer;

import org.springframework.batch.integration.async.AsyncItemWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import br.com.dbc.model.Conta;

@Configuration
public class WriterConfiguration {
	
	@Bean
	public AsyncItemWriter<Conta> asyncWriter() {
		AsyncItemWriter<Conta> asyncItemWriter = new AsyncItemWriter<>();
		asyncItemWriter.setDelegate(itemWriter());
		return asyncItemWriter;
	}

	@Bean
	public ItemWriter<Conta> itemWriter() {
		return new FlatFileItemWriterBuilder<Conta>()
			.name("writer")
			.append(false)
			.resource(new FileSystemResource("files/dados-retorno.csv"))
			.delimited()
			.delimiter(";")
			.names("agencia", "conta", "saldo", "status","retorno")
			.build();
	}





}
