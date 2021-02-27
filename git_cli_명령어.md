https://git-scm.com/download/win

-로컬 저장소 생성
```shell
git int 
```

-계정등록 이메일
```shell
git config --global user.email "xxbrox@naver.com"
```

-계정등록 이름
```shell
git config --global user.name "realllbro"
```

-커밋할 파일
```shell
git add README.txt
```

-커밋 (-m은 message의 약자)
```shell
git commit -m "두번째 커밋 테스트"
"1 file changed, 1 insertion(+)" 텍스트가 보이면 성공 
```



-수정은 add, 와 commit 명령어 반복 
```shell
git add README.txt
git commit -m "두번째 커밋 테스트"
 1 file changed, 1 insertion(+), 1 deletion(-) 텍스트가 보이면 성공 
 ```

-로그 명령어
```shell
git log
```

-커밋 버전으로 되돌리기 (버전키에서 7자리)
```shell
commit ee44b66d033666ef1bf067a04a858334e83d468d
git checkout ee44b66

Administrator@SKCC16N01065 MINGW64 /c/devbro/study/project/sts_workspace ((ee44b66...)) 보이면 성공
```

-최신커밋으로 돌리기(버전키 또는 '-' 문자)
```shell
git checkout -
```

-로컬저장소에 원격저장소 주소등록
```shell
git remote add origin https://github.com/realllbro/javaStudy.git
```

-push 계정로그인 이나 토큰 사용해서 인증
```shell
git push origin master
```


-git clone 명령어 (끝에 " ." 한칸 띄고 '.'을 찍어야 해당폴더에 생성됨 생략하면 프로젝트 명으로 하위 폴더가 생성되고 그안에 git 내려받음)
```shell
git clone https://github.com/realllbro/javaStudy.git .
```

-원격저장소(레파지토리) 에서 내려받기
```shell
git pull origin master
```

-현재 comiit 상태 확인
```shell
git status
```

-git add 취소
```shell
git reset (전체 파일 add 취소)
git reset HEAD 파일 (특정 파일 add 취소)
```
 

-git commit 취소
```shell
git reset HEAD^ (가장 최신 커밋 1개 취소(삭제))
git reset HEAD^^(가장 최신 커밋 2개 취소(삭제))
```

-git 폴더삭제
```shell
rm -rf 폴더명
```
