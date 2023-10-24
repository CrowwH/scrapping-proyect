package com.scrapping.scrapping;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@SpringBootTest
class ScrappingApplicationTests {

	@Autowired
	public ScrappingService scrappingService;

	@Test
	void contextLoads() {
	}

	@Test
	void redisConnectiontext(){
		JedisPool pool = new JedisPool("172.17.0.3", 6379);

		try (Jedis jedis = pool.getResource()) {
				// Store & Retrieve a simple string
				jedis.set("foo", "bar");
				System.out.println(jedis.get("foo")); // prints bar
				
				// Store & Retrieve a HashMap
				Map<String, String> hash = new HashMap<>();
				hash.put("name", "John");
				hash.put("surname", "Smith");
				hash.put("company", "Redis");
				hash.put("age", "29");
				jedis.hset("user-session:123", hash);
				System.out.println(jedis.hgetAll("user-session:123"));
				// Prints: {name=John, surname=Smith, company=Redis, age=29}
			}
		}

	@Test
	void scrappingApplicationTests() throws IOException{

		String url = "https://www.google.com";
		System.out.print("Parsing page" + url + "...");

		Document doc = Jsoup.connect(url).get();
		
		doc.select("a")
			.forEach(a -> System.out.println(a.html() + ";" + a.attr("href")));

	}

	@Test
	void scrapTest(){
		Helbidea test= new Helbide("https://www.google.com", null);
		List<Helbidea> emaitza = scrappingService.scrap(test);

		emaitza.forEach(helbidea -> System.out.println(helbidea.toString()));
	}
}