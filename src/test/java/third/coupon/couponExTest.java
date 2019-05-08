package third.coupon;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lostvip.app.util.HttpClientUtil;

import third.account.vo.EbfBusinessAccountMini;

@FixMethodOrder(MethodSorters.NAME_ASCENDING )
public class couponExTest {
	private Integer expectedCode = 2000;
	private static final String URL_BASE = "http://127.0.0.1:8080";
	private static Long   test_id = null;
	private static String g_token ;
	
    
   
    @Test()
	public void test0_login() throws Exception {
		String url = URL_BASE + "/accountMini/login" ;
		HashMap map = new HashMap();
		map.put("businessId", 7);
		map.put("account", "you_can_not_delete");
		map.put("password", "123456");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		g_token = j.optString("token");
		assertThat(code, equalTo(expectedCode));
	}
    
    
	@Test()
	public void test10_findPage() throws Exception {
		String url = URL_BASE + "/smallProgram/couponEx/checkCoupon" ;
		System.out.println("========>:"+url);
		HashMap map = new HashMap();
		map.put("token", g_token);
		map.put("tokenEx", g_token);
		map.put("businessId", 7);
		
		map.put("storeIds", 214);
		map.put("storeId", 214);
		map.put("openId", "oVPyA4nvMrw_kONTgfG1PLk4S_p0");
		map.put("code", "7222214739000268");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		assertThat(code, equalTo(expectedCode));
	}

	
	

}