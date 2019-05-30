// fs 모듈 : 파일 시스템에 접근하는 모듈
const fs = require('fs');

fs.readFile('./readme.txt', (err, data) => {
    if(err) {
        throw err;
    }
    console.log(data);
    console.log(data.toString());
});