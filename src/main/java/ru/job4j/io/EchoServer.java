package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String line = System.lineSeparator();
                    while ((str != null) && !(str.isEmpty())) {
                        System.out.println("Вывод :" + str);
                        out.write(("HTTP/1.1 200 OK" + line + line).getBytes());
                        if (str.contains("msg=Hello")) {
                            out.write(("Hello" + line).getBytes());
                            break;
                        } else if (str.contains("msg=Exit")) {
                            out.write(("Завершить работу сервера" + line).getBytes());
                            server.close();
                            break;
                        } else {
                            out.write(("What" + line).getBytes());
                            break;
                        }
                    }
                }
            } //cd C:\Tools\curl-7.76.0-win64-mingw\bin
        } //curl -i http://localhost:9000/?msg=Hello
    }
}
