import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class TCPServer {

    public static void m1(){
        try{
            ServerSocket s = new ServerSocket(8080);
            ExecutorService executor = Executors.newFixedThreadPool(5);
            while(true) {
                System.out.println("Listening...");
                Socket socket = s.accept();
                System.out.println("Got connection");

                //we are going to spawn a worker thread asap
                ServerWorker sw = new ServerWorker(socket);
                executor.execute(sw);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
	// write your code here

        m1();

    }
}