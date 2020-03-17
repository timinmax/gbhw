import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class ChatClientServer {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;
    boolean continueLoop = true;


    public ChatClientServer() {
        if (!openClientConnection()){
            try {
                openServerConnection();
            } catch (IOException e) {
                closeConnection();
                e.printStackTrace();
            }
        }


        Thread T1 = new Thread(()->this.listenAndPrint());
        Thread T2 = new Thread(()->this.getInputAndSend());

        T1.start();
        T2.start();

        try {
            T1.join();
            T2.join();
            closeConnection();
        }catch (InterruptedException e){
            e.printStackTrace();
            closeConnection();
        }



    }

    private void listenAndPrint(){
        try {
            while (this.continueLoop) {
                String str = this.in.readUTF();
                if (str.equals("/end")) {
                    this.continueLoop = false;
                    out.writeUTF(str);
                    break;
                }
                System.out.println(str);
            }
        }catch (IOException e){
            closeConnection();
            e.printStackTrace();
        }
    }

    private void getInputAndSend(){
        try {
            while (this.continueLoop) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                out.writeUTF(str);
                this.continueLoop = !str.equals("/end");

            }
        }catch (IOException e){
            closeConnection();
            e.printStackTrace();
        }
    }

    public void openServerConnection() throws IOException{
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Сервер запущен, ожидаем подключения...");
        socket = serverSocket.accept();
        System.out.println("Клиент подключился");
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }

    public boolean openClientConnection(){
        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            return true;
        }catch (IOException e){
            return false;
        }

    }

    public void closeConnection() {
        this.continueLoop = false;
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
