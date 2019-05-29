// 모듈을 불러와서 사용할 파일

// var.js파일에 잇는 값을 불러온다.
const {old, even} = require('./var');

function checkOddOrEven(num) {
    if(num % 2) {
        return odd;
    }
    return even;
}

// 다른 모듈(var.js)을 사용하는 파일을 다시 모듈(func.js)로 만들 수 있다.
module.exports = checkOddOrEven;