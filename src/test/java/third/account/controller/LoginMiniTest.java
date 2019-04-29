package third.account.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lostvip.app.util.HttpClientUtil;
@FixMethodOrder(MethodSorters.NAME_ASCENDING )
public class LoginMiniTest {
	private static final String URL_BASE = "http://127.0.0.1:8080";
	private static String token = null; 
	Integer expectedCode = 2000;
	
	@Test()
	public void test1_login() throws IOException, JSONException {
		String url = URL_BASE + "/accountMini/login" ;
		HashMap map = new HashMap();
		map.put("businessId", "7");
		map.put("password", "111111");
		map.put("account", "test_886");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j =new JSONObject(responseText);
		int code = j.optInt("code");
		token = j.optString("token");
		assertThat(code, equalTo(expectedCode));
	}

	@Test()
	public void test2_checktoken() throws IOException, JSONException {
		String url = URL_BASE + "/accountMini/isTokenExpired" ;
		HashMap map = new HashMap();
		map.put("token", token);
		map.put("businessId", "7");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j =new JSONObject(responseText);
		int code = j.optInt("code");
		assertThat(code, equalTo(expectedCode));
	}

}