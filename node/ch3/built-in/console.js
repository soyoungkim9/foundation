const string = 'abc';
const number = 1;
const boolean = true;
const obj = {
    outside: {
        inside: {
          key : 'value',  
        },
    },
};
// console.timeEnd(레이블)과 대응되어 time과 timeEnd 사이의 시간을 측정
console.time('전체시간');
console.log('평범한 로그입니다 쉼표로 구분해 여러 값을 찍을 수 있습니다');
console.log(string, number, boolean);
console.error('에러 메시지는 console.error에 담아주세요');

// 객체를 콘솔에 표시할 때 사용
// console.dir(객체,옵션)
// colors : 콘솔에 색상을 추가하여 보여줄것인지의 여부(true,false)
// depth : 보여줄 객체의 단계 지정
console.dir(obj, {colors: false, depth: 2});
console.dir(obj, {colors: true, depth: 1});

console.time('시간 측정');
for(let i = 0; i < 100000; i++) {
    continue;
}
console.timeEnd('시간 측정');

function b() {
    console.trace('에러 위치 추적');
}
function a() {
    b();
}
a();

console.timeEnd('전체시간');