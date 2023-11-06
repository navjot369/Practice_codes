function fun1(x) {
    console.log("x -- " + x);
    console.log("y -- " + y);
    console.log("z -- " + z);
}

let partialfn = fun1.bind(this, 6, 2);
partialfn(7);