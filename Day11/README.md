## shell 만들기
- [ ] ~~구현 실패~~
- [x] 구현완료

**결국 해냈다!!**


~~무엇을 해야 할 지 감도 안잡힌다.~~


`Runtime.getRuntime().exec(//명령 ex) cmd /c dir);`

위와 같이 이해도 되지 않는 것을 구글링해서 해봤으나 어떻게 되는건지 전혀 모르겠다..
조급하게 하지 말고 천천히 생각해보자.


David 조교님이 keyword로 ProcessBuilder 에 대해 알려주셨다.


ProcessBuilder 를 통해 cmd를 실행해서 copy, dir, rmdir, mkdir 등을 사용했고 cd 나 pwd 같은 기능은 직접 구현했다.


## 한글 시계 구현

- [x] 구현 완료
- [x] 색을 넣은 시계 구현 완료
- [x] 달력 구현 완료


David님이 색을 넣어보는 것은 어떻겟냐고 하셔서 Jarry 님의 도움 하에 색을 넣는 것까지 구현 완료했다. 



**구현 방법**


쓰레드를 통해 10초마다 시간을 받아 출력되게 했다.


현재시간은 Java의 LocalTime을 활용했다.


2차원 배열을 통해 만들어 그냥 하드코딩 했다.


사실 이 방법이 하드코딩같지만 한글시계를 만드는 가장 최적의 방법같긴 하다.


window의 cmd에서는 글자에 색을 넣는것이 불가능해서 git bash를 통해 색을 입혔다.


~~메인 메소드가 너무 난잡하다. 설계가 이상한 것 같기는 하다.~~

땃쥐의 코드를 참고하여 메인쓰레드 하나만을 이용하기 때문에 그냥 `Thread.sleep()`을 사용하면 된다는 것을 깨닫고 코드를 수정했다.
main 문이 이전에 비해서 간단해졌다.


달력은 LocalDate를 사용했다.


달력 기능이 추가되다 보니 달력과 시간 중 선택해야 하는 메뉴 기능이 필요해졌다.


시간은 쓰레드를 통해 특정 시간마다 계속 무한루프를 돌리고 있다. 이 쓰레드 중간에 interrupted를 통해 중지시킨 후 메뉴 기능으로 빠져 나오는 것이 필요해졌다.
-> **구현완료!!!!**


~~메인 클래스는 더 복잡해졌다... 구현 한 게 어디냐..~~


메인 클래스와 메뉴 클래스로 분리했다.