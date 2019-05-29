// process.exit() : 실행중인 노드 프로세스 종료
// 인자 0 : 정상종료, 인자 1 : 비정상 종료 (에러가 발생해서 종료하는 경우)
let i = 1;
setInterval(()=> {
    if(i === 5) {
        console.log('종료!');
        process.exit();
    }
    console.log(i);
    i += 1;
}, 1000);