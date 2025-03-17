package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    String commanderServerAddr = "";
    String rtspServerAddr = "";
    List<Long> markerBitRecvTimes = new ArrayList<>();
    try {
      // 커맨더 서버로부터 시작 명령을 받을 때까지 대기한다.

      // RTSP 스트리밍 서버에 재생 요청을 한다. 풀 스트리밍 모드로 요청해야 한다.
      // PLAY 요청에 대한 응답을 받은 직후로부터 별도의 타이머를 작동시킨다.

      // marker bit이 0이 아닌 샘플을 받을 때마다 그 시각을 기록한다.

      // 타이머가 작동을 시작한지 35초가 되었다면, 스트리밍 서버에 TEARDOWN 요청을 보낸다.

      // 결과를 별도의 파일에 기록한다.

      // 도커 컨테이너가 종료되지 않도록 무한 루프를 작동시킨다.
      // ... Docker Desktop을 이용해서 컨테이너를 강제종료시킬 때까지 무한대기 한다.
      while(true){
        Thread.sleep(1000);
      }

    } catch (Exception e){
      e.printStackTrace();
    }
  }//end of main
}//Main