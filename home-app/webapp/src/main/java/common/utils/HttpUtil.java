package common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpUtil {

	public static final Log logger = LogFactory.getLog(HttpUtil.class);

	public static HttpClient httpClient = getInstance();

	public static HttpClient getInstance() {
		if (httpClient == null) {
			// httpClient = new HttpClient();
			MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
			httpClient = new HttpClient(connectionManager);
			logger.info("create http connet sucess,httpClient:" + httpClient);
		}
		return httpClient;
	}

	/**
	 * POST：http获取数据通用方法
	 * 
	 * @param url
	 *            请求地址
	 * @param bodyParam
	 *            body体参数
	 * @param params
	 *            传入参数集合
	 * @return
	 */
	public static String doPost(String url, String bodyParam,
			Map<String, String> params) {
		PostMethod postMethod = new PostMethod(url);
		// 设置成了默认的恢复策略，在发生异常时候将自动重试3次，在这里你也可以设置成自定义的恢复策略
		postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		// 填入各个表单域的值
		// 将表单的值放入postMethod中
		if (params != null && params.size() > 0) {
			NameValuePair[] data = new NameValuePair[params.size()];
			int i = 0;
			Iterator<Entry<String, String>> iter = params.entrySet().iterator();
			Entry<String, String> entry;
			while (iter.hasNext()) {
				entry = iter.next();
				if (entry == null)
					continue;
				data[i++] = new NameValuePair(entry.getKey(), entry.getValue());
			}
			postMethod.setRequestBody(data);
		}
		if (bodyParam != null) {
			try {
				//System.out.println(url+"?pjson="+URLDecoder.decode(bodyParam, "UTF-8"));
				postMethod.setRequestBody(URLDecoder.decode(bodyParam, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		String result = null;
		try {
			// logger.info("================uri:" + postMethod.getURI());
			// 执行getMethod
			int statusCode = httpClient.executeMethod(postMethod);
			// logger.info("=================statusCode:" + statusCode);
			if (statusCode != HttpStatus.SC_OK) {
				logger.info("Method failed: " + postMethod.getStatusLine());

				// HttpClient对于要求接受后继服务的请求，象POST和PUT等不能自动处理转发
				// 301或者302
				if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
						|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
					// 从头中取出转向的地址
					Header locationHeader = postMethod
							.getResponseHeader("location");
					String location = null;
					if (locationHeader != null) {
						location = locationHeader.getValue();
						logger.info("The page was redirected to:" + location);
					} else {
						logger.info("Location field value is null.");
					}
					return null;
				}
			}
			// 读取内容
			result = postMethod.getResponseBodyAsString();
			// 处理内容
			// logger.info("==result:" + result);
			return result;
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			// logger.info("Please check your provided http address!");
			System.out
					.println("[HttpException]http请求发生致命的异常，可能是协议不对或者返回的内容有问题!");
			// e.printStackTrace();
		} catch (IOException e) {
			// 发生网络异常
			logger.info("[IOException]发生网络异常或接口不存在！！");
			// e.printStackTrace();
		} finally {
			// 释放连接
			postMethod.releaseConnection();
		}
		return result;
	}
	public static String doGet(String url){
		GetMethod getMethod = new GetMethod(url);
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler());
		getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		String result = null;
		try {
			// 执行getMethod
			int statusCode = httpClient.executeMethod(getMethod);
			// logger.info("=================statusCode:" + statusCode);
			if (statusCode != HttpStatus.SC_OK) {
				logger.info("Method failed: " + getMethod.getStatusLine());
				// 301或者302
				if (statusCode == HttpStatus.SC_MOVED_PERMANENTLY
						|| statusCode == HttpStatus.SC_MOVED_TEMPORARILY) {
					// 从头中取出转向的地址
					Header locationHeader = getMethod
							.getResponseHeader("location");
					String location = null;
					if (locationHeader != null) {
						location = locationHeader.getValue();
						logger.info("The page was redirected to:" + location);
					} else {
						logger.info("Location field value is null.");
					}
					return null;
				}
			}
			result = getMethod.getResponseBodyAsString();
			return result;
		} catch (HttpException e) {
			// 发生致命的异常，可能是协议不对或者返回的内容有问题
			System.out
					.println("[HttpException]http请求发生致命的异常，可能是协议不对或者返回的内容有问题!");
			// e.printStackTrace();
		} catch (IOException e) {
			// 发生网络异常
			logger.info("[IOException]发生网络异常或接口不存在！！");
			// e.printStackTrace();
		} finally {
			// 释放连接
			getMethod.releaseConnection();
		}
		return result;
	}
	public static void main(String src[]) {
		Map<String, String> map = new HashMap<String, String>();
		// map.put("host", "h2m2");
		// map.put("cluster", "h2");
		// map.put("app", "os");
		// List<String>result = new HttpUtil().doPostLayoutDynItem(
		// "http://10.18.97.72:9200/metrics/metric/_search","host=h2m2,app=os,cluster=h2"
		// ,"proc_*");
		// String result = new
		// HttpUtil().doPost("http://10.142.90.29:9200/dimensions/dimension/_search",map);
		// logger.info(":" + result);
		// JSONObject json = (JSONObject) JSONObject.parse(result);
		// String host = "host";
		// JSONArray dimValues = json.getJSONArray(host);
		// if (dimValues != null && dimValues.size() > 0) {
		// JSONArray values = new JSONArray();
		// for (Object dimValue : dimValues) {
		// dimValue = dimValue +"(aaa)";
		// values.add(dimValue);
		// }
		// json.put(host, values);
		// }
		// result = json.toString();
		String body = "{\"itemBean\":[{\"itemName\":\"test1\",\"granularities\":\"90\",\"timeInterval\":\"90\",\"itemAttrs\":[{\"itemDesc\":\"cpu_wio\",\"dimensionIds\":\"app,host\",\"metric\":\"cpu_wio\",\"targetType\":\"archive\",\"granularities\":\"90\",\"domainName\":\"ems\",\"itemName\":\"guangli\"}]}]}";
		String body2 = "{\"itemBean\":[{\"itemId\":\"6\",\"itemName\":\"test2\",\"granularities\":\"30\",\"timeInterval\":\"90\",\"itemAttrs\":[{\"itemAttrId\":\"3\",\"itemDesc\":\"cpu_wio2\",\"dimensionIds\":\"app,host\",\"metric\":\"cpu_wio\",\"targetType\":\"archive\",\"granularities\":\"90\",\"domainName\":\"ems\",\"itemName\":\"guangli\"}]}]}";
		// String result = new
		// HttpUtil().doPost("http://localhost:8080/itpub-web/plugins/ems_scene_Item_insertJSON.htm",body,map);
		String result = new HttpUtil()
				.doPost("http://localhost:8080/itpub-web/plugins/ems_scene_Item_updateJSON.htm",
						body2, map);
		logger.info(":" + result);

	}
}
