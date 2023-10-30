package api_verification_package;

import com.neetgramming.RequestUtil;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.http.HttpResponse;

public class APIVerification {
    private static final String REQ_URL = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";
    @Test
    public void testVerifyCatelog() {
        //send the request and get the response
//        HttpURLConnection conn = RequestUtil.getHTTPConnection(REQ_URL);
        HttpResponse response = RequestUtil.getResponse(REQ_URL);
        System.out.println("conn");
        //verify name ==
        //verify canRelist ==
        //verify nameDesc contains
    }
}
