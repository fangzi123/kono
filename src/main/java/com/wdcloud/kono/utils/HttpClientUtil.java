package com.wdcloud.kono.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.net.ssl.*;
//import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClientUtil {

    public static final String COMMUNICATION_FAILURE =" { \"code\": 500, \"msg\": \"communication_failure\"}";
    private static final int MAX_SOKET_TIMEOUT =8000;
    private static final int MAX_CONNECTION_TIMEOUT = 8000;
    private static final RequestConfig reqConfig = RequestConfig.custom()//.setProxy(new HttpHost("192.168.20.6",3128))
            .setSocketTimeout(MAX_SOKET_TIMEOUT)
            .setConnectTimeout(MAX_CONNECTION_TIMEOUT)
            .setStaleConnectionCheckEnabled(true).build();
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtil.class);
    private HttpClientUtil() {

    }

    public static String sendGetRequest(String reqURL) {
        String respContent = COMMUNICATION_FAILURE;
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(reqConfig).build();
        //如果有&去除
        reqURL= Utils.TrimEnd(reqURL, "&");
        reqURL=Utils.TrimEnd(reqURL,"?");
        HttpGet httpGet = new HttpGet(reqURL);
       // LOGGER.info("GET-url："+reqURL);
        try {
            CloseableHttpResponse e = httpClient.execute(httpGet);
            HttpEntity entity = e.getEntity();
            if (null != entity) {
                Charset respHeaderDatas = ContentType.getOrDefault(entity).getCharset();
                //gzf:返回值中文乱码，respHeaderDatas=null;
                if (respHeaderDatas == null) {
                    respHeaderDatas = Charset.forName("UTF-8");
                }
                respContent = EntityUtils.toString(entity, respHeaderDatas);
                EntityUtils.consume(entity);
            }

           // System.out.println("-------------------------------------------------------------------------------------------");
            StringBuilder respHeaderDatas = new StringBuilder();
            Header[] respStatusLine = e.getAllHeaders();
            int respHeaderMsg = respStatusLine.length;

            for (int respBodyMsg = 0; respBodyMsg < respHeaderMsg; ++respBodyMsg) {
                Header header = respStatusLine[respBodyMsg];
                respHeaderDatas.append(header.toString()).append("\r\n");
            }
            //System.out.println("-------------------------------------------------------------------------------------------");
        } catch (ConnectTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (SocketTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (ClientProtocolException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (ParseException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (IOException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (Exception e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return respContent;
    }


    public static String sendGetRequest(String reqURL, Map<String, Object> param, String encodeCharset) {
        String respContent = COMMUNICATION_FAILURE;
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(reqConfig).build();
        String str_param = HttpClientUtil.getUrlParamsByMap(param);
        try {
            if(encodeCharset == null && encodeCharset.length() < 1) {
                encodeCharset = "utf-8";
            }
            reqURL = HttpClientUtil.urlFormat(reqURL, str_param, encodeCharset);
            //LOGGER.info("GET-url："+reqURL);
            HttpGet httpGet = new HttpGet(reqURL);

            CloseableHttpResponse e = httpClient.execute(httpGet);
            HttpEntity entity = e.getEntity();
            if (null != entity) {
                Charset respHeaderDatas = ContentType.getOrDefault(entity).getCharset();
                //gzf:返回值中文乱码，respHeaderDatas=null;
                if (respHeaderDatas == null) {
                    respHeaderDatas = Charset.forName("UTF-8");
                }
                respContent = EntityUtils.toString(entity, respHeaderDatas);
                EntityUtils.consume(entity);
            }

           // System.out.println("-------------------------------------------------------------------------------------------");
            StringBuilder respHeaderDatas = new StringBuilder();
            Header[] respStatusLine = e.getAllHeaders();
            int respHeaderMsg = respStatusLine.length;

            for (int respBodyMsg = 0; respBodyMsg < respHeaderMsg; ++respBodyMsg) {
                Header header = respStatusLine[respBodyMsg];
                respHeaderDatas.append(header.toString()).append("\r\n");
            }
        } catch (ConnectTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (SocketTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (ClientProtocolException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (ParseException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (IOException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (Exception e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return respContent;
    }

    public static String sendPostRequestByJson(String reqURL, String reqData) {
        String reseContent = COMMUNICATION_FAILURE;
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(reqConfig).build();
        HttpPost httpPost = new HttpPost(reqURL);
        try {
            String encodeCharset = "utf-8";
            reqURL = HttpClientUtil.urlFormat(reqURL, reqData, encodeCharset);
            httpPost.setHeader("Content-Type", "" +  MediaType.APPLICATION_JSON_VALUE + "; charset=" +  encodeCharset);
            httpPost.setEntity(new StringEntity(reqData == null ? "" : reqData,  encodeCharset));
            CloseableHttpResponse e = httpClient.execute(httpPost);
            HttpEntity entity = e.getEntity();

            if (null != entity) {
                //gzf:返回中文乱码ContentType.getOrDefault(entity).getCharset()==null;
                Charset cs = ContentType.getOrDefault(entity).getCharset();
                if (cs == null) {
                    cs = Charset.forName("UTF-8");
                }
                reseContent = EntityUtils.toString(entity, cs);
                EntityUtils.consume(entity);
            }
        } catch (ConnectTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (SocketTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (Exception e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return reseContent;
    }


    /**
     * 发送httppost请求，接收Map类型参数
     * @param url  请求url
     * @param map  请求参数<key,value>
     * @param encoding 编码方式
     * @return
     */

    public static String sendPostRequest(String url, Map<String,String> map,String encoding) {
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        System.out.println("请求地址："+url);
        System.out.println("请求参数："+nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            try {
                body = EntityUtils.toString(entity, encoding);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            EntityUtils.consume(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //释放链接
        try {
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }



    public static String sendPostRequestRetCode(String reqURL, String reqData, String encodeCharset, String contentType) {
        String reseContent = COMMUNICATION_FAILURE;
        CloseableHttpClient httpClient = null;
        try {

            httpClient = HttpClients.custom().setDefaultRequestConfig(reqConfig).build();

            reqURL = HttpClientUtil.urlFormat(reqURL, reqData, encodeCharset);

            HttpPost httpPost = new HttpPost(reqURL);
            httpPost.setHeader("Content-Type", "" + contentType + "; charset=" + encodeCharset);
            httpPost.setEntity(new StringEntity(reqData == null ? "" : reqData, encodeCharset));
            CloseableHttpResponse e = httpClient.execute(httpPost);
            HttpEntity entity = e.getEntity();

            if (null != entity) {
                //gzf:返回中文乱码ContentType.getOrDefault(entity).getCharset()==null;
                Charset cs = ContentType.getOrDefault(entity).getCharset();
                if (cs == null) {
                    cs = Charset.forName("UTF-8");
                }
                reseContent = EntityUtils.toString(entity, cs);
                reseContent = reseContent.replaceAll("}", ",'httpcode':" + e.getStatusLine().getStatusCode() + "}");
                reseContent = reseContent.replaceAll("}", ",'code':" + e.getStatusLine().getStatusCode() + "}");
                EntityUtils.consume(entity);
            }
        } catch (ConnectTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (SocketTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } catch (Exception e) {
            LOGGER.error("请求通信[" + reqURL + "]时连接超时,堆栈轨迹如下", e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return reseContent;
    }

    public static String sendPostSSLRequest(String reqURL, Map<String, Object> params, String encodeCharset) {
        String responseContent = COMMUNICATION_FAILURE;
        X509TrustManager trustManager = new X509TrustManager() {
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            }

            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        X509HostnameVerifier hostnameVerifier = new X509HostnameVerifier() {
            public void verify(String host, SSLSocket ssl) throws IOException {
            }

            public void verify(String host, X509Certificate cert) throws SSLException {
            }

            public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
            }

            public boolean verify(String arg0, SSLSession arg1) {
                return true;
            }
        };

        try {
            SSLContext e = SSLContext.getInstance("SSL");
            e.init((KeyManager[]) null, new TrustManager[]{trustManager}, new SecureRandom());
            CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(reqConfig).setSSLSocketFactory(new SSLConnectionSocketFactory(e, hostnameVerifier)).build();

            reqURL = HttpClientUtil.urlFormat(reqURL, HttpClientUtil.getUrlParamsByMap(params), encodeCharset);

            HttpPost httpPost = new HttpPost(reqURL);
            if (null != params) {
                ArrayList response = new ArrayList();
                Iterator entity = params.entrySet().iterator();

                while (entity.hasNext()) {
                    Entry entry = (Entry) entity.next();
                    response.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
                }

                httpPost.setEntity(new UrlEncodedFormEntity(response, encodeCharset));
            }

            CloseableHttpResponse response1 = httpClient.execute(httpPost);
            HttpEntity entity1 = response1.getEntity();
            if (null != entity1) {
                responseContent = EntityUtils.toString(entity1, ContentType.getOrDefault(entity1).getCharset());
                EntityUtils.consume(entity1);
            }

            httpClient.close();
        } catch (ConnectTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时协议异常,堆栈轨迹如下", e);
        } catch (SocketTimeoutException e) {
            LOGGER.error("请求通信[" + reqURL + "]时协议异常,堆栈轨迹如下", e);
        } catch (Exception e) {
            LOGGER.error("请求通信[" + reqURL + "]时协议异常,堆栈轨迹如下", e);
        }

        return responseContent;
    }


    /**
     * 将map转换成url
     *
     * @param map
     * @return
     */
    public static String getUrlParamsByMap(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Entry<String, Object> entry : map.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue());
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = s.substring(0, s.length() - 1);
        }
        return s;
    }


    /**
     * 链接格式化
     *
     * @param urlPattern   链接模板
     * @param urlParameter 请求参数
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String urlFormat(String urlPattern, String urlParameter, String encoding) throws Exception {
        Map<String, String[]> urlParameterMap = new HashMap<String, String[]>();
        parseParameters(urlParameterMap, urlParameter, encoding);
        Pattern pattern = Pattern.compile("\\{(\\w+)\\}");
        Matcher matcher = pattern.matcher(urlPattern);
        StringBuffer sbr = new StringBuffer();
        boolean ismatch = false;
        while (matcher.find()) {
            ismatch = true;
            String[] values = urlParameterMap.get(matcher.group(1));
            if (values != null) {
                matcher.appendReplacement(sbr, values[0]);
            } else {
                throw new Exception(matcher.group(1) + "必填項缺失。");
            }
        }
        if (ismatch) {
            matcher.appendTail(sbr);
            return sbr.toString();
        } else {
            if(urlPattern.indexOf("?") > 0){
                urlPattern = urlPattern+"&"+urlParameter;
            }else{
                urlPattern = urlPattern+"?"+urlParameter;
            }
            return urlPattern;
        }
    }

    private static void parseParameters(Map map, String data, String encoding)
            throws UnsupportedEncodingException {
        if ((data == null) || (data.length() <= 0)) {
            return;
        }

        byte[] bytes = null;
        try {
            if (encoding == null)
                bytes = data.getBytes();
            else
                bytes = data.getBytes(encoding);
        } catch (UnsupportedEncodingException uee) {
        }
        parseParameters(map, bytes, encoding);
    }

    private static void parseParameters(Map map, byte[] data, String encoding) throws UnsupportedEncodingException {
        if ((data != null) && (data.length > 0)) {
            int ix = 0;
            int ox = 0;
            String key = null;
            String value = null;
            while (ix < data.length) {
                byte c = data[(ix++)];
                switch ((char) c) {
                    case '&':
                        value = new String(data, 0, ox, encoding);
                        if (key != null) {
                            putMapEntry(map, key, value);
                            key = null;
                        }
                        ox = 0;
                        break;
                    case '=':
                        if (key == null) {
                            key = new String(data, 0, ox, encoding);
                            ox = 0;
                        } else {
                            data[(ox++)] = c;
                        }
                        break;
                    case '+':
                        data[(ox++)] = 32;
                        break;
                    case '%':
                        data[(ox++)] = (byte) ((convertHexDigit(data[(ix++)]) << 4) + convertHexDigit(data[(ix++)]));

                        break;
                    default:
                        data[(ox++)] = c;
                }
            }

            if (key != null) {
                value = new String(data, 0, ox, encoding);
                putMapEntry(map, key, value);
            }
        }
    }

    private static void putMapEntry(Map map, String name, String value) {
        String[] newValues = null;
        String[] oldValues = (String[]) (String[]) map.get(name);
        if (oldValues == null) {
            newValues = new String[1];
            newValues[0] = value;
        } else {
            newValues = new String[oldValues.length + 1];
            System.arraycopy(oldValues, 0, newValues, 0, oldValues.length);
            newValues[oldValues.length] = value;
        }
        map.put(name, newValues);
    }

    protected static byte convertHexDigit(byte b) {
        if ((b >= 48) && (b <= 57)) return (byte) (b - 48);
        if ((b >= 97) && (b <= 102)) return (byte) (b - 97 + 10);
        if ((b >= 65) && (b <= 70)) return (byte) (b - 65 + 10);
        return 0;
    }


    public static byte[] downloadPictureFromHttp(String urlString) {

        LOGGER.info(">>>>>>>>>>>>>>>>download picture byte.url=[" + urlString + "]");
        URL url = null;

        byte[] fileData = null;
        DataInputStream dis = null;
        ByteArrayOutputStream bos = null;

        try {

            url = new URL(urlString);
            dis = new DataInputStream(url.openStream());
            bos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = dis.read(buffer)) > 0) {
                bos.write(buffer, 0, numBytesRead);
            }

            fileData = bos.toByteArray();

        } catch (MalformedURLException e) {
            LOGGER.error("downloadPictureFromHttp byte fail[" + urlString + "]error message:"+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error("downloadPictureFromHttp byte fail[" + urlString + "]error message:"+e.getMessage());
            e.printStackTrace();
        }  catch (Exception e) {
            LOGGER.error("downloadPictureFromHttp byte fail[" + urlString + "]error message:"+e.getMessage());
            e.printStackTrace();
         } finally {

            try {
                if (bos != null) bos.close();
                if (dis != null) dis.close();

            } catch (IOException e) {
                LOGGER.error("downloadPictureFromHttp byte fail[" + urlString + "]error message:"+e.getMessage());
            }

        }

        return fileData;
    }
}
