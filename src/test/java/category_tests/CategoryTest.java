package api_verification_package;

import com.neetgramming.RequestUtil;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.http.HttpResponse;

public class APIVerification {
    private static final String REQ_URL = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
    private SoftAssert softAssert = new SoftAssert();
    @Test
    public void testVerifyCatelog() {
        //send the request and get the response
        HttpResponse response = RequestUtil.getResponse(REQ_URL);

        JSONObject jsonObject = new JSONObject(response.body().toString());
        jsonObject.get("Promotions.Name[]");

        System.out.println("conn");
        //verify name ==
        softAssert.assertEquals(jsonObject.get("Name"), "Carbon credits", "Incorrect Name");
        softAssert.assertTrue(jsonObject.get("CanReList"), "Carbon credits", "Incorrect Name");
        //verify canRelist ==
        //verify nameDesc contains
    }
}
