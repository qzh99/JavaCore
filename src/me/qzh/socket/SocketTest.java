package me.qzh.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author qinzhenghua
 * @version 1.5
 * @since 2021/3/5 18:03
 */
public class SocketTest {
    @Test
    public void client() throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("old.png"));
        byte[] buffer = new byte[1024];

        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        socket.shutdownOutput();

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        InputStream is = socket.getInputStream();
        byte[] inBuffer = new byte[1024];
        int inLen;
        while ((inLen = is.read(inBuffer)) != -1) {
            bos.write(inBuffer, 0, inLen);
        }

        System.out.println(bos.toString());

        is.close();
        bos.close();
        fis.close();
        os.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("copy.png"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer,0,len);
        }

        OutputStream os = socket.getOutputStream();
        os.write("文件已收到".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();

    }
}
