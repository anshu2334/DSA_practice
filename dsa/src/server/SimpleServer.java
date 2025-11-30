package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            //server socket accept method is executed only once and can process only one client
            try(Socket socket = serverSocket.accept()) {
                //input and output stream will automatically get closed with socket connection will get closed
                System.out.println("Server accepted client connection");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                while(true){
                    String clientMessage = bufferedReader.readLine();
                    System.out.println("Server received request Data: "+clientMessage);
                    if(clientMessage.equalsIgnoreCase("exit")){
                        break;
                    }
                    output.println("Eco from server: "+clientMessage);
                }
            }
        } catch (IOException e) {
            System.out.println("server error:"+ e.getMessage());
        }
    }
}
