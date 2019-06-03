const cluster = require('cluster');
const http = require('http');
const numCPUs = require('os').cpus().length;

// 마스터 프로세스는 cpu개수만큼 워커 프로세스를 만든다.
if(cluster.isMaster) {
    console.log(`마스터 프로세스 아이디: ${process.pid}`);

    // cpu 개수만큼 워커를 생산
    for(var i = 0; i < numCPUs; i++) {
        cluster.fork();
    }
    // 워커가 종료되었을 때
    cluster.on('exit', (worker, code, signal) => {
        console.log(`${worker.process.pid}번 워커가 종료되었습니다.`);
        cluster.fork();
    });
} else {
    // 워커들이 포트에서 대기
    http.createServer((req, res) => {
        res.write('<h1>Hello Node!</h1>');
        res.end('<p>Hello Cluster!</p>');
        setTimeout(() => {
            process.exit(1);
        }, 1000);
    }).listen(8005);

    console.log(`${process.pid}번 워커 실행`);
}