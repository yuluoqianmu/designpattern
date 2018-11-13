package com.buka.https;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by  on 2018/10/30.
 */
public class HttpsUtils {

    private static CloseableHttpClient httpClient;
    private static CloseableHttpResponse httpResponse;

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext context = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }

            }).build();

            SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(context, NoopHostnameVerifier.INSTANCE);

            return HttpClients.custom().setSSLSocketFactory(factory).build();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }


    public static String sendhttpsMsg(Map<String, Object> params, String url) {
        try {
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> list = new ArrayList<>();

            if (params != null) {
                for (String key : params.keySet()) {
                    list.add(new BasicNameValuePair(key, params.get(key).toString()));
                }
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");

            httpPost.setEntity(entity);
            httpClient = HttpsUtils.createSSLClientDefault();
            httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity != null) {
                String jsonStr = EntityUtils.toString(httpEntity, "UTF-8");
                return jsonStr;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                httpResponse.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("sl_id_nbank_num_ai", "0");

        System.out.println(HttpsUtils.sendhttpsMsg(map, "https://localhost:9090/xxx/xxx"));

    }
}
