# Git Convention



# 일정, 운영

<br>

## Milestones

개발해야할 기능들을 묶어 프로젝트 단위로 사용

프로젝트 진행 목표 사항 관리 용도

개발해야하는 기능들 목록 나열, 담당자 배정, 해당 전체 개발 완료 기간 설정

> [EX] 제목 : 오픈 전 필수 기능 개발 
<br>
<br> 설명 : 오픈 전 필수 기능 우선 개발을 목표로 아래와 같은 기능들 업무 분담
<br>A기능 - G 담당
<br>B기능 - B 담당 
<br>C기능 - B 담당
<br>
<br> 기간 : ~ 21.10.30

<br>

## Projects

Milestones 당 Projects 생성 공통의 Template 설정

Template는 기본 kanban Template 사용

Column 목록은 아래 단계들 순차적 단계로 사용


- To Do 
    - 개발 예정 단계
    - 해당 Milestones에 필요한 기능들 Issues 생성을 통해 최초 등록
 
- Develope
    - 개발 진행 중 단계
    - 개발을 시작해 진행 중인 Issues 카드를 옮기며 진행

- Test
    - 개발 완료 후 테스트 단계
    - Develope > Test 순으로 진행

- Bug
    - Test 단계나, 최종 완료 단계에서 버그 발견시 버그 해결 단계
    - Test, Done 단계에서 Bug로 이동 
    - Bug 해결 작업 시에는 Test 단계로 이동 후 Test 검증
    - 이를 통해 해결되지 않은 Bug 관리 용도

- Done
    - Test 단계 완료 후 개발 완료 단계
    - 추후 버그 발생 시 Bug 단계로 이동 가능
<br>

## Issues

Label 단위로 이슈 사항 관리 용도

### 배포 전

구현해야 할 기능 단위로 Label 생성 후 기능 별로 Label 관리

구현해야 하는 기능 별로 필요한 개발 예정 계획 등을 Issues 생성 후
, Label을 묶어 Projects에서 카드를 통해 관리

> [EX] 
<br>#1 UI 구성 [Dev]한 문제 풀기<br>#2 SQL 쿼리 테스트 [Dev]한 문제 풀기
<br>#3 화면 구성 [Dev]커뮤니티 모임

Issues 생성 후 Milestones, Lable, Projects 설정하여 프로젝트 구현에 필요한 작은 구현 기능 단위로 사용

### 배포 후

BUG, DEVELOPE, IDEA, HELP, FIX 등 대 분류 Labels 생성 후

기능 개발을 넘어 자유롭게 모든 이슈 사항을 Labels 태그를 붙여 Issues 생성

---


<br>

# 개발

## Branch

5가지 종류의 Branch를 사용.

1. Master
    - 운영, 배포될 가장 최상위 Branch


2. Develope
    - Master Branch에서 파생되어, 기능 개발 Branch(Feature)가 통합 될 Branch

3. Feature
    - Develope Branch에서 파생되어, Issues 관련으로 
4. Release

5. Hotfix


## Commit Message

작업 중인 Branch 유형에 따라 커밋 메시지 작성

### Develope

"[#6]메인화면구성중컴포넌트새로생성함"