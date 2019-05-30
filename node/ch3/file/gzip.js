// 파이을 읽은 후 gzip방식으로 압축
const zlib = require('zlib');
const fs = require('fs');

const readStream = fs.createReadStream('./readme2.txt');
const zlibStream = zlib.createGzip();
const writeStream = fs.createWriteStream('./readme2.txt.gz');
readStream.pipe(zlibStream).pipe(writeStream);