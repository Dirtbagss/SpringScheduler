# 🎉 Scheduler - 일정 관리 앱 만들기

## 📖 소개
Postman과 spring을 이용한 간단한 일정관라 앱입니다. 🤓

## 🛠️ 개발환경
- **IDE**: IntelliJ
- **DATABASE**: mySql
- **API**: Postman


## API 명세서
| **기능** | **Method** | **URL** | **request** | **response** | **상태코드** |
|--------|------|------|------|------|------|
| 사용자등록 | POST | /api/user     | {"userName" : userName;,"email" : emai;}     |  {"userId": userId,"userName" : userName,"email" : 'email',"reg_date" : 'reg_date'}    | 200: 정상등록 401: 등록실패    |
| 일정등록 | POST | /api/schedule     | {"userId" : userId;,"password" : password;,"content" : 'content', "writer" : 'writer';}     |  {"scheduleIdx": scheduleIdx,"userId" : userId,"content" : 'content' "writer" : 'writer';}    | 200: 정상등록 401: 등록실패    |
| 전체 일정조회 | GET | /api/schedule     | 요청 param     | 전체 응답 정보    | 200: 정상조회  402: 조회실패   |
| 특정사용자 전체 일정조회 | GET | /user/{userId}     | 요청 param     | 전체 응답 정보    | 200: 정상조회  402: 조회실패   |
| 선택 일정 상세조회 | GET | /api/schedule/{scheduleId}     | 요청 param     | {"sceduleIdx" : scheduleIdx ,"userId" : userId ,"content" : 'content',"reg_date" : "reg_date","update_date" : "update_date"}     | 200: 정상조회 402: 조회실패   |
| 선택일정수정 | PUT | /api/schedule/{scheduleId}    | {"content" : 'content', "writer" : 'writer'}     | {"sceduleId" : scheduleId ,"userId" : userId ,"content" : 'content',"reg_date" : "reg_date","update_date" : "update_date"}     | 200: 정상수정  403: 수정실패   |
| 선택일정삭제 | DELETE     | /api/schedule/{scheduleId}     |  {password}     | - 1    | 200: 정상삭제  405: 삭제실패   |


## ERD
![image](https://github.com/user-attachments/assets/f513a2f4-a985-4ac8-aea8-99a6255f5dbe)





## SQL query
![image](https://github.com/user-attachments/assets/49b1a444-c1b4-429b-8c03-d19fac459c58)







## 📋 요구사항 정의
### - Lv 1. 일정 생성 및 조회 🔢
- [✅]  일정생성
- [✅]  전제일정 및 선택일정 조회

### - Lv 2. 일정 수정 및 삭제 🔢
- [✅]  선택한일정 수정
- [✅]  선택한일정 삭제
  
### - Lv 3. 연관 관계 설정 🔢
- [✅]  작성자와 일정의 연결
- [✅]  작성자 고유식별자로 일정조회 *외래키지정

### - Lv 4. 페이지네이션 🔢
- [❌]  페이지번호와 크기를 기준으로 모두조회
- [❌]  paging 객체 활용
    
### - Lv 5. 예외 처리 🔢
- [✅]  수정,삭제 비밀번호 미일치 할시 예외발생
- [✅]  선택한 일정을 조회할 수 없을 때 예외발생

### - Lv 6. null 체크 및 특정 패턴에 대한 검증 수행 🔢
- [❌]  유효성검사 @Valid 어노테이션 이용
- [❌]  할일 최대200자,필수값처리 ,비밀번호 필수값 처리, 이메일 형식확인

## 🐞 Troubleshooting
--


