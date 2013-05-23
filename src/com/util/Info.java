package com.util;

/**
 * @author ydcun
 * 参数参考http://developer.baidu.com/wiki/index.php?title=docs/pcs/rest/file_data_apis_list
 *
 */
public interface Info {
	/**
	 * 链接的token令牌
	 */
	String ACCESS_TOKEN = "3.a2250ddd95ad14ac620148e632ab4b2f.2592000.1371890458.1091082467-248414";// token
	/**
	 * 获取云盘信息时的method参数值
	 */
	String METHOD_INFO="info";
	/**
	 * 上传文件时METHOD的参数值
	 */
	String METHOD_UPLOAD="upload";
	/**
	 * 下载文件时的METHOD参数值
	 */
	String METHOD_DOWN="download";
	
	/**
	 * 获取云盘空间的URL
	 */
	String URL_INFO = "https://pcs.baidu.com/rest/2.0/pcs/quota";
	/**
	 * 上传/下载文件时的URL
	 */
	String URL_UPLOAD = "https://pcs.baidu.com/rest/2.0/pcs/file";
	
	/**
	 * 遇到重复文件覆盖ondup参数的值
	 */
	String ONDUP_FG="overwrite";
	/**
	 * 遇到重复文件重命名    命名规则为    （文件名_日期.后缀）
	 */
	String ONDUP_CMM="newcopy";
}
