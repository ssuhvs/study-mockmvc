package third.account.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lostvip.app.util.HttpClientUtil;

import third.IConst;
import third.account.vo.EbfBusinessAccountMini;

@FixMethodOrder(MethodSorters.NAME_ASCENDING )
public class AccountMiniTest {
	private Integer expectedCode = 2000;
	private static Long   test_id = null;
	private static String g_token ;
	
    private String test_account  = null ;
    private String test_password = null;
    
    @Before
    public void setUp(){
    	test_account = "you_can_not_delete1";
    	test_password = "123456";
    }
	@Test()
	public void test0_login() throws Exception {
		String url = "http://test.100smartdata.cn/user/login" ;
		HashMap map = new HashMap();
		map.put("businessId", 1);
		map.put("account", "admin");
		map.put("password", "123456");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		g_token = j.optJSONObject("data").optString("token");
		assertThat(code, equalTo(expectedCode));
	}

    /**
     * 新建账号
     * @throws Exception
     */
	@Test()
	public void test11_save() throws Exception {
		String url = IConst.URL_BASE + "/ebfBusinessAccountMini/saveEbfBusinessAccountMini" ;
        EbfBusinessAccountMini params = new EbfBusinessAccountMini();
        
        //6 + 2 (token + businessId) 个参数
        params.setBusinessId(7L);
        params.setStoreId(214L);
		params.setBrandStoreId(96L);
       
        params.setAccount(test_account);
        params.setPassword(test_password);
        params.setAuth("0");
 
        System.out.println("1###################test11_save:"+test_account);
		String responseText = HttpClientUtil.postFormObj(url,params,g_token,"7");
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		test_id = j.optJSONObject("data").optLong("id");
		assertThat(code, equalTo(expectedCode));
	}
	
	@Test()
	public void test12_findPage() throws Exception {
		String url = IConst.URL_BASE + "/ebfBusinessAccountMini/findAllEbfBusinessAccountMiniByPage" ;
		System.out.println("========>:"+url);
		HashMap map = new HashMap();
		map.put("token", g_token);
		map.put("businessId", 7);
		
		map.put("currentPage", "1");
		map.put("pageSize", "10");
		
		map.put("storeId", 214);
		map.put("brandStoreId", 96);
		
		map.put("account", test_account);
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		JSONArray arr = j.optJSONObject("data").optJSONArray("dataList");
		assertThat(arr.length(), equalTo(1));
	}
	
	
	
	/**
	 * 登录新账号
	 * @throws Exception
	 */
	@Test()
	public void test12_login() throws Exception {
		System.out.println("2###################test12_login:"+test_account);
		String url = IConst.URL_BASE + "/accountMini/login" ;
		HashMap map = new HashMap();
		// 2个参数
		map.put("account", test_account);
		map.put("password", test_password);
		map.put("businessId", "7");
		
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		///test_id = j.optJSONObject("businessAccount").optLong("id");
		int code = j.optInt("code");
		assertThat(code, equalTo(expectedCode));
	}
	

	@Test()
	public void test20_get() throws Exception {
		System.out.println("3###################test2_get:"+test_account);
		String url = IConst.URL_BASE + "/ebfBusinessAccountMini/getEbfBusinessAccountMiniById" ;
        EbfBusinessAccountMini params = new EbfBusinessAccountMini();
        //1 + 2 (token + businessId) 个参数
        params.setId(test_id);

		String responseText = HttpClientUtil.postFormObj(url,params,g_token,"7");
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		
		assertThat(code, equalTo(expectedCode));
	}
	
	
	
	@Test()
	public void test30_update() throws Exception {
 	System.out.println("3###################test3_update:"+test_account);
		String url = IConst.URL_BASE + "/ebfBusinessAccountMini/updEbfBusinessAccountMini" ;
        EbfBusinessAccountMini params = new EbfBusinessAccountMini();
        
        //3 + 2 (token + businessId) 个参数
        params.setId(test_id);
        params.setPassword("111111");
        params.setAuth("1");
        
		String responseText = HttpClientUtil.postFormObj(url,params,g_token,"7");
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");

		assertThat(code, equalTo(expectedCode));
	}
	/**
	 * 修改密码后重新登录
	 * @throws Exception
	 */
	@Test()
	public void test31_login() throws Exception {
		String url = IConst.URL_BASE + "/accountMini/login" ;
		HashMap map = new HashMap();
		map.put("businessId","7");
		map.put("account", test_account);
		map.put("password", "111111");//新密码
		
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		g_token = j.optString("token");
		assertThat(code, equalTo(expectedCode));
	}

	
	/**
	 * 删除新加进来的数据
	 * @throws Exception
	 */
	@Test()
	public void test40_del() throws Exception {
		String url = IConst.URL_BASE + "/ebfBusinessAccountMini/delEbfBusinessAccountMiniByIds" ;
		HashMap map = new HashMap();
		 //1 + 2 (token + businessId) 个参数
		map.put("ids", test_id);
		map.put("token", g_token);
		map.put("businessId", "7");
		String responseText = HttpClientUtil.postForm(url, map);

		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");

		assertThat(code, equalTo(expectedCode));
	}


}