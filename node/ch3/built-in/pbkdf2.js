// pbkdf2 알고리즘
// 해시함수의 컨테이너로 salt를 적용한 후 해시 함수의 반복횟수를 임의로 선택 할 수 있다.
// 아주 가볍고 구현하기 쉬운것이 장점이다.
const crypto = require('crypto');

crypto.randomBytes(64, (err, buf)=>{
    const salt = buf.toString('base64');
    console.log('salt:', salt);
    crypto.pbkdf2('소영이', salt, 100000, 64, 'sha512', (err,key)=>{
        console.log('password:', key.toString('base64'));
    });
});