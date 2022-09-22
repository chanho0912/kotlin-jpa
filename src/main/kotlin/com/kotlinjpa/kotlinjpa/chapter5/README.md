식별자 생성 방식

* 직접 할당
  * @Id 설정 대상에 직접 값 설정
  * 저장하기 전에 생성자 할당, 보통 생성 시점에 전달.
    * 사용자가 입력 한 값, 규칙에 따라 생성한 값
    * 저장하기 전에 생성자 할당, 보통 생성 시점에 전달
* 식별 칼럼 방식
  * DB가 식별자를 생성하므로 객체 생성시에 식별값을 설정하지 않음
  * @GeneratedValue(strategy = GenerationType.IDENTITY) 설정
  * Insert 쿼리를 실행해야 식별자를 알 수 있음.
    * EntityManager#persist() 호출 시점에 INSERT 쿼리 실행
    * persist() 실행할 때 객체에 식별자 값 할당됨.


* 시퀀스 사용 방식
  * JPA가 식별자 생성 처리 -> 객체 생성시에 식별값을 설정하지 않음
  * 설정 방식
    * @SequenceGenerator로 시퀀스 생성기 설정
    * GeneratedValue의 generator로 시퀀스 생성기 지정
    * EntityManager#persist() 호출 시점에 INSERT 쿼리 실행
      * persist() 실행할 때 객체에 식별자 값 할당됨.
      * Insert 쿼리는 이 시점에 호출되지 않음.


* 테이블 사용 방식