package com.boco.handw.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpGet {
	public static String Get(String url) throws IOException {
		String result = "";
		URL targetUrl;

		try {
			HttpURLConnection httpConnection = null;
			targetUrl = new URL(url);
			httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setRequestMethod("GET");
			// httpConnection.setRequestProperty("Accept", "application/json");
			httpConnection.setRequestProperty("Accept", "text/plain");// 文本格式
			httpConnection.setRequestProperty("Accept-Charset", "UTF-8");
			httpConnection.setRequestProperty("contentType", "UTF-8");

			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException("HTTP GET Request Failed with Error code : " + httpConnection.getResponseCode());
			}

			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream()), "utf-8"));
			result = responseBuffer.readLine();
			httpConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			// httpConnection.disconnect();
		}
		return result;
	}

	public static List<String> listGet(String url) throws IOException {

		URL targetUrl;
		List<String> list = new ArrayList<String>();

		try {
			HttpURLConnection httpConnection = null;
			targetUrl = new URL(url);
			httpConnection = (HttpURLConnection) targetUrl.openConnection();
			httpConnection.setRequestMethod("GET");
			// httpConnection.setRequestProperty("Accept", "application/json");
			httpConnection.setRequestProperty("Accept", "text/plain");// 文本格式
			httpConnection.setRequestProperty("Accept-Charset", "UTF-8");
			httpConnection.setRequestProperty("contentType", "UTF-8");

			if (httpConnection.getResponseCode() != 200) {
				return list;
				// throw new
				// RuntimeException("HTTP GET Request Failed with Error code : "
				// + httpConnection.getResponseCode());

			}
			BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream()), "utf-8"));
			String lineTxt = null;

			while ((lineTxt = responseBuffer.readLine()) != null) {
				list.add(lineTxt);
			}

			httpConnection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			// httpConnection.disconnect();
		}
		return list;
	}
}
