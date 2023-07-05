const arr = [1, 2, 3, 4, 5];
function fun1(value){
    if(value%2==0){
        return true;
    } else {
        return false;
    }
}
console.log(arr.every(fun1));

