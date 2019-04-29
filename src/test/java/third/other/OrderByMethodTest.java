package third.other;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lostvip.app.util.HttpClientUtil;
@FixMethodOrder(MethodSorters.NAME_ASCENDING )
public class OrderByMethodTest {
	private static final String URL_BASE = "http://127.0.0.1:8080";
	private static String token = null; 
	Integer expectedCode = 2000;
	@Before
	public void setUp() throws IOException, JSONException {
		String url = URL_BASE + "/user/login" ;
		HashMap map = new HashMap();
		map.put("businessId", "1");
		map.put("password", "123456");
		map.put("account", "admin");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		token = j.optJSONObject("data").optString("token");
		
		assertThat("1", equalTo("1"));
	}
	
	@Test()
	public void test11() throws IOException, JSONException {
		String url = URL_BASE + "/ebfWriteOffPersonnel/findListMapCouponUserByPage" ;
		HashMap map = new HashMap();
		map.put("businessId", "1");
		map.put("token", token);
//		map.put("name", "name1");
//		map.put("age", "11");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		
		assertThat(code, equalTo(expectedCode));
	}
	
}