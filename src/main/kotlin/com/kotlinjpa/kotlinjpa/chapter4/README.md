엔티티 클래스 제약 조건

* @Entity 적용 해야 함
* @Id 적용 해야 함
* 인자 없는 기본 생성자 필요
* 기본 생성자는 public이나 protected여야 함
  * 스펙상은 그런데, Hibernate의 경우 private도 사용 가능
* 최상위 클래스여야 함
* final이면 안됨

접근 타입

* 필드 접근: 필드 값을 사용해서 매핑
* 프로퍼티 접근: getter/setter 메서드를 사용해서 매핑
* @Id
  * 필드에 붙이면 필드 접근 방법
  * getter 메서드에 붙이면 프로퍼티 접근 방식 사용
  * @Access: 명시적으로 지정 가능