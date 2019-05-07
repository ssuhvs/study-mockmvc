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

import third.IConst;
@FixMethodOrder(MethodSorters.NAME_ASCENDING )
public class LoginMiniTest {
	private static String token = null; 
	Integer expectedCode = 2000;
	
	@Test()
	public void test1_login() throws IOException, JSONException {
		String url =  IConst.URL_BASE+"/accountMini/login" ;
		HashMap map = new HashMap();
		map.put("businessId", "7");
		map.put("account", "633306");
		map.put("password", "123456");
		map.put("openId", "oVPyA4lvPUN0Qoqy6JOhtwfoiWH8");
		
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j =new JSONObject(responseText);
		int code = j.optInt("code");
		token = j.optString("token");
		assertThat(code, equalTo(expectedCode));
	}

	

}