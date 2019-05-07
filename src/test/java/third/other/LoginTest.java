package third.other;

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
public class LoginTest {
	Integer expectedCode = 2000;
	
	@Test()
	public void test11() throws IOException, JSONException {
		String url = "http://test.100smartdata.cn/user/login" ;
		HashMap map = new HashMap();
		map.put("businessId", "1");
		map.put("password", "123456");
		map.put("account", "admin");
		String responseText = HttpClientUtil.postForm(url, map);
		JSONObject j = new JSONObject(responseText);
		int code = j.optInt("code");
		assertThat(code, equalTo(expectedCode));
	}
	
}