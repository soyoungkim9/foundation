// 파이핑
// createReadStream으로 파일을 읽고 그 스트림을 전달받아
// createWriteStream으로 파일을 쓸 수 있는데 이렇게 스트림끼리 연결하는 것을 '파이핑한다'고 한다.
// 파일 복사의 의미와 비슷하다.

const fs = require('fs');

const readStream = fs.createReadStream('readme2.txt');
const writeStream = fs.createWriteStream('writeme3.txt');
readStream.pipe(writeStream);