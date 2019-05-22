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

import third.IConst;
import third.account.vo.EbfBusinessAccountMini;

@FixMethodOrder(MethodSorters.NAME_ASCENDING )
public class SaveAccount {
	private Integer expectedCode = 2000;
	private static Long   test_id = null;
	private static String g_token ;
	
    private String test_account  = null ;
    private String test_password = null;

    @Before
    public void setUp(){
    	test_account = "test_111";
    	test_password = "123456";
    }
    /**
     * 获取token
     * @throws Exception
     */
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
	


}