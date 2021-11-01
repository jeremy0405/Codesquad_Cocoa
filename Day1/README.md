
# Day1

### 미션 1 목표
- [ ] **조건문, 반복문, 함수의 학습**
- [ ] **-   IDE에 익숙해지기**
- [ ] **-   코드스쿼드에 익숙해지기**
- [ ] **-   멤버들과 친해지기**

______

### 조건문, 반복문, 함수의 학습
- 조건문 (if, switch)
```java
if( 조건 ) {
	//실행할 명령
	//실행할 명령이 하나라면 { } 생략 가능
} else if (조건) {
	//명령
} else {
	//명령
}
```

```java
switch (조건 ) {
	case 값 1 :
		// 명령1
		// 명령2
		break;
	case 값 2 :
		// 명령1
		// 명령2
		break;
	default :
		// 조건과 일치하는 결과가 없을 때
		// 명령1
}
```

- 반복문 (for, while)
```java
for(int i = 0; i < 10; i++){
	//명령
}
```
```java
//for each 문
int[] arr = {10, 20, 30, 40}
for(int tmp : arr){
	System.out.println(tmp);
}
```
결과 :
10
20
30
40
```java
int i = 1;
while(i < 10){
	//명령1
	i++;
}
```

- 함수
java에서 메소드가 함수의 역할을 한다.
```java
반환타입 메서드명 (타입 변수명, 타입 변수명, ...)
{
	//메서드 호출 시 실행될 명령
}

int add(int a, int b)
{
	return a + b;
}
```


___
### Markdown 문법

```
# 제목 1단계
## 제목 2단계
#### 제목 4단계
##### 제목 5단계
###### 제목 6단계 
```
>예시
># 제목 1단계
>## 제목 2단계
>#### 제목 4단계
>##### 제목 5단계
>###### 제목 6단계

___

```
<!-- 주석 -->
```
<!-- 주석 -->
___
```
**strong text**
*emphasized text*
***strong & emphasized text***
~~strikethrough text~~
<u>underline<u>

```

>**strong text**
>*emphasized text*
>***strong & emphasized text***
>~~strikethrough text~~
><u>underline<u>
___
```
1. 첫번째
1. 두번째
1. 세번째
  
+ 순서없음
    - 홍길동
      * 중대장
        + 프로실망러
```

1. 첫번째
1. 두번째
1. 세번째
  
+ 순서없음
    - 홍길동
      * 중대장
        + 프로실망러
___

```
유형1 [TheoryDB 블로그](https://theorydb.github.io "마우스를 올려놓으면 말풍선이 나옵니다.")  
유형2(URL 보여주고 `자동연결`) : <https://theorydb.github.io>  
유형3(동일 파일 내 `문단 이동`) : [동일파일 내 문단 이동](#markdown의-반드시-알아야-하는-문법)
```

>유형1 [Jhrock Blog](https://jeremy0405.github.io "말풍선 설정")
>유형2 <https://jeremy0405.github.io>
>유형3 [동일파일 내 문단 이동(Markdown 문법)](#markdown-문법)

```
동일파일 내 문단이동 방법 
1) `특수문자`제거  
2) 스페이스를 갯수만큼 `-`로 변경  
3) 대문자->`소문자`로 변경  
예) “#Markdown! 장점” -> “#markdown–장점”
무조건 # 하나만 써야 됨
```


[참고자료](https://theorydb.github.io/envops/2019/05/22/envops-blog-how-to-use-md/#markdown-%EB%AC%B8%EB%B2%951%EB%B0%98%EB%93%9C%EC%8B%9C-%EC%95%8C%EC%95%84%EC%95%BC-%ED%95%98%EB%8A%94)

