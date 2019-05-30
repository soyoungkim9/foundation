// 파일 복사
const fs = require('fs');

fs.copyFile('readme2.txt', 'writeme4.txt', (error) => {
    if (error) {
        return console.error(error);
    }
    console.log('복사 완료');
});