
# REST API URL 설계

먼저 사용자에게 필요한 기능들은 위와 같이 간략하게 정리하였다.

이제 실제 Schema와 함께 예시 URL을 작성하려 한다.

먼저 아직 수정중이긴 하지만 DB Schema는 아래와 같다.

![](https://images.velog.io/images/gillog/post/b93d0a1d-7b5b-4f9a-9bea-be206b1a95d1/image.png)
_ 아 너무 작은데 ㅋㅋ _

## Main

### 자격증 목록 / 정보 (GET)

```python
GET api.ddaja.com/licenses 

HTTP/1.1 200 OK
Link: 
 <https://api.ddaja.com/licenses?offset=10&limit=10>; rel="next"
, <https://api.ddaja.com/licenses?offset=50&limit=10>; rel="last"
, <https://api.ddaja.com/licenses?offset=0&limit=10>; rel="first"
, <https://api.ddaja.com/licenses?offset=0&limit=0>; rel="prev"
{
    "licenses": [
    	{
            "license": {
                "seq": 1
                , "name": "정보처리기사"
                , "ins_date": "2021-05-30"
                , "agency": "Q-Net"
                , "pass_score": 70
            }
        }
        , {
            "license": {
                "seq": 2
                , "name": "빅데이터기사"
                , "ins_date": "2021-04-29"
                , "agency": "Q-Net"
                , "pass_score": 70
            }
        }
        , {
            "license": {
                "seq": 3
                , "name": "컴퓨터활용능력1급"
                , "ins_date": "2021-05-10"
                , "agency": "Q-Net"
                , "pass_score": 70
            }
        }
        , ...
    ]
}

GET api.ddaja.com/licenses/1

HTTP/1.1 200 OK
{
    "license": {
        "seq": 1
        , "name": "정보처리기사"
        , "ins_date": "2021-04-29"
        , "agency": "Q-Net"
        , "pass_score": 70
    }
}

GET api.ddaja.com/licenses/subjects

HTTP/1.1 200 OK
Link: 
 <https://api.ddaja.com/licenses/subjects?offset=10&limit=10>; rel="next"
, <https://api.ddaja.com/licenses/subjects?offset=50&limit=10>; rel="last"
, <https://api.ddaja.com/licenses/subjects?offset=0&limit=10>; rel="first"
, <https://api.ddaja.com/licenses/subjects?offset=0&limit=0>; rel="prev"
{
    "licenses": [
    	{
            "license": {
                "seq": 1
                , "name": "정보처리기사"
                , "subjects": [
                    {
                        "subject": {
                            "seq": 1
                            , "name": "전자계산기구조"
                            , "ins_date": "2021-06-01"
                            , "pass_score": 60
                        }
                    }
                    ,{
                        "subject": {
                            "seq": 2
                            , "name": "컴퓨터공학기초"
                            , "ins_date": "2021-06-03"
                            , "pass_score": 60
                        }
                    }
                    ,{
                        "subject": {
                            "seq": 3
                            , "name": "프로그램이론"
                            , "ins_date": "2021-06-02"
                            , "pass_score": 60
                        }
                    }
                    ,{
                        "subject": {
                            "seq": 4
                            , "name": "정보보안"
                            , "ins_date": "2021-06-04"
                            , "pass_score": 60
                        }
                    }
                ]
            }
        }
        , {
            "license": {
                "seq": 2
                , "name": "빅데이터기사"
                , "subject": [
                    {
                        "seq": 5
                        , "name": "빅데이터이론"
                        , "ins_date": "2021-06-01"
                        , "pass_score": 60
                    }
                    ,{
                        "seq": 6
                        , "name": "알고리즘"
                        , "ins_date": "2021-06-03"
                        , "pass_score": 60
                    }
                    ,{
                        "seq": 7
                        , "name": "데이터"
                        , "ins_date": "2021-06-02"
                        , "pass_score": 60
                    }
                    ,{
                        "seq": 8
                        , "name": "빅데이터개론"
                        , "ins_date": "2021-06-04"
                        , "pass_score": 60
                    }
                ]
            }
        }
        , {
            "license": {
                "seq": 3
                , "name": "sqlp"
                , "subject": [
                    {
                        "seq": 9
                        , "name": "인덱싱"
                        , "ins_date": "2021-06-01"
                        , "pass_score": 60
                    }
                    ,{
                        "seq": 10
                        , "name": "쿼리튜닝"
                        , "ins_date": "2021-06-03"
                        , "pass_score": 60
                    }
                    ,{
                        "seq": 11
                        , "name": "조인"
                        , "ins_date": "2021-06-02"
                        , "pass_score": 60
                    }
                    ,{
                        "seq": 12
                        , "name": "데이터실기"
                        , "ins_date": "2021-06-04"
                        , "pass_score": 60
                    }
                ]
            }
        }
        , ...
    ]
}
```



### DDaJa 사용자 사용 현황 (GET)

```python
GET /users/status

HTTP/1.1 200 OK
Link: 
 <https://api.ddaja.com/users/status?offset=10&limit=10>; rel="next"
, <https://api.ddaja.com/users/status?offset=50&limit=10>; rel="last"
, <https://api.ddaja.com/users/status?offset=0&limit=10>; rel="first"
, <https://api.ddaja.com/users/status?offset=0&limit=0>; rel="prev"
{
    "users": [
        {
            "user": {
                "seq": 1
                , "name": "gil"
                , "id": "gillog"
            }
            , "state": {
                "type": "one_question"
                , "progress": "ing"
                , "detail": ""
            }
        }
        , {
            "user": {
                "seq": 2
                , "name": "bin"
                , "id": "binsoo"
            }
            , "state": {
                "type": "round_question"
                , "progress": "done"
                , "detail": "perfect"
            }
        }
        , ...
    ]
}
```

### 자격증들 시험 D-Day 목록 정보 (GET)

```python
GET /licenses/exams/
HTTP/1.1 200 OK
Link: 
 <https://api.ddaja.com/licenses/dday?offset=10&limit=10>; rel="next"
, <https://api.ddaja.com/licenses/dday?offset=50&limit=10>; rel="last"
, <https://api.ddaja.com/licenses/dday?offset=0&limit=10>; rel="first"
, <https://api.ddaja.com/licenses/dday?offset=0&limit=0>; rel="prev"

{
    "licenses": [
        {
            "license": {
                "seq": 1
                , "name": "정보처리기사"
                , "exams": [
                    {
                        "exam": {
                            "seq": 1
                            , "name": "정보처리기사 실기 2회"
                            , "date": "2021-06-01"
                            , "info": "펜 볼펜 등 필수 지참"
                        }
                    }
                    , {
                        "exam": {
                            "seq": 2
                            , "name": "정보처리기사 필기 3회"
                            , "date": "2021-09-01"
                            , "info": "펜 볼펜 등 필수 지참"
                        }
                    }
                    , {
                        "exam": {
                            "seq": 3
                            , "name": "정보처리기사 실기 3회"
                            , "date": "2021-12-01"
                            , "info": "펜 볼펜 등 필수 지참"
                        }
                    }
                ]
            }
        , ...
    ]
}
```
- 공지사항 목록 (GET)

```python
GET /notice
HTTP/1.1 200 OK
Link: 
 <https://api.ddaja.com/notice?offset=10&limit=10>; rel="next"
, <https://api.ddaja.com/notice?offset=50&limit=10>; rel="last"
, <https://api.ddaja.com/notice?offset=0&limit=10>; rel="first"
, <https://api.ddaja.com/notice?offset=0&limit=0>; rel="prev"

{
    "notice": [
        {
            "seq": 1
            , "title": "공지사항 1번글"
            , "content": "공지사항 본문 ~~~"
            , "ins_date": "2021-06-25"
            , "in_use": 0
        }
        , {
            "seq": 2
            , "title": "공지사항 2번글"
            , "content": "공지사항 본문 !!~~~"
            , "ins_date": "2021-06-26"
            , "in_use": 1
        }
        , ...
    ]
}

GET /notice
```