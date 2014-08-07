package com.mkyong.common.controller;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by toumi on 06/08/14.
 */


@Controller
@RequestMapping(value={"/credit", "/dossier", "/portefeuille", "ficp"})
public class creditController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String print(HttpServletRequest request) {

        String[] arrayUrl= request.getRequestURI().split("/");
        String paramWS=arrayUrl[arrayUrl.length-1];
        String content="";


        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://10.199.54.215:9000/staging/SofincoWS/"+paramWS);
            InputStreamEntity reqEntity  = new InputStreamEntity(request.getInputStream(), -1);
            httpPost.setEntity(reqEntity);

            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity respEntity = response.getEntity();
            if (respEntity != null) {
                // EntityUtils to get the response content
                content =  EntityUtils.toString(respEntity);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
