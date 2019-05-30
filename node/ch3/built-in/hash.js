// 비밀번호는 대게 단방향 암호화를 사용한다.
// 단방향 암호화란 복호화 할 수 없는 암호화를 뜻한다.
// 단방향 알고리즘은 주로 해시 기법을 사용한다.
// 해시기법 : 어떤 문자열을 고정된 길이의 달느 문자열로 바꾸는 방식
// 해시기법의 문제점 : 여러 입력 문자열중에 같은 출력 문자열로 변환 될 가능성이 있다.
const crypto = require('crypto');

console.log('base64: ', crypto.createHash('sha512').update('소영이').digest('base64'));
console.log('hex: ', crypto.createHash('sha512').update('소영이').digest('hex'));
console.log('base64: ', crypto.createHash('sha512').update('다른 소영이').digest('base64'));