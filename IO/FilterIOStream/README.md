# FilterInputStream / FilterOutputStream

- FilterInputStream / FilterOutputStream은 바이트기반의 보조스트림이다.

- 보조스트림은 자체적으로 입출력을 수행할 수 없기 때문에 기반스트림을 필요로 한다.<br>
그 보조스트림 클래스의 예로는 BufferedInputStream/BufferedOutputStream ,<br>
DataInputStream/DataOutputStream, PushbackInputStream/printStream 등  


- 보조스트림을 사용한 경우에는 기반스트림(FileOutputStream)의 close()나 flush()를 호출 할<br>
필요없이 단순히 보조스트림의 close()를 호출하기만 하면 된다. <br>
즉, FilterOutputStream에 정의된 close()는 flush()를 호출한 다음에 기반스트림의 close()를<br>
호출한다.
