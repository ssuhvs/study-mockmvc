package third.account.controller;

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
public class AccountMiniTest2 {
	private Integer expectedCode = 2000;
	private static final String URL_BASE = "http://127.0.0.1:8080";
	private static Long   test_id = null;
	private static String g_token ;
	
    private String test_account  = null ;
    private String test_password = null;
    
    @Before
    public void setUp(){
    	test_account = "test_886";
    	test_password = "123456";
    }
    
    @Test()
	public void test0_login() throws Exception {
		String url = URL_BASE + "/accountMini/login" ;
		HashMap map = new HashMap();
		map.put("businessId", 7);
		map.put("password", "123456");
		map.put("account", "ssz");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		g_token = j.optString("token");
		assertThat(code, equalTo(expectedCode));
	}
    
    
	@Test()
	public void test12_findPage() throws Exception {
		String url = URL_BASE + "/ebfBusinessAccountMini/findAllEbfBusinessAccountMiniByPage" ;
		System.out.println("========>:"+url);
		HashMap map = new HashMap();
		map.put("token", g_token);
		map.put("businessId", 7);
		
		map.put("currentPage", "1");
		map.put("pageSize", "10");
		
		map.put("brandStoreId", 214);
		map.put("storeId", 96);
		map.put("account", test_account);
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		JSONArray arr = j.optJSONObject("data").optJSONArray("dataList");
		assertThat(arr.length(), equalTo(1));
	}

//    @Test()
//	public void test12_findPage() throws Exception {
//		String url = URL_BASE + "/ebfBusinessAccountMini/findAllEbfBusinessAccountMiniByPage" ;
//		System.out.println("========>:"+url);
//		HashMap map = new HashMap();
//		map.put("token", g_token);
//		map.put("businessId", 7);
//		
//		map.put("currentPage", "1");
//		map.put("pageSize", "10");
//		
//		map.put("brandStoreId", 214);
//		map.put("storeId", 81);
//		map.put("account", test_account);
//		String responseText = HttpClientUtil.postForm(url, map);
//		JSONObject j = new JSONObject(responseText);
//		int code = j.optInt("code");
//		JSONArray arr = j.optJSONObject("data").optJSONArray("dataList");
//		assertThat(arr.length(), equalTo(1));
//	}
	
	

}