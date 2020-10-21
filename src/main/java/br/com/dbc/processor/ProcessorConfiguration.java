package br.com.dbc.processor;

import org.springframework.batch.integration.async.AsyncItemProcessor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

import br.com.dbc.model.Conta;
import br.com.dbc.service.ReceitaService;
import br.com.dbc.utils.Utils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class ProcessorConfiguration {
	
	@Autowired
	private TaskExecutor taskExecutor;
	
	@Autowired
	private ReceitaService receitaService;
	
	@Bean
	public AsyncItemProcessor<Conta, Conta> asyncProcessor() {
		AsyncItemProcessor<Conta, Conta> asyncItemProcessor = new AsyncItemProcessor<>();
		asyncItemProcessor.setDelegate(itemProcessor());
		asyncItemProcessor.setTaskExecutor(taskExecutor);
		return asyncItemProcessor;
	}
	
	
    @Bean
    public ItemProcessor<Conta, Conta> itemProcessor() {
        return (conta) -> {
        	
        	try {
        		
    			boolean retorno = receitaService.atualizarConta(
    						conta.getAgencia(), 
    						Utils.somenteNumero(conta.getConta()), 
    						Utils.convertMoedaToBase(conta.getSaldo()), conta.getStatus()
    					);
    			conta.setRetorno(retorno);
    			
    			log.info("Processo executado: " + conta.toString());
    			
    		} catch (Exception e) {
    			log.error("Falha no processamento: " + "Agência:" + conta.getAgencia() + ", Conta: " + conta.getConta(), e);
    			conta.setRetorno(false);
    		}
            
            
            return conta;
        };
    }


}
