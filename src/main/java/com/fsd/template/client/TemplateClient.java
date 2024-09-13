package com.fsd.template.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url="someUrl",name="feign-client")
public interface TemplateClient {
}
