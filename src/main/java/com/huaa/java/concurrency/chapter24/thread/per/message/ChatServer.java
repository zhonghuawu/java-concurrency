package com.huaa.java.concurrency.chapter24.thread.per.message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * Desc:
 *
 * @author wu_zh
 * @date 2019/7/15 22:34
 */
public class ChatServer {
    private final int port;
    private ExecutorService executor;
    private ServerSocket serverSocket;

    public ChatServer(int port) {
        this.port = port;
    }

    public ChatServer() {
        this(13312);
    }

    public void startServer() throws IOException {
        this.executor = new ThreadPoolExecutor(1, 4,
                0, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1000),
                r -> new Thread(r, "chat-service-"));
        this.serverSocket = new ServerSocket(port);
        this.serverSocket.setReuseAddress(true);
        System.out.println("Chat server is started and listen at port: " + port);
        this.listen();
    }

    private void listen() throws IOException {
        for(;;) {
            Socket client = serverSocket.accept();
            this.executor.execute(new ClientHandler(client));
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().startServer();
    }
}
