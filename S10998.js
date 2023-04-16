let fs = require('fs');
let input = fs.readFileSync('dev/stdin').toString().split('\n');

let line = input[0].split(' ');

let n1 = line[0];
let n2 = line[1];

console.log(n1 * n2);