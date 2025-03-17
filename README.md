# RTSP 스트리밍 서버 성능 테스트용 Fake 클라이언트

## 측정 방식
- RTP 패킷의 marker bit 기록
  - marker bit이 0이 아니라면, 현재의 RTP 패킷이 해당 패킷이 속해 있는 샘플을 구성하고 있는 모든 RTP 패킷들 중에서 가장 마지막에 존재하는 RTP 패킷임을 뜻합니다.
  - marker bit이 0이 아닌 비디오 패킷을 수신할 때마다 그 시각을 밀리초 단위의 정확도로 기록합니다.
  - fps 30의 비디오라면, marker bit 가 0이 아닌 RTP 패킷을 받는 간격이 33 밀리초를 초과하지 않아야 합니다.
- 재생 불량 판단 기준
  - 가장 최근에 marker bit를 수신한 시각과 현재의 marker bit를 수신한 시각 간의 차이가 33 밀리초를 초과하는 경우가 단 한 번이라도 발생하면 재생 불량으로 판단합니다. 

## 성능테스트용 컨텐츠 특성
- bitrate : 23.3 Mbps 
- video sample cnt : front video 900, rear video 900
- playtime : 30 sec
- fps : 30