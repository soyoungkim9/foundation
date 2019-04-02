(function(){
  splitRegExp();
  replaceRegExp();
  replaceFlag();
  replaceAnchor();
  replaceMeta();
  replaceNum();
  replaceOr();
})();

// 1. 정규표현식 객체
function splitRegExp() {
  var regExp = /script/;
  var string = 'Javascript JQuery Ajax';

  // regExap 변수 값을 기준으로 string 변수의 값을 잘라 배열로 만들어 리턴한다.
  var output = string.split(regExp);

  // 결과 :  Java, JQuery Ajax
  alert(output);
}

// 2. 대체문자
// 가장 먼저 패턴이 일치하는 문자열만 찾는다.
function replaceRegExp() {
  var regExp = /a/;
  var string = 'Javascript JQuery Ajax';

  // regExap 문자열을 '+$&+'로 변경한다.
  // $& : 대체문자, 정규표현식 기호
  var output = string.replace(regExp, '+$&+');

  // 결과 : J+a+vascript JQuery Ajax
  alert(output);
}

// 3. 플래그 문자
// 모든 패턴이 일치하는 문자열을 찾는다.
function replaceFlag() {
  // i : 플래그 문자, 대소문자를 가리지 않고 비교한다.
  // g : 플래그 문자, 전역 비교를 수행한다.
  var regExp = /a/ig;
  var string = 'Javascript JQuery Ajax';

  var output = string.replace(regExp, '+$&+');

  // 결과 : J+a+v+a+script JQuery +A+j+a+x
  alert(output);
}

// 4. 앵커 문자
// 문자열의 앞과 뒤를 구분해 준다.
function replaceAnchor() {
  // ^ABC : 맨 앞 문자가 ABC
  // ABC$ : 맨 뒤 문자가 ABC
  var regExp = /^j/ig;
  var string = "Javascript\njQuery\nAjax";

  var output = string.replace(regExp, '+$&+');

  // 결과 : j로 시작하는 문자열을 찾기 때문에 다음 줄에 있는 j는 변하기 않는다.
  // +J+avascript
  // JQuery
  // Ajax
  // 만약 여러줄에 걸쳐 검사를 하고 싶다면 플래그 문자 m을 추가하면 된다.
  alert(output);
}5.

// 5. 메타 문자
function replaceMeta() {
  // \d : 메타문자, 숫자만 온다
  // [1234] : 메타문자, 괄호안의 글자 중 하나
  var regExp = /\d\d\d\d\d\d-[1234]\d\d\d\d\d\d/;
  var string = '910209-2001211';

  // 결과 : +910209-2001211+
  var output = string.replace(regExp, '+$&+');

  alert(output);
}

// 6. 수량 문자
function replaceNum() {
  // \d{6} : 수량문자, \d가 6개 이상
  var regExp = /\d{6}-[1234]\d{6}/;
  var string = '910209-2001211';

  // 결과 : +910209-2001211+
  var output = string.replace(regExp, '+$&+');

  alert(output);
}

// 7. 선택 문자
// '또는'의 역할을 수행하는 정규표현식 기호
function replaceOr() {
  var string = prompt('소문자 또는 숫자로만 구성된 단어를 입력하세요.', '단어');
  // ([0-9]|[a-z]) : 0~9까지 또는 a-z까지를 선택한다.
  var regExp = /([0-9]|[a-z])/g;

  // 한 행 중에 숫자나 소문자로 된 문자가 있으면 빈문자열로 바꾼다.
  if(string.replace(regExp, '').length == 0) {
    alert("감사합니다.");
  } else {
    alert("ㅇㅁㅇ");
  }
}
