package system.socket;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketServerForClient implements Runnable{
    private Socket client;
    private Text algorithm ;
    private TextArea ciphertext ;
    private TextField key ;
    private boolean threadStop = false;

    public boolean isThreadStop() {
        return threadStop;
    }

    public void setThreadStop(boolean threadStop) {
        this.threadStop = threadStop;
    }

    public SocketServerForClient(Socket client, Text algorithm, TextArea ciphertext, TextField key) {
        this.client = client;
        this.algorithm = algorithm;
        this.ciphertext = ciphertext;
        this.key = key;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true){
                if(threadStop)
                    break;

                //读取客户端数据
                System.out.println("开始读入客户端数据");
                algorithm.setText(in.readUTF());
                ciphertext.setText(in.readUTF());
                key.setText(in.readUTF());
                String clientInputStr = in.readUTF();
                if("DISCONNECT".equals(clientInputStr)){
                    System.out.println("客户端已断开连接");
                    Thread.sleep(500);
                    break;
                }
            }
            out.close();
            in.close();
            client.close();
            System.gc();//回收垃圾
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
                try {
                    if (client != null)
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
