package com.example.photo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class StreamTool {
    public static byte[] readInputStream(InputStream inSream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 定义一个缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        // 不断的从流里读取数据---while循环---nSream.read(buffer)表示从流里读取数据到缓冲区
        // 读取到末尾时，返回值是-1；
        while ((len = inSream.read(buffer)) != -1) {
        // 将缓冲区的数据写到输出流中
            byteArrayOutputStream.write(buffer, 0, len);
        }
        inSream.close();
        return byteArrayOutputStream.toByteArray();
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
