# MultiChattingSerialize
직렬화를 통한 멀티채팅

직렬화 프로그램 서버 , 클라이언트 각각 다른곳에서 실행할때 주의할점!!
1. 직렬화 시키려는 객체 .class 파일의 UID가 다르면 안된다.
2. 클래스는 패키지에 종속적이다. 직렬화 시키려는 패키지 또한 같아야 한다.
