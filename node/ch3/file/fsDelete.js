// 기타 파일 시스템을 조작하는 메서드2
const fs = require('fs');

fs.readdir('./folder', (err, dir) => {
    if(err) {
        throw err;
    }
    console.log('폴더 내용 확인', dir);
    fs.unlink('./folder/newFile.js', (err) => {
        if (err) {
            throw err;
        }
        console.log('파일 삭제 성공');
        fs.rmdir('./folder', (err) => {
            if (err) {
                throw err;
            }
            console.log('폴더 삭제 성공');
        });
    });
});