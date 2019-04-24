package com.ww.mock.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

public class MockServerTest {
	
	@Test
	public void testMockServer() throws IOException {
		String expected = "{\"msg\":\"登录超时！\",\"code\":2003}";
			
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet("http://localhost:8080/");
		CloseableHttpResponse response = client.execute(httpGet);
		// 验证输出是否是正确
		InputStream content = response.getEntity().getContent();
		InputStreamReader inputStreamReader = new InputStreamReader(content);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String responseText = bufferedReader.readLine();
		assertThat(responseText, equalTo(expected));
	}
}