package com.ssafy.empapp.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class TransactionConfig {
	
 	@Bean
	public TransactionInterceptor transactionAdvice(TransactionManager transactionManager) {
	    log.info(transactionManager.getClass().getName());
	    NameMatchTransactionAttributeSource txAttributeSource = new NameMatchTransactionAttributeSource();
	    RuleBasedTransactionAttribute txAttribute = new RuleBasedTransactionAttribute();
	    txAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    
	    RuleBasedTransactionAttribute txAttribute2 = new RuleBasedTransactionAttribute();
	    txAttribute2.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
	    txAttribute2.setReadOnly(true);
	    
	    HashMap<String, TransactionAttribute> txMethods = new HashMap<String, TransactionAttribute>();
	    txMethods.put("register*", txAttribute);
	    txMethods.put("modify*", txAttribute);
	    txMethods.put("delete*", txAttribute);
	    txMethods.put("get*", txAttribute2);
	    txMethods.put("login", txAttribute2);
	    txAttributeSource.setNameMap(txMethods);
	
	    return new TransactionInterceptor(transactionManager, txAttributeSource);
    }

    @Bean
    public Advisor transactionAdviceAdvisor(TransactionInterceptor transactionAdvice) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("within(com.ssafy.empapp.model.service.*)");
        return new DefaultPointcutAdvisor(pointcut, transactionAdvice);
    }
    
    // 직접 원하는 트랜잭션 매니저를 등록하고 싶을때!!
    @Bean
    public TransactionManager transactionManager(DataSource ds) {
        log.info(ds.getClass().getName());
        return new DataSourceTransactionManager(ds);
    }
}
