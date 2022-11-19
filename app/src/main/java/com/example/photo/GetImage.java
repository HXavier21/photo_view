package com.example.photo;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetImage {
     /* 获取路径方法
     * @param path 路径
     * @return
     * @throws Exception
     */
    public static InputStream getImage(String path) throws Exception {
        // 从网络上获取图片--UUL对象用来封装路径
        URL url = new URL(path);
        // 打开路径链接---得到HttpURLConnection对象
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        // 通过HTTP协议请求网络图片---设置请求方式：get/post
        httpURLConnection.setRequestMethod("GET");
        // 设置连接超时
        httpURLConnection.setConnectTimeout(5 * 1000);
        // 从外界想手机应用内传递数据----通过输入流获取图片数据
        return httpURLConnection.getInputStream();
    }
}
/*源代码完全取自
 *https://blog.51cto.com/haiyuanxi/985769
 * 我自己做的工作似乎只有包括但不限于以下几条（原网站没有指导）：
 * 改layout文件
 * 改AndroidManifest.xml
 * 创建GetImage与StreamTool类
 * ...但这不能成为我真的不会的借口
 */

