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
	private static String tokenEx = null,g_token=null; 
	Integer expectedCode = 2000;
	private String password = "123456" ;
	private String passwordNew = "111111";
	@Test()
	public void test0_login() throws IOException, JSONException {
		String url = "http://test.100smartdata.cn/user/login" ;
		HashMap map = new HashMap();
		map.put("businessId", "1");
		map.put("password", "123456");
		map.put("account", "admin");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		g_token = j.optJSONObject("data").optString("token");
		assertThat(code, equalTo(expectedCode));
	}
	
	@Test()
	public void test1_login() throws IOException, JSONException {
		String url =  IConst.URL_BASE+"/accountMini/login" ;
		HashMap map = new HashMap();
		map.put("businessId", "7");
		map.put("account", "you_can_not_delete");
		map.put("password", password);
		map.put("openId", "oVPyA4lvPUN0Qoqy6JOhtwfoiWH8");
		
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j =new JSONObject(responseText);
		int code = j.optInt("code");
		tokenEx = j.optJSONObject("data").optString("tokenEx");
		assertThat(code, equalTo(expectedCode));
	}

	@Test()
	public void test20_changePwd() throws IOException, JSONException {
		String url =  IConst.URL_BASE+"/accountMini/changePwd" ;
		HashMap map = new HashMap();
		map.put("businessId", "7");
		map.put("account", "you_can_not_delete");
		map.put("password", password);
		map.put("passwordNew", passwordNew);
		map.put("tokenEx", tokenEx);
		map.put("token", g_token);
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j =new JSONObject(responseText);
		int code = j.optInt("code");
		assertThat(code, equalTo(expectedCode));
	}
	
//	

}