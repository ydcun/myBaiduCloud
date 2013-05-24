
package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.entity.CloudInfo;
import com.google.gson.Gson;

/**
 * @author ydcun 获取百度开发所需的accesToken
 *         说明网址：http://developer.baidu.com/wiki/index.php
 *         ?title=docs/pcs/rest/file_data_apis_list ；
 *         最新的： token：
 *         3.92666f2d7ca22dc9f19372e38532346e
 *         .2592000.1371880919.1091082467-879176 user name:ydcun
 * */
public class AccessToken {
	
	

	/**
	 * @param conn通过get方式获取StringBuffer
	 * @return
	 */
	private StringBuffer getJsonString(URLConnection conn) {
		InputStreamReader isr = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			isr = new InputStreamReader(conn.getInputStream(),"gb2312");
			br = new BufferedReader(isr);
			String line = null;
			sb = new StringBuffer();
			while ((line = br.readLine()) != null) {
				sb.append(line);
				sb.append("\r\n");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(isr!=null)
					isr.close();
			} catch (IOException e) {
				System.out.println("流关闭是异常");
				e.printStackTrace();
			}
		}

		return sb;
	}

	/**
	 * @return
	 * @throws Exception
	 *             获取云空间的信息
	 */
	public CloudInfo getCloudInfo() throws Exception {
		URL u = new URL(Info.URL_INFO + "?method=" + Info.METHOD_INFO + "&access_token="+ Info.ACCESS_TOKEN);
		URLConnection conn = u.openConnection();// 打开网页链接
		// 获取用户云盘信息
		String cloudJson = this.getJsonString(conn).toString();

		// 解析成对象
		Gson gson = new Gson();
		CloudInfo cloudInfo = gson.fromJson(cloudJson, CloudInfo.class);
		System.out.println("云盘信息："+cloudInfo);
		return cloudInfo;
	}

	/**
	 * @param path  下载的文件在云盘中的路径 包括文件名
	 * @param savePath 下载文件保存到本地的路径 包括文件名
	 * @return
	 * @throws Exception
	 */
	public String downFile(String path,String name,String savePath) throws Exception{
		name="20130403.log";
		path ="/apps/mybaidu/20130403.log";
		savePath= name;
		
		
		URL u = new URL(Info.URL_UPLOAD+"?path="+path+"&method="+Info.METHOD_DOWN+"&access_token="+Info.ACCESS_TOKEN);
		URLConnection conn = u.openConnection();// 打开网页链接
		StringBuffer fileBuffer = this.getJsonString(conn);
		//将文件从内存中输出
		File saveFile = new File(savePath);
		BufferedWriter buWriter = new BufferedWriter(new FileWriter(saveFile));
		buWriter.write(fileBuffer.toString());
		buWriter.flush();
		return null;
	}


	/**
	 * @param path 云盘存放路径
	 * @param name 要上传的文件
	 * @return
	 * @throws Exception 
	 */
	public boolean uploadFile(String path,File file) throws Exception{
		//模拟文件
		file = new File("accessToken.jpg");
		path="%2Fapps%2F%E6%B5%8B%E8%AF%95%E5%BA%94%E7%94%A8%2F";//    "/apps/测试应用/"
		
		
		//将需要url传值的参数和url组装起来
		String u =Info.URL_UPLOAD+"?path="+path+file.getName()+"&method="+Info.METHOD_UPLOAD+"&access_token="+Info.ACCESS_TOKEN+"&ondup="+Info.ONDUP_CMM;
		URL url = new URL(u);
		
		//将文件读取到内存中来
		FileReader fin = new FileReader(file);
		BufferedReader buReader = new BufferedReader(fin);
		StringBuffer sb = new StringBuffer();
		String line=null;
		while((line = buReader.readLine())!=null){
			sb.append(line);
		}
		
	    HttpURLConnection httpurlconnection = null;
	    try
	    {
	      httpurlconnection = (HttpURLConnection) url.openConnection();
	      httpurlconnection.setDoOutput(true);
	      httpurlconnection.setRequestMethod("POST");
	      
	      httpurlconnection.getOutputStream().write(sb.toString().getBytes());
	      httpurlconnection.getOutputStream().flush();
	      httpurlconnection.getOutputStream().close();
	      int code = httpurlconnection.getResponseCode();
	      System.out.println("code   " + code);

	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      if(httpurlconnection!=null)
	        httpurlconnection.disconnect();
	    }
		return true;
	}

	public static void main(String[] args) throws Exception {
//		new AccessToken().uploadFile("/",null);
		new AccessToken().downFile(null,null,null);
//		new AccessToken().getCloudInfo();
	}
}

