# 개요
해당 포스팅은 개발자의 시각에서 R을 설치/실행하여 익히는데 도움이 될만한 내용을 정리한 내용이다. 따라서 프로그래밍을 처음 접하는 사용자들을 위한 배경지식이 일부 생략되어있을 수는 있다. 하지만, R은 컴퓨터공학 비전공자들도 널리 사용하는 언어인 만큼 크게 어려운 내용은 없다. 앞으로도 꾸준히 R을 익히는데로 내용을 정리하여 포스팅 할 예정이다.

# 글의 방향성
 본글은 R의 모든 요소를 세세하게 설명하는 것이 아니라 **필요한 것만 빠르게 익히는고 다른것들은 나중에 찾아볼 수 있는 능력을 기르는데 목적이 있다.** 이유는 데이터마이닝/머신러닝이라는 목적성을 가지고 보통 R을 접할텐데 이분들이 언어를 시간을 쏟기보다는 데이터 모델링 등 보다 중요한 부분에 집중하는게 낫다고 생각한다. 따라서 독자들이 이 관점에서 조금이라도 도움이 되었으면 하기 때문이다.

# R 설치 및 실행
한국 사용자는 [미러링크](http://cran.nexr.com/) 참고하여 OS에 맞게 설치하면 된다. 주로 윈도우버전 사용자가 많은데 Installer로 설치하면 되므로 자세한 설명은 생략한다. 윈도우의 경우 바탕화면에 아이콘이 생기므로 32비트/64비트 원하는대로 실행하면 된다.

![](http://www.kwangsiklee.com/wp-content/uploads/2017/03/R실행.png)

# R관련 검색하기
개발자들이라면 R 관련해서 익힐때 한번에 모든것을 익히는 것 보다 레퍼런스를 찾는법을 익혀놓고 그때 그때 필요한 내용을 익히는 것이 효율적이다. 따라서 R관련 정보를 검색하는 방법을 정리한다.

## 로컬검색
R이 설치된 PC에서 메뉴얼, 패키지/함수 정보를 검색을 이용하는 방법이다.

### 로컬 메뉴얼 PDF
아래의 스크린샷과 같이 기본 설치된 R경로에 영문판 PDF로 메뉴얼이 들어있다. 필요시 참고하면 된다.

![](http://www.kwangsiklee.com/wp-content/uploads/2017/03/기본_메뉴얼_위치.png)

### R 도움말 검색
사용자 컴퓨터에 설치된 R 패키지 기반으로 검색시 사용한다. 로컬검색/온라인 검색 부분을 설명하지만  **__help함수와 rseek의 존재만 알아도 충분하다.__**

### 로컬 도움말 사이트 시작
아래와 같은 명령어로 로컬 도움말 사이트를 열어 볼 수 있다. 설치된 패키지 정보나 함수 정보를 찾아 볼 수 있다.

    > help.start()

![](http://www.kwangsiklee.com/wp-content/uploads/2017/03/help.start_.png)

### help 함수 사용법
아래와 같은 문법으로 커맨드라인에서 함수, 인자, 사용예제를 찾아 볼 수 있다.

    > help(function name) # 함수설명
    > args(funciton name) # 인자값 설명
    > example(function name) # 함수 사용예제

    > help(mean) # 웹브라우저 실행
    > args(mean) # 웹 브라우저 실행
    > example(mean) # 커맨드라인으로 떠서 편리함

    > help(adf.test, package="tseries") # 패키지의 함수 검색
    > help(package="zoo") # 패키지 검색

### help 함수의 단점
* 함수이름을 미리 알고 있어야 한다.
* 패키지가 설치되어 있더라도 load된 패키지가 아니면 검색이 안된다.

### help seearch 사용법
로드되지 않은 패키지도 검색할 수 있는 방법이다.

    > help.search("pattern")
    > help.search("adf.test")
    > help.search("dickey-fuller")

추가 문서화가 되어있는 패키지는 아래와 같이 **vignettes** 명령어로 자세한 정보를 검색 할 수 있다.

    > vignette(package="zoo")

### help, help.search 예약어
help와 help.search는 줄여서 ?, ??로 사용가능하다.

## 온라인 검색
온라인 사이트를 이용하여 R 관련 내용을 검색하는 방법이다.

### 온라인 검색 방법#1 : R Site search
R 공식사이트에서 관련된 정보를 검색하는 방법이다.
이런게 있다 정도만 알고있으면 되고 크게 도움이 되지는 않는다.

    # 사용문법
    > RSiteSearch("key phrase")

    # 사용예제
    > RSiteSearch("canonical correlation")

### 온라인 검색 방법#2 : rseek로 검색(추천)
"R"의 경우 너무 일반적인 단어라 구글 검색 결과에서 "R" 관련 정보 검색시 모호함이 있다. 그래서 진짜 "R"에 대한 정보를 편하게 찾을수 있게 구글검색을 커스터마이즈한 사이트이다.
[http://rseek.org/](http://rseek.org/)에서 검색하면 된다.

# 패키지 관리
R은 패키지로 모듈화 된어 이부분을 동적으로 load하여 사용하는 방식을 가진다. 로드된 패키지 확인, 패키지 설치, 패키지 로드 방법을 알아본다.

### 로드되어 있는 패키지 확인
현재 로드되어 있는 패키지가 어떤것이 있는지 확인한다.

    > search() # 로드된 패키지 검색시 아래와 같이 출력된다.
    [1] ".GlobalEnv"        "package:stats"     "package:graphics"
    [4] "package:grDevices" "package:utils"     "package:datasets"
    [7] "package:methods"   "Autoloads"         "package:base"

## 패키지 설치
CRAN 사이트로부터 의존성을 포함하여 패키지를 설치한다. OS에 관계없이 커맨드라인으로 설치가 가능하다. 윈도우 사용자라면 메뉴에서 설치를 할 수 있다.

    # 사용문법
    > install.packages("package name")

    # 사용예제
    > install.packages("tseries")

![](http://www.kwangsiklee.com/wp-content/uploads/2017/03/윈도우R설치.png)

## 패키지 로드
R은 패키지가 모듈화 되어있어 필요한 모듈은 동적으로 로드하여 사용한다. 아래의 예제에서는 **library** 함수를 이용한 로드방법이고 **require**도 있지만 크게 문제될 것은 없어 **library**롤 사용하는 방법만 익힌다.

    # 사용문법
    > library(package name)

    # 사용예제
    > library(tseries)

# 기초 맛보기
프로그래밍 익히기의 기초인 "hello world" 찍기는 보통 변수할당, 출력 등을 배우는 과정이다. 아래에서도 출력, 변수 할당 등을 R로 수행하는 방법을 익힌다.

## 출력하기
### 객체 출력
객체 자체를 커맨드로 입력하면 출력이 일어난다. print함수가 생략이 되어있는 형태라고 생각하면 된다.

    > pi
    [1] 3.141593
    > sqrt(2)
    [1] 1.414214

### 행렬 출력

    > print(matrix(c(1,2,3,4),2,2))
    [,1] [,2]
    [1,]    1    3
    [2,]    2    4

### 리스트 출력

    > print(list("a", "b", "c"))
    [[1]]
    [1] "a"

    [[2]]
    [1] "b"

    [[3]]
    [1] "c"

### 여러개를 한번에 출력
print는 인자를 한나만 받을수 있어 여러개를 concat할수 있다. 다만 type형을 인식하지 못하는 단점이 있어 개인적으로 앞으로 쓸일이 많을지는 의문이다.(현재 시점으로써는)

    > cat("abc", "def", "ghi\n")
    abc def ghi

## 변수 다루기
기본적인 변수를 다루는 방법에는 크게 어려울 것이 없다.

### 변수 할당
변수할당인 일반언어의 "=" 대신 "<-"를 쓴다는 점 빼고는 크게 어려울 것이 없다.

    > x <- 3
    > y <- 4
    > z <- sqrt(x^2+y^2)
    > print(z)
    [1] 5

### 타입 캐스팅
R은 인터프리터 언어라 같은 계열의 언어처럼 타입을 동적으로 자동 캐스팅한다.

    > x <- pi
    > print(x) # 숫자로 캐스팅 됨
    > x <- c("a", "b", "c")
    > print(c) # 문자로 캐스팅 됨

### 변수 확인하기
현재 할당되어 있는 변수를 확인한다.

    # 변수명만 보기
    > ls()

    # 변수, type, 값 확인하기
    > ls.str()

    # 변수 x의 값을 보고 싶을 때
    > x

### 변수 삭제

    # 변수 x 삭제
    > rm(x)

    # 모든 변수 다 지우기
    > rm(list=ls())

## 벡터 다루기
R을 쓰며 쓸일이 많은 벡터를 다루는 방법을 소개한다.

### c 오퍼레이터 사용
c 오퍼레레이터는 벡터로 데이터를 묶어준다. 당연한 얘기지만 대부분 같은 데이터 타입으로 벡터를 만든다.

    > c(1, 2, 3) # 숫자타입 벡터
    > c("a", "b", "c") # 문자타입 벡터
    > c(TRUE, TRUE, FALSE) # boolean 타입 벡터

v1, v2 벡터를 만들어 다시 하나의 벡터로 만든다.

    > v1 <- c(1, 2, 3)
    > v2 <- c(4, 5, 6)
    > c(v1, v2)
    [1] 1 2 3 4 5 6

### 순서형 데이터 벡터 생성

    > 1:5 # 1, 2, 3, 4, 5 벡터를 만든다.

    > seq(from=1, to=5) # 위와 동일하게 동작

    > seq(from=1, to=5, by=2) # 2씩 증가

    > seq(from=0, to=100, length.out=5) # 출력되는 값기준으로 5개만 출력함

    > rep(pi, times=5) #5회 반복

## mode와 class

필자의 의견은 아래 내용은 R을 익히고 활용하는 Fast Learner의 관점에서는 그리 중요치 않은것 같다.

mode는 물리적 저장type을 의미하고 class는 추상화된 type을 의미한다. 아래의 mode함수로 확인 할 수 있다. 여기서 벡터와 리스트의 차이가 발생하는데 아래와 같다.
* 벡터는 모든 요소의 mode가 반드시 같아야한다.
* 리스트는 각 요소가 mode가 달라도 관계없다.

      > mode(3.1415) # Mode of a number
      [1] "numeric"

      > mode(c(2.7182, 3.1415)) # Mode of a vector of numbers
      [1] "numeric"

      > mode("Moe") # Mode of a character string
      [1] "character"

      > mode(list("Moe","Larry","Curly")) # Mode of a list
      [1] "list"

재밌는 점은 Date로 저장하더라도 mode는 **numeric**으로 저장된다.

    > d <- as.Date("2010-03-15")
    > mode(d)
    [1] "numeric"
    > length(d)
    [1] 1

Class는 추상된 type으로써 mode와 다르게 **date**가 된다.

    > class(d)
    [1] "Date"