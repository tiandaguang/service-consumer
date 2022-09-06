package com.boot.demo.utils.http;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: sh
 * @Date: 2018/9/8 15:48
 */
@Slf4j
public class HttpUtil {


//
//    /**
//     * get请求
//     *
//     * @return
//     */
//    public static String doGet(String url) {
//        try {
//            HttpClient client = new DefaultHttpClient();
//            //发送get请求
//            HttpGet request = new HttpGet(url);
//            HttpResponse response = client.execute(request);
//
//            /**请求发送成功，并得到响应**/
//            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                /**读取服务器返回过来的json字符串数据**/
//                String strResult = EntityUtils.toString(response.getEntity());
//
//                return strResult;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    /**
//     * post请求(用于key-value格式的参数)
//     *
//     * @param url
//     * @param params
//     * @return
//     */
//    public static String doPost(String url, Map params) {
//
//        BufferedReader in = null;
//        try {
//            // 定义HttpClient
//            HttpClient client = new DefaultHttpClient();
//            // 实例化HTTP方法
//            HttpPost request = new HttpPost();
//            request.setURI(new URI(url));
//
//            //设置参数
//            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//            for (Iterator iter = params.keySet().iterator(); iter.hasNext(); ) {
//                String name = (String) iter.next();
//                String value = String.valueOf(params.get(name));
//                nvps.add(new BasicNameValuePair(name, value));
//
//                //System.out.println(name +"-"+value);
//            }
//            request.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
//
//            HttpResponse response = client.execute(request);
//            int code = response.getStatusLine().getStatusCode();
//            if (code == 200) {    //请求成功
//                in = new BufferedReader(new InputStreamReader(response.getEntity()
//                        .getContent(), "utf-8"));
//                StringBuffer sb = new StringBuffer("");
//                String line = "";
//                String nl = System.getProperty("line.separator");
//                while ((line = in.readLine()) != null) {
//                    sb.append(line + nl);
//                }
//                in.close();
//                return sb.toString();
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * post请求（用于请求json格式的参数）
//     *
//     * @param url
//     * @param params
//     * @return
//     */
//    public static String doPost(String url, String params) throws Exception {
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpPost httpPost = new HttpPost(url);
//        httpPost.setHeader("Accept", "application/json");
//        httpPost.setHeader("Content-Type", "application/json");
//        String charSet = "UTF-8";
//        StringEntity entity = new StringEntity(params, charSet);
//        httpPost.setEntity(entity);
//        CloseableHttpResponse response = null;
//
//        try {
//
//            response = httpclient.execute(httpPost);
//            StatusLine status = response.getStatusLine();
//            int state = status.getStatusCode();
//            if (state == HttpStatus.SC_OK) {
//                HttpEntity responseEntity = response.getEntity();
//                String jsonString = EntityUtils.toString(responseEntity);
//                return jsonString;
//            } else {
//                logger.error("请求返回:" + state + "(" + url + ")");
//            }
//        } finally {
//            if (response != null) {
//                try {
//                    response.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            try {
//                httpclient.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }

}

