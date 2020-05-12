import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;

public class ServerWorker extends Thread{

    private Socket socket;
    private Random rnd;

    public ServerWorker(Socket socket) {
        this.socket = socket;
        this.rnd = new Random();
    }

    @Override
    public void run() {
        //use socket for comms
        System.out.println("We are working in parallel");
        try {
            OutputStream os = this.socket.getOutputStream();
            InputStream is = this.socket.getInputStream();
            sleep(rnd.nextInt(10)*1000);
            System.out.println("Finish...");
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
