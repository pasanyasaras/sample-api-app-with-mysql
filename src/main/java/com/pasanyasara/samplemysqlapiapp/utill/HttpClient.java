package com.pasanyasara.samplemysqlapiapp.utill;

import com.pasanyasara.samplemysqlapiapp.constant.APIConstant;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
public class HttpClient {

    private HttpClient(){

    }

    private static String adminUsername;
    private static String adminPassword;

    @Value("${admin.username}")
    private void setUsername(String username) {
        adminUsername = username;
    }

    @Value("${admin.password}")
    private void setPassword(String password) {
        adminPassword = password;
    }

    private static String getBasicAuthHeader() {
        String adminCredentials = adminUsername + APIConstant.COLON + adminPassword;
        return APIConstant.BASIC_AUTH_VALUE
                + Base64.getEncoder().encodeToString(adminCredentials.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * HTTP GET method
     *
     * @param url
     * @return CloseableHttpResponse
     * @throws IOException
     */
    public static CloseableHttpResponse get(CloseableHttpClient apacheHttpClient, String url) throws IOException {

        //String basicAuthHeader = getBasicAuthHeader();

        HttpGet request = new HttpGet(url);
        //request.addHeader(HttpHeaders.AUTHORIZATION, basicAuthHeader);

        if (apacheHttpClient != null) {
            return apacheHttpClient.execute(request);
        }
        return null;
    }

    /**
     * HTTP DELETE method
     *
     * @param url
     * @return CloseableHttpResponse
     * @throws IOException
     */
    public static CloseableHttpResponse delete(CloseableHttpClient apacheHttpClient, String url) throws IOException {

        //String basicAuthHeader = getBasicAuthHeader();

        HttpDelete request = new HttpDelete(url);
        //request.addHeader(HttpHeaders.AUTHORIZATION, basicAuthHeader);

        if (apacheHttpClient != null) {
            return apacheHttpClient.execute(request);
        }
        return null;
    }
}
