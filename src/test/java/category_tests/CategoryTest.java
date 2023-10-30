package category_tests;

import com.jayway.jsonpath.JsonPath;
import com.neetgramming.request_util.CategoryRequestUtil;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.http.HttpResponse;

public class CategoryTest {
    private static final String REQ_URL = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
    private final SoftAssert softAssert = new SoftAssert();
    @Test
    public void testCategory() {
        HttpResponse<String> response = CategoryRequestUtil.getResponse(REQ_URL);
        String responseBody = response.body();

        String actualName = JsonPath.parse(responseBody).read("$.Name");
        boolean actualCanReList = (Boolean)(JsonPath.parse(responseBody).read("$.CanRelist"));
        boolean actualDescriptionContains = JsonPath.parse(responseBody).
                read("$.Promotions[?(@.Name=='Gallery')].Description").toString().
                contains("Good position in category");

        softAssert.assertEquals(actualName, "Carbon credits", "Incorrect Name");
        softAssert.assertTrue(actualCanReList, "CanRelist is false");
        softAssert.assertTrue(actualDescriptionContains,  "Description in Gallery NOT contains the text 'Good position in category'");
        softAssert.assertAll();
    }
}
