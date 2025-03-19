package org.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String COMMANDER_SERVER_ADDR = "localhost";
    String RTSP_SERVER_ADDR = "localhost";
    String CRLF = "\r\n";
    String CRLF2 = "\r\n\r\n";
    String sessionId = "";
    int COMMANDER_PORT = 8555;
    int RTSP_SERVER_PORT = 8554;
    List<Long> markerBitRecvTimes = new ArrayList<>();

    String optionsReq = "OPTIONS rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0" + CRLF
            + "User-Agent: ExoPlayerLib/2.17.1" + CRLF
            + "CSeq: 0" + CRLF2;

    String describeReq = "DESCRIBE rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0" + CRLF
            + "User-Agent: ExoPlayerLib/2.17.1" + CRLF
            + "CSeq: 1" + CRLF2;

    String setupFrontVideoReq = "SETUP rtsp://0.0.0.0:0/test/trackID=0 RTSP/1.0" + CRLF
            + "User-Agent: ExoPlayerLib/2.17.1" + CRLF
            + "CSeq: 2" + CRLF
            + "Transport: RTP/AVP/TCP;unicast;interleaved=0-1" + CRLF2;

    try(
            Socket socket = new Socket(COMMANDER_SERVER_ADDR, COMMANDER_PORT);
            PrintWriter commanderOut = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader commanderIn = new BufferedReader(new InputStreamReader(socket.getInputStream()))
    ) {
      // 커맨더 서버에 연결한 후, 시작 명령을 받을 때까지 대기한다.
      commanderOut.println("enter");
      System.out.println("Sent 'enter' message to server.");

      String serverMessage = commanderIn.readLine();
      if ("start".equalsIgnoreCase(serverMessage)) {
        // RTSP 스트리밍 서버에 재생 요청을 한다. 풀 스트리밍 모드로 요청해야 한다.
        // PLAY 요청에 대한 응답을 받은 직후로부터 별도의 타이머를 작동시킨다.
        Socket rtspSocket = new Socket(RTSP_SERVER_ADDR, RTSP_SERVER_PORT);
        DataInputStream rtspInputStream = new DataInputStream(new BufferedInputStream(rtspSocket.getInputStream()));

        rtspSocket.getOutputStream().write(optionsReq.getBytes());
        String optionsRes = "";
        while(true){
          byte[] buffer = new byte[1400];
          if(rtspInputStream.read(buffer) > 0){
            optionsRes = new String(buffer);
            break;
          }
        }
        if(!optionsRes.contains("RTSP/1.0 200 OK")){
          throw new RuntimeException("Options Req failed!");
        }

        rtspSocket.getOutputStream().write(describeReq.getBytes());
        String describeRes = "";
        while(true){
          byte[] buffer = new byte[1400];
          if(rtspInputStream.read(buffer) > 0){
            describeRes = new String(buffer);
            break;
          }
        }
        if(!describeRes.contains("RTSP/1.0 200 OK")){
          throw new RuntimeException("Describe Req failed!");
        }

        rtspSocket.getOutputStream().write(setupFrontVideoReq.getBytes());
        String setupFrontVideoRes = "";
        while(true){
          byte[] buffer = new byte[1400];
          if(rtspInputStream.read(buffer) > 0){
            setupFrontVideoRes = new String(buffer);
            break;
          }
        }
        if(!setupFrontVideoRes.contains("RTSP/1.0 200 OK")){
          throw new RuntimeException("Describe Req failed!");
        }
        String[] resLines = setupFrontVideoRes.split(CRLF);
        for(String elem : resLines){
          if(elem.startsWith("Session")){
            sessionId = elem.split(" ")[1];
          }
        }
        if(sessionId.equals("")){
          throw new RuntimeException("Failed to get session from server!");
        }

        // 첫 번째 SETUP 요청에 대한 응답 안에 Session ID가 포함돼 있다.
        // 두 번째 SETUP 요청에서부터는 서버에서 정해준 sessionId 값을 Session 헤더에 포함시켜야 한다.
        String setupRearVideoReq = "SETUP rtsp://0.0.0.0:0/test/trackID=2 RTSP/1.0" + CRLF
            + "User-Agent: ExoPlayerLib/2.17.1" + CRLF
            + "CSeq: 3" + CRLF
            + "Session: " + sessionId + CRLF
            + "Transport: RTP/AVP/TCP;unicast;interleaved=4-5" + CRLF2;

        String setupAudioReq = "SETUP rtsp://0.0.0.0:0/test/trackID=1 RTSP/1.0" + CRLF
            + "User-Agent: ExoPlayerLib/2.17.1" + CRLF
            + "CSeq: 4" + CRLF
            + "Session: " + sessionId + CRLF
            + "Transport: RTP/AVP/TCP;unicast;interleaved=2-3" + CRLF2;

        String playReq = "PLAY rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0" + CRLF
            + "User-Agent: ExoPlayerLib/2.17.1" + CRLF
            + "CSeq: 5" + CRLF
            + "Session: " + sessionId + CRLF
            + "Range: npt=0.000-" + CRLF
            + "PFrameControl: false" + CRLF
            + "ModelNo: SM-F926N" + CRLF
            + "Manufacturer: samsung" + CRLF2;

        String teardownReq = "TEARDOWN rtsp://0.0.0.0:0/enhypen-test-1cam-H RTSP/1.0" + CRLF
            + "User-Agent: ExoPlayerLib/2.17.1" + CRLF
            + "CSeq: 6" + CRLF
            + "Session: " + sessionId + CRLF2;

        rtspSocket.getOutputStream().write(setupRearVideoReq.getBytes());
        String setupRearVideoRes = "";
        while(true){
          byte[] buffer = new byte[1400];
          if(rtspInputStream.read(buffer) > 0){
            setupRearVideoRes = new String(buffer);
            break;
          }
        }
        if(!setupRearVideoRes.contains("RTSP/1.0 200 OK")){
          throw new RuntimeException("Describe Req failed!");
        }

        rtspSocket.getOutputStream().write(setupAudioReq.getBytes());
        String setupAudioRes = "";
        while(true){
          byte[] buffer = new byte[1400];
          if(rtspInputStream.read(buffer) > 0){
            setupAudioRes = new String(buffer);
            break;
          }
        }
        if(!setupAudioRes.contains("RTSP/1.0 200 OK")){
          throw new RuntimeException("Describe Req failed!");
        }

        rtspSocket.getOutputStream().write(playReq.getBytes());
        String playRes = "";
        while(true){
          byte[] buffer = new byte[1400];
          if(rtspInputStream.read(buffer) > 0){
            playRes = new String(buffer);
            break;
          }
        }
        if(!playRes.contains("RTSP/1.0 200 OK")){
          throw new RuntimeException("Describe Req failed!");
        }

        // marker bit이 0이 아닌 비디오 RTP 패킷을 받을 때마다 그 시각을 기록한다.
        // 테스트용.
        int cnt = 0;
        while(true){
          byte[] array = new byte[1400];
          int bytesRead = rtspInputStream.read(array);
          System.out.println(new String(array));
          cnt++;
          if(bytesRead < 0 || cnt > 3000) break;
        }

        Thread.sleep(1000);

        rtspSocket.getOutputStream().write(teardownReq.getBytes());

        // 타이머가 작동을 시작한지 35초가 되었다면, 스트리밍 서버에 PAUSE, TEARDOWN 요청을 보낸다.

        // 결과를 별도의 파일에 기록한다.


        commanderOut.println("done");
        System.out.println("Sent 'done' message to server.");
        rtspSocket.close();

        // 도커 컨테이너가 종료되지 않도록 무한 루프를 작동시킨다.
        // ... Docker Desktop을 이용해서 컨테이너를 강제종료시킬 때까지 대기한다.
        while(true){
          Thread.sleep(1000);
        }
      } else {
        System.out.println("Unexpected message from server: " + serverMessage);
      }

    } catch (Exception e){
      e.printStackTrace();
    }
  }//end of main
}//Main