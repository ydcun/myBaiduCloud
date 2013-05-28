
package com.util;

/**
 * @author ydcun
 * 参数参考http://developer.baidu.com/wiki/index.php?title=docs/pcs/rest/file_data_apis_list
 *mybaidu token:3.ffe1020e20a52f873600aa8ef07fa609.2592000.1371955887.1091082467-879176
 *测试应用 token:3.a2250ddd95ad14ac620148e632ab4b2f.2592000.1371890458.1091082467-248414
 *
 *
 */
public interface Info {
	/**
	 * 应用的路径 "/apps/mybaidu/"
	 */
	String PATH="%2fapps%2fmybaidu%2f";
	/**
	 * 链接的token令牌
	 */
	String ACCESS_TOKEN = "3.ffe1020e20a52f873600aa8ef07fa609.2592000.1371955887.1091082467-879176";// token
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
	 * 获取目录内文件/目录列表时的METHOD参数值
	 */
	String METHOD_LIST="list";
	
	/**
	 * 创建目录时method参数值
	 */
	String METHOD_MKDIR="mkdir"; 
	/**
	 * 获取单个文件或目录的详细信息中method参数值
	 */
	String METHOD_META="meta";
	/**
	 * 
	 */
	String METHOD_METH="move";
	
	
	
	/**
	 * 获取云盘空间的URL
	 */
	String URL_INFO = "https://pcs.baidu.com/rest/2.0/pcs/quota";
	/**
	 * 上传/下载/目录文件时的URL
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
	/**
	 * 获取文件夹目录的排序方式 time
	 */
	String BY_TIME ="time";
	/**
	 * v获取文件夹目录的排序方式 name
	 */
	String BY_NAME ="name";
	/**
	 * 获取文件夹目录的排序方式 size
	 */
	String BY_SIZE ="size";
}

