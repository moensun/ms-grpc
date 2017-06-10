package com.moensun.grpc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created by Bane.Shi.
 * Copyright MoenSun
 * User: Bane.Shi
 * Date: 2017/6/10
 * Time: 12:43
 */
public class SpringSupportAware implements BeanPostProcessor {

	public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
		return o;
	}

	public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
		return o;
	}
}
