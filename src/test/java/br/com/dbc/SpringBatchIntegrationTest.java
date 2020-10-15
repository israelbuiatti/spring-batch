package br.com.dbc;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.AssertFile;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.JobRepositoryTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringRunner.class)
@SpringBatchTest
@EnableAutoConfiguration
//@ContextConfiguration(classes = { SpringBatchConfiguration.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,DirtiesContextTestExecutionListener.class}) 
  
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
class SpringBatchIntegrationTest {

//	@Autowired
//    private JobLauncherTestUtils jobLauncherTestUtils;
//  
//    @Autowired
//    private JobRepositoryTestUtils jobRepositoryTestUtils;
//  
//    @After
//    public void cleanUp() {
//        jobRepositoryTestUtils.removeJobExecutions();
//    }
// 
//    private JobParameters defaultJobParameters() {
//        JobParametersBuilder paramsBuilder = new JobParametersBuilder();
//        paramsBuilder.addString("file.input", TEST_INPUT);
//        paramsBuilder.addString("file.output", TEST_OUTPUT);
//        return paramsBuilder.toJobParameters();
//   }
//    
//    @Test
//	public void givenReferenceOutput_whenJobExecuted_thenSuccess() throws Exception {
//	    // given
//	    FileSystemResource expectedResult = new FileSystemResource(EXPECTED_OUTPUT);
//	    FileSystemResource actualResult = new FileSystemResource(TEST_OUTPUT);
//	 
//	    // when
//	    JobExecution jobExecution = jobLauncherTestUtils.launchJob(defaultJobParameters());
//	    JobInstance actualJobInstance = jobExecution.getJobInstance();
//	    ExitStatus actualJobExitStatus = jobExecution.getExitStatus();
//	  
//	    // then
//	    assertThat(actualJobInstance.getJobName(), is("transformBooksRecords"));
//	    assertThat(actualJobExitStatus.getExitCode(), is("COMPLETED"));
//	    AssertFile.assertFileEquals(expectedResult, actualResult);
//	}
	
}