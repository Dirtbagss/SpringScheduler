# 🎉 Scheduler - 일정 관리 앱 만들기

## 📖 소개
Postman과 spring을 이용한 간단한 일정관라 앱입니다. 🤓

## 🛠️ 개발환경
- **IDE**: IntelliJ
- **DATABASE**: mySql
- **API**: Postman


## API 명세서
| **기능** | **Method** | **URL** | **request** | **response** | **상태코드** |
|------|------|------|------|------|------|
| 일정등록 | POST | /api/schedule     | {"userId" : userId;,"password" : password;,"content" : 'content';}     |  {"scheduleIdx": scheduleIdx,"userId" : userId,"content" : 'content';}    | 200: 정상등록 401: 등록실패    |
| 전체 일정조회 | GET | /api/schedule     | 요청 param     | 전체 응답 정보    | 200: 정상조회  402: 조회실패   |
| 선택 일정 상세조회 | GET | /api/schedule/scheduleIdx     | 요청 param     | {"sceduleIdx" : scheduleIdx ,"userId" : userId ,"content" : 'content',"reg_date" : "reg_date","update_date" : "update_date"}     | 200: 정상조회 402: 조회실패   |
| 선택일정수정 | PUT | /api/schedule/scheduleIdx    | {"scheduleIdx": scheduleIdx,"userId" : userId,"password" : "password", "content" : 'content';}     | {"sceduleIdx" : scheduleIdx ,"userId" : userId ,"content" : 'content',"reg_date" : "reg_date","update_date" : "update_date"}     | 200: 정상수정  403: 수정실패   |
| 선택일정삭제 | DELETE     | /api/schedule/scheduleIdx     |  {"scheduleIdx": scheduleIdx,"userId" : userId,"password" : "password", "content" : 'content';}     | -     | 200: 정상삭제  405: 삭제실패   |


## ERD
![image](https://github.com/user-attachments/assets/6b57dc0d-faa2-4254-86ce-f8545ed6aa08)




## SQL query
![image](https://github.com/user-attachments/assets/00045bd1-23e4-4f46-95da-8402d13a03b5)







## 📋 요구사항 정의
### - Lv 1. 일정 생성 및 조회 🔢
- []  
- []  

### - Lv 2. 일정 수정 및 삭제 🔢
- [] 
- [] 
  
### - Lv 3. 연관 관계 설정 🔢
- []  
- []  

### - Lv 4. 페이지네이션 🔢
- []
- []  
    
### - Lv 5. 예외 처리 🔢
- []  
- []  

### - Lv 6. null 체크 및 특정 패턴에 대한 검증 수행 🔢
- []  
- []  

## 🐞 Troubleshooting
1. 



## 📸 실행 결과


### 예외처리 결과
