package com.redis.pubsub.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redis.pubsub.dto.Product;

@RestController
public class Publisher {

	@Autowired
	private RedisTemplate template;
	
	@Autowired
	private ChannelTopic  topic;
	
	@PostMapping("/publish")
	public String publish(Product product) {
		this.template.convertAndSend(topic.getTopic(), product.toString());
		return "Event published";
	}
	
}
