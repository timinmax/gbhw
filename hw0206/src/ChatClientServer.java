import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ChatClientServer {
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    boolean continueLoop = true;
    private Thread listenAndPrintThread;

    public ChatClientServer() {
        if (!openClientConnection()){
            try {
                openServerConnection();
            } catch (IOException e) {
                closeConnection();
                e.printStackTrace();
            }
        }


        listenAndPrintThread = new Thread(()->this.listenAndPrint());
        listenAndPrintThread.start();
        getInputAndSend();

        try {
            listenAndPrintThread.join();
        }catch (InterruptedException e){
            System.out.println("Соединение прервано.");
        }finally {
            closeConnection();
        }



    }

    private void listenAndPrint(){
        try {
            while (this.continueLoop) {
                String str = this.in.readUTF();
                if (str.equals("/end")) {
                    this.continueLoop = false;
                    break;
                }
                System.out.println(str);
            }
            closeConnection();
            System.exit(0);
        }catch (IOException e){
            System.out.println("Соединение прервано.");
        }
    }

    private void getInputAndSend(){
        try {
            Scanner scanner = new Scanner(System.in);
            while (this.continueLoop) {
                String str = scanner.next();
                out.writeUTF(str);
                this.continueLoop = !str.equals("/end");
            }
            closeConnection();
        }catch (IOException e){
            System.out.println("Соединение прервано.");
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
        if (listenAndPrintThread != null){
            listenAndPrintThread.interrupt();
        }
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
