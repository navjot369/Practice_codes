function fun1(){
    const user = document.getElementById("num");
    const val = Number(user.value);
    user.value = "";
    try{
        decodeURI("%%%");
    }
    catch(err){
        document.getElementById("demo").innerHTML = err;
    }
}