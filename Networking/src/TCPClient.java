import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

    public static void m2() {
        try {
            InetAddress address = InetAddress.getByName("localhost");
            System.out.println("Going to connect now ");
            int numClients = 10;


            for(int i=0;i<numClients;i++){
                Socket client = new Socket(address,8080);
                System.out.println("Connected");
                OutputStream os = client.getOutputStream();
                InputStream is = client.getInputStream();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String [] args){
        m2();
    }

}
