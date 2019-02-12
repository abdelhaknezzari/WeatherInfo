package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	String json = "{\n" +
	"   \"Port\":\n" +
	"   {\n" +
	"       \"@alias\": \"defaultHttp\",\n" +
	"       \"Enabled\": \"true\",\n" +
	"       \"Number\": \"10092\",\n" +
	"       \"Protocol\": \"http\",\n" +
	"       \"KeepAliveTimeout\": \"20000\",\n" +
	"       \"ThreadPool\":\n" +
	"       {\n" +
	"           \"@enabled\": \"false\",\n" +
	"           \"Max\": \"150\",\n" +
	"           \"ThreadPriority\": \"5\"\n" +
	"       },\n" +
	"       \"ExtendedProperties\":\n" +
	"       {\n" +
	"           \"Property\":\n" +
	"           [                         \n" +
	"               {\n" +
	"                   \"@name\": \"connectionTimeout\",\n" +
	"                   \"$\": \"20000\"\n" +
	"               }\n" +
	"           ]\n" +
	"       }\n" +
	"   }\n" +
	"}";


	@Test
	public void contextLoads() {
	}



	@Test
public void testCreatingKeyValues() {

	Json jsonFlattener = new Json();
  Map<String, String> map = new HashMap<String, String>();
  try {
    jsonFlattener.addKeys("", new ObjectMapper().readTree(json), map);
  } catch (IOException e) {
    e.printStackTrace();
  }
  System.out.println(map);
}

}

