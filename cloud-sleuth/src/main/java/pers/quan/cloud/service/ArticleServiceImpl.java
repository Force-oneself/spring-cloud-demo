package pers.quan.cloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import brave.Tracer;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	Tracer tracer;

	@Async
	@Override
	public void saveLog(String logger) {
		log.info("异步线程执行");
	}

	@NewSpan(name = "saveLog2")
	@Override
	public void saveLog2(String logger) {
		//ScopedSpan span = tracer.startScopedSpan("saveLog2");
		try {
			Thread.sleep(2000);
		} catch (Exception | Error e) {
			//span.error(e);
		} finally {
			//span.finish(); 
		}
	}

}
