
## Descrição


Aplicação de processamento de arquivo CVS com Spring Batch

Esta aplicação tem como objetivo o processamento assíncrono de uma grande massa de dados via arquivo csv, usando um serviço fake para simulação do processamento de dados desse arquivo.

Foi utilizado o Spring Batch por seu alto poder de processamento assíncrono, facilidade na implementação e controle de falhas de processamento.

É dado um arquivo csv de entrada, onde esse arquivo é lido dinamicamente,  processado em lote e assincronamente, não comprometendo o estouro de memória do servidor.

A aplicação retorna um novo arquivo csv, com uma nova coluna de dados, informando o retorno do processamento de cada registro. Caso o processamento tenha sido efetuado com sucesso, o campo é preenchido com true, caso contrário, false.



## Pré requisito
- Maven 3
- Java 8+
- Lombok

&nbsp;


## Arquivo CSV
O arquivo de exemplo se encontra dentro do projeto, localizando-se em files/dados.csv

```
agencia;conta;saldo;status
0101;12225-6;100,00;A
0101;12226-8;3200,50;A
3202;40011-1;-35,12;I
3202;54001-2;0,00;P
3202;00321-2;34500,00;B
```

## Executando o projeto

Para a execução deste projeto, é necessário gerar o build com o maven. Será gerado uma aplicação SpringBoot standalone. Em seguida, executar o arquivo jar gerado passando o path do arquivo csv no parâmetro file
```
mvn clean package

java -jar target/dbc-spring-batch-0.0.1-SNAPSHOT.jar file=files/dados.csv

```



## Visualizando o arquivo gerado

```
cat files/dados-retorno.csv
```


## Visualizando logs gerado

```
cat logs/app.log
```

