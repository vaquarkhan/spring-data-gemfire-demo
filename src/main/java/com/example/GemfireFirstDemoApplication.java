package com.example;

import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.example.bean.RecordBean;
import com.example.repository.RecordRepository;

/**
 * 
 * @author Viquar khan 
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.example"})

public class GemfireFirstDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GemfireFirstDemoApplication.class, args);
		//
		System.err.println("Gemfire start---------------------------------------------------------------------------");
		getGemfireStart();
	}

	private static void getGemfireStart() {
		try {

			
			
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
					context.setConfigLocation(new ClassPathResource("gfshBean.xml").getPath());
					context.refresh();
					RecordRepository recordRepository = context.getBean( RecordRepository.class);
			
			
			System.err.println("Gemfire method start---------------------------------------------------------------------------");
			//
			RecordBean recordBean = new RecordBean("1", "One");
			recordRepository.save(recordBean);
			System.out.println("Successful run!!");

			RecordBean recordBeanFetched = recordRepository.findByRecordId("2");
			System.out.println("The Fetched record bean is " + recordBeanFetched);

			Iterable<RecordBean> recordCollection = recordRepository.myFindAll();
			System.out.println("RecordBeans List : ");
			for (Iterator<RecordBean> iterator = recordCollection.iterator(); iterator.hasNext();) {
				RecordBean recordBeannew = (RecordBean) iterator.next();
				System.out.println("Cache data-->"+recordBeannew);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
