package com.uu.uploadFile;

import java.io.File;

import com.uu.uploadFile.HttpClientUtils.MultipartForm;

public class UploadFile {

	public static void main(String[] args) {
		// 创建HttpClientUtil实例
		HttpClientUtils httpClient = new HttpClientUtils();
		MultipartForm form = httpClient.new MultipartForm();
		// 设置form属性、参数
		form.setAction("http://192.168.1.107:8080/file/accept.do");
		form.addFileField("photo1", new File("F://1.jpg"));
		//form.addFileField("photo2", new File("F:/2.jpg"));

		form.addNormalField("tel", "15122946685");
		// 提交表单
		HttpClientUtils.submitForm(form);
	}

}
