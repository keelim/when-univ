package ServerTest;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;


public class MulticlientServer{
   private static int serverconnect_num = 0;
   // 유저 수에 따른 유저 접속 순서를 보내주는 서버는 만들었다.  --> 서버 가공을 할 것
    // 서버의 이슈 상태? 1. 게임을 구현을 하기 위한 서버의 기능 2. 접속자를 확인을 하는 서버의 기능? 3. 회원 가입의 기능을 넣는 것이 좋을 듯 하다.
    // 서버와 컴퓨터 간의 게임을 진행을 해야 한다. --> 이를 어떻게 구현을 하는 가?
    // 클라이언트에서 게임을 진행을 하고 그 결과를 서버로 전송만 하게 구현을 하자. --> 결과의 상태는 어떻게 구현을 하여야 하는가?
    //그러면 개발 하기는 훨씬 수월하다. 서버 쓰레드도 지속적 활용을 할 수 가 있다.
    //쓰레드 풀로 구현을 하여야 하는가?
   // 서버가 살아 있는를 구현을 하는 메소드를 작성을 하는 것이 좋을 것 같다.
   public static void main(String[] args )
   {  
      try
      {  
         int servernumi = 1;
         ServerSocket s = new ServerSocket(18069);
         ServerSocket s1 = new ServerSocket(1807);

         while (true)
         {
             System.out.println("서버를 시작을 합니다. ");
             System.out.println("접속을 기다리고 있습니다.");
            Socket incoming = s.accept();
            System.out.println("Spawning " + servernumi);
            Runnable r = new ThreadedEchoHandler(incoming, servernumi); // 새로운 쓰레드를 만들고 실행을 시키는 것이 안전하지 않는가?
            Thread t = new Thread(r);
            ++serverconnect_num;
            servernumi++;
            t.start();
            new Thread(() ->{
               Socket alive = null;
               try {
                  alive = s1.accept();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }).start();
            Thread.sleep(1000);
         }
      } catch (ConnectException e){
          System.out.println("소켓이 끊겼습니다. ");
          --serverconnect_num;
          System.out.println("프로그램을 종료 합니다. ");
          System.exit(1);
      } catch (SocketException e){
          System.out.println("소켓이 끊겼습니다. ");
          --serverconnect_num;
          System.out.println("프로그램을 종료 합니다. ");
          System.exit(1);

      } catch (IOException e)
      {  
         e.printStackTrace();
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
   }




}

class ThreadedEchoHandler implements Runnable
{
   private int alivenum = 1;
   public ThreadedEchoHandler(Socket i, int servernumi)
   { 
      incoming = i;
      integer = servernumi;

}
   private Socket incoming;
   private int integer;
   public void run()
   {  
      try
      {  
         try
         {
            OutputStream outStream = incoming.getOutputStream();
            PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);
            boolean isThread = true;
            while(isThread)
            {
               System.out.println(integer + "값을 보냅니다. ");
               out.println(integer);
            }
            new Thread(() -> {

            }).start();
         }
         finally
         {
            incoming.close();
         }
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }
}



