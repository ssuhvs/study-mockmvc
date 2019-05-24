package com.ybf.app.module.user;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Date;
import java.util.HashMap;

import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.lostvip.app.controller.YbfUserExtend;
import com.lostvip.app.util.HttpClientUtil;

import third.IConst;

@FixMethodOrder(MethodSorters.NAME_ASCENDING )
public class SaveAccountTest {
	private Integer expectedCode = 2000;
	private static Long   test_id = null;
	private static String g_token ;
	
    private String phone  = "17600196256" ;
    private String idNumber      = "370323198401221834";

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
		String url = IConst.URL_BASE + "/userController/save" ;
//		String url =  "http://127.0.0.1:80/test/index" ;
		YbfUserExtend params = new YbfUserExtend();
        
        //6 + 2 (token + businessId) 个参数
        params.setBusinessId(7L);
		params.setBrandStoreId(96L);
		params.setUserName("测试中");
        params.setPhone(phone);
        params.setAvatar("http://www.baidu.com/pic.png");
        params.setOpenId("1234567890");
        params.setUnionId("123456");
        params.setBrandStoreId(98L);
        params.setIdNumber(idNumber);
        
        params.setBirthday("2018-01-01");
		String responseText = HttpClientUtil.postFormObj(url,params,g_token,"7");
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		test_id = j.optJSONObject("data").optLong("id");
		assertThat(code, equalTo(expectedCode));
	}
	


}