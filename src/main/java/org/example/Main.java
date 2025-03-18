package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String commanderServerAddr = "";
    String rtspServerAddr = "";
    int port = 8554;
    List<Long> markerBitRecvTimes = new ArrayList<>();
    try {
      // 커맨더 서버에 연결한 후, 시작 명령을 받을 때까지 대기한다.

      // RTSP 스트리밍 서버에 재생 요청을 한다. 풀 스트리밍 모드로 요청해야 한다.
      // PLAY 요청에 대한 응답을 받은 직후로부터 별도의 타이머를 작동시킨다.

      // marker bit이 0이 아닌 샘플을 받을 때마다 그 시각을 기록한다.

      // 타이머가 작동을 시작한지 35초가 되었다면, 스트리밍 서버에 PAUSE, TEARDOWN 요청을 보낸다.

      // 결과를 별도의 파일에 기록한다.

      // 도커 컨테이너가 종료되지 않도록 무한 루프를 작동시킨다.
      // ... Docker Desktop을 이용해서 컨테이너를 강제종료시킬 때까지 대기한다.
      while(true){
        Thread.sleep(1000);
      }

    } catch (Exception e){
      e.printStackTrace();
    }
  }//end of main
}//Main

/*
RTSP 트랜잭션 로그

2025-03-18 09:37:09 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:09 [INFO] RtspHandler: OPTIONS rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0
2025-03-18 09:37:09 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:09 [INFO] RtspHandler: CSeq: 0

2025-03-18 09:37:09 [WARNING] Session: Dongvin, requested content : enhypen-test-1cam-H, session id : 1_746REBVf
2025-03-18 09:37:09 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:09 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:09 [INFO] Session: CSeq: 0
2025-03-18 09:37:09 [INFO] Session: Public: DESCRIBE,SETUP,PLAY,PAUSE,TEARDOWN,SET_PARAMETER,OPTIONS
2025-03-18 09:37:09 [INFO] Session: Server: alphaStreamer-3.1/1.0.0




2025-03-18 09:37:09 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:09 [INFO] RtspHandler: DESCRIBE rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0
2025-03-18 09:37:09 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:09 [INFO] RtspHandler: CSeq: 1

2025-03-18 09:37:09 [INFO] RtspHandler: Dongvin, id : 1_746REBVf, rtsp response:
2025-03-18 09:37:09 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:09 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:09 [INFO] Session: CSeq: 1
2025-03-18 09:37:09 [INFO] Session: Content-Base: rtsp://0.0.0.0:0/test/
2025-03-18 09:37:09 [INFO] Session: Content-Length: 904
2025-03-18 09:37:09 [INFO] Session: Content-Type: application/sdp
2025-03-18 09:37:09 [INFO] Session: Server: alphaStreamer-3.1/1.0.0
2025-03-18 09:37:09 [INFO] Session: v=0
2025-03-18 09:37:09 [INFO] Session: o=- 0 0 IN IP4 127.0.0.1
2025-03-18 09:37:09 [INFO] Session: s=No Name
2025-03-18 09:37:09 [INFO] Session: c=IN IP4 0.0.0.0
2025-03-18 09:37:09 [INFO] Session: t=0 0
2025-03-18 09:37:09 [INFO] Session: m=video 0 RTP/AVP 96
2025-03-18 09:37:09 [INFO] Session: b=AS:14935
2025-03-18 09:37:09 [INFO] Session: a=rtpmap:96 H265/90000
2025-03-18 09:37:09 [INFO] Session: a=fmtp:96 sprop-vps=QAEMAf//AUAAAAMAkAAAAwAAAwC0lwJA; sprop-sps=QgEBAUAAAAMAkAAAAwAAAwC0oAHgIAPAWWXSkIRkX/jAQEAAAPpAAB1MGAF3lEAAHP3gAADn7wE=; sprop-pps=RAHAk3wMyQ==;streamType=4;dGop=60;ucnt=3003
2025-03-18 09:37:09 [INFO] Session: a=control:rtsp://0.0.0.0:0/test/trackID=0
2025-03-18 09:37:09 [INFO] Session: m=audio 0 RTP/AVP 97
2025-03-18 09:37:09 [INFO] Session: b=AS:320
2025-03-18 09:37:09 [INFO] Session: a=rtpmap:97 MPEG4-GENERIC/48000/2
2025-03-18 09:37:09 [INFO] Session: a=fmtp:97 profile-level-id=1;mode=AAC-hbr;sizelength=13;indexlength=3;indexdeltalength=3; config=119056E500;streamType=5;ucnt=1024
2025-03-18 09:37:09 [INFO] Session: a=control:rtsp://0.0.0.0:0/test/trackID=1
2025-03-18 09:37:09 [INFO] Session: m=video 0 RTP/AVP 96
2025-03-18 09:37:09 [INFO] Session: b=AS:8231
2025-03-18 09:37:09 [INFO] Session: a=rtpmap:96 H265/90000
2025-03-18 09:37:09 [INFO] Session: a=fmtp:96 sprop-vps=QAEMAf//AUAAAAMAkAAAAwAAAwCWlwJA; sprop-sps=QgEBAUAAAAMAkAAAAwAAAwCWoAPAgA8BZZe5CEZF/4wEBAAAD6QAAdTBgBd5RAABA2YAAAgbMhA=; sprop-pps=RAHAk3wMyQ==;streamType=4;dGop=60;ucnt=3003
2025-03-18 09:37:09 [INFO] Session: a=control:rtsp://0.0.0.0:0/test/trackID=2




2025-03-18 09:37:09 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:09 [INFO] RtspHandler: SETUP rtsp://0.0.0.0:0/test/trackID=0 RTSP/1.0
2025-03-18 09:37:09 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:09 [INFO] RtspHandler: CSeq: 2
2025-03-18 09:37:09 [INFO] RtspHandler: Transport: RTP/AVP/TCP;unicast;interleaved=0-1

2025-03-18 09:37:09 [INFO] RtspHandler: Dongvin, setup stream id : 0
2025-03-18 09:37:09 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:09 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:09 [INFO] Session: CSeq: 2
2025-03-18 09:37:09 [INFO] Session: Server: alphaStreamer-3.1/1.0.0
2025-03-18 09:37:09 [INFO] Session: Session: 1_746REBVf
2025-03-18 09:37:09 [INFO] Session: RefVideoSampleCnt: 900
2025-03-18 09:37:09 [INFO] Session: camDirectoryCnt: 1
2025-03-18 09:37:09 [INFO] Session: Transport: RTP/AVP/TCP;unicast;interleaved=0-1;ssrc=840603287




2025-03-18 09:37:09 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:09 [INFO] RtspHandler: SETUP rtsp://0.0.0.0:0/test/trackID=2 RTSP/1.0
2025-03-18 09:37:09 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:09 [INFO] RtspHandler: CSeq: 3
2025-03-18 09:37:09 [INFO] RtspHandler: Session: 1_746REBVf
2025-03-18 09:37:09 [INFO] RtspHandler: Transport: RTP/AVP/TCP;unicast;interleaved=4-5

2025-03-18 09:37:09 [INFO] RtspHandler: Dongvin, setup stream id : 2
2025-03-18 09:37:09 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:09 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:09 [INFO] Session: CSeq: 3
2025-03-18 09:37:09 [INFO] Session: Server: alphaStreamer-3.1/1.0.0
2025-03-18 09:37:09 [INFO] Session: Session: 1_746REBVf
2025-03-18 09:37:09 [INFO] Session: RefVideoSampleCnt: 900
2025-03-18 09:37:09 [INFO] Session: camDirectoryCnt: 1
2025-03-18 09:37:09 [INFO] Session: Transport: RTP/AVP/TCP;unicast;interleaved=4-5;ssrc=840603287




2025-03-18 09:37:09 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:09 [INFO] RtspHandler: SETUP rtsp://0.0.0.0:0/test/trackID=1 RTSP/1.0
2025-03-18 09:37:09 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:09 [INFO] RtspHandler: CSeq: 4
2025-03-18 09:37:09 [INFO] RtspHandler: Session: 1_746REBVf
2025-03-18 09:37:09 [INFO] RtspHandler: Transport: RTP/AVP/TCP;unicast;interleaved=2-3

2025-03-18 09:37:09 [INFO] RtspHandler: Dongvin, setup stream id : 1
2025-03-18 09:37:09 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:09 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:09 [INFO] Session: CSeq: 4
2025-03-18 09:37:09 [INFO] Session: Server: alphaStreamer-3.1/1.0.0
2025-03-18 09:37:09 [INFO] Session: Session: 1_746REBVf
2025-03-18 09:37:09 [INFO] Session: RefVideoSampleCnt: 900
2025-03-18 09:37:09 [INFO] Session: camDirectoryCnt: 1
2025-03-18 09:37:09 [INFO] Session: Transport: RTP/AVP/TCP;unicast;interleaved=2-3;ssrc=1818371236




2025-03-18 09:37:09 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:09 [INFO] RtspHandler: PLAY rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0
2025-03-18 09:37:09 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:09 [INFO] RtspHandler: CSeq: 5
2025-03-18 09:37:09 [INFO] RtspHandler: Session: 1_746REBVf
2025-03-18 09:37:09 [INFO] RtspHandler: Range: npt=0.000-
2025-03-18 09:37:09 [INFO] RtspHandler: PFrameControl: false
2025-03-18 09:37:09 [INFO] RtspHandler: ModelNo: SM-F926N
2025-03-18 09:37:09 [INFO] RtspHandler: Manufacturer: samsung

2025-03-18 09:37:09 [INFO] Session: Dongvin, cid: , play starting point : 0.000000,-1.000000 (sec)
2025-03-18 09:37:09 [INFO] AcsHandler: Dongvin, init read info completed. streamId : 1
2025-03-18 09:37:10 [INFO] AcsHandler: Dongvin, init read info completed. streamId : 0
2025-03-18 09:37:10 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:10 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:10 [INFO] Session: CSeq: 5
2025-03-18 09:37:10 [INFO] Session: RTP-Info: url=rtsp://0.0.0.0:0/test/trackID=0;rtptime=1190724247;lsnum=899,url=rtsp://0.0.0.0:0/test/trackID=1;rtptime=88603330;lsnum=1406,url=rtsp://0.0.0.0:0/test/trackID=2;rtptime=1190724247;lsnum=899
2025-03-18 09:37:10 [INFO] Session: Server: alphaStreamer-3.1/1.0.0
2025-03-18 09:37:10 [INFO] Session: Session: 1_746REBVf
2025-03-18 09:37:10 [INFO] Session: SupportingBitrate: 23.486000
2025-03-18 09:37:10 [INFO] Session: CamDirectoryCnt: 1




2025-03-18 09:37:35 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:35 [INFO] RtspHandler: PAUSE rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0
2025-03-18 09:37:35 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:35 [INFO] RtspHandler: CSeq: 15
2025-03-18 09:37:35 [INFO] RtspHandler: Session: 1_746REBVf

2025-03-18 09:37:35 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:35 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:35 [INFO] Session: CSeq: 15
2025-03-18 09:37:35 [INFO] Session: Server: alphaStreamer-3.1/1.0.0




2025-03-18 09:37:35 [WARNING] RtspHandler: Dongvin, 1_746REBVf, rtsp req:
2025-03-18 09:37:35 [INFO] RtspHandler: TEARDOWN rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0
2025-03-18 09:37:35 [INFO] RtspHandler: User-Agent: ExoPlayerLib/2.17.1
2025-03-18 09:37:35 [INFO] RtspHandler: CSeq: 16
2025-03-18 09:37:35 [INFO] RtspHandler: Session: 1_746REBVf

2025-03-18 09:37:35 [WARNING] Session: Dongvin, 1_746REBVf, rtsp response:
2025-03-18 09:37:35 [INFO] Session: RTSP/1.0 200 OK
2025-03-18 09:37:35 [INFO] Session: CSeq: 16
2025-03-18 09:37:35 [INFO] Session: Server: alphaStreamer-3.1/1.0.0
2025-03-18 09:37:35 [INFO] Session: Teardown: true

*/

/*
커맨더 서버 코드
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    private static final int PORT = 8554;
    private static final int TARGET_COUNT = 2;
    private static int count = 0;
    private static List<Socket> clients = new ArrayList<>();
    private static ExecutorService threadPool = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started and waiting for clients. Target Client Count: " + TARGET_COUNT);

            // Accept clients until TARGET_COUNT is reached
            while (count < TARGET_COUNT) {
                Socket clientSocket = serverSocket.accept();
                synchronized (clients) {
                    clients.add(clientSocket);
                }
                threadPool.submit(() -> handleClient(clientSocket));
                count++;
            }

            // Once TARGET_COUNT is reached, send "start" message to all clients
            System.out.println("Target count reached. Sending 'start' to all clients.");
            sendStartMessageToAllClients();

            // Keep the server running
            while (true) {
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Wait for "enter" message
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("enter")) {
                    System.out.println("Received 'enter' from client. Current count: " + count);
                    break;
                }
            }

            // Keep the connection open until the client sends "done"
            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("done")) {
                    System.out.println("Client task completed.");
                    break;
                }
            }

            // Close resources after client is done
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendStartMessageToAllClients() {
        synchronized (clients) {
            for (Socket client : clients) {
                try {
                    PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                    out.println("start");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



커맨더 서버용 클라이언트 코드
import java.io.*;
import java.net.*;

public class Main {
  private static final String SERVER_ADDRESS = "52.78.207.125"; // Replace with actual server address
  private static final int SERVER_PORT = 8554;

  public static void main(String[] args) {
    Runnable task = Main::clientForCommanderServer;
    new Thread(task).start();
    new Thread(task).start();

    while(true){}
  }

  private static void clientForCommanderServer() {
    try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      // Step 1: Notify the server that this client has connected
      out.println("enter");
      System.out.println("Sent 'enter' message to server.");

      // Step 2: Wait for "start" command from the server
      String serverMessage = in.readLine();
      if ("start".equalsIgnoreCase(serverMessage)) {
        System.out.println("Received 'start' command from server. Beginning task...");

        // Simulate task execution
        Thread.sleep(3000); // Simulate work being done (3 sec)

        // Step 3: Notify server of completion
        out.println("done");
        System.out.println("Sent 'done' message to server.");
      } else {
        System.out.println("Unexpected message from server: " + serverMessage);
      }
    } catch (IOException | InterruptedException e) {
      System.err.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
  }
}
*/