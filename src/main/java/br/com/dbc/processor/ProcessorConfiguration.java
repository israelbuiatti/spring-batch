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
    			
    			System.out.println(conta);
    			
    		} catch (Exception e) {
    			System.out.println("Falha no processamento: " + "Agência:" + conta.getAgencia() + ", Conta: " + conta.getConta());
    			conta.setRetorno(false);
    		}
            
            
            return conta;
        };
    }


}
