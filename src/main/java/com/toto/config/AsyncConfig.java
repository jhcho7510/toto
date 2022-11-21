package com.toto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync // Spring method에서 비동기 기능을 사용가능하게 활성화 한다.
public class AsyncConfig extends AsyncConfigurerSupport {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // 기본 실행 대기하는 Thread의 수
        executor.setMaxPoolSize(30); // 동시 동작하는 최대 Thread의 수
        executor.setQueueCapacity(50); // MaxPoolSize 초과 요청에서 Thread 생성 요청시, 해당 요청을 Queue에 저장하는데 이때 최대 수용 가능한 Queue의 수, Queue에 저장되어있다가 Thread에 자리가 생기면 하나씩 빠져나가 동작
        executor.setThreadNamePrefix("TOTO-ASYNC-"); // 생성되는 Thread 접두사 지정
        executor.initialize();
        return executor;
    }
}

/**
 의사항
 @Async Annotation을 사용할 때 아래와 같은 세 가지 사항을 주의하자.
   1. private method는 사용 불가, public method만 사용 가능
   2. self-invocation(자가 호출) 불가, 즉 inner method는 사용 불가
   3. QueueCapacity 초과 요청에 대한 비동기 method 호출시 방어 코드 작성
     @GetMapping("async")
    public String testAsync() {
        log.info("TEST ASYNC");
        try {
             for(int i=0; i<50; i++) {
                 testService.asyncMethod(i);
        } catch (TaskRejectedException e) {
            // ....
        }
        return "";
     }
 */