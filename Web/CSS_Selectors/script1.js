function display(val) {
    console.log(val);
}


let promise = new Promise(function(resolve, reject) {
    setTimeout(() => reject(new Error("Ahhh!")), 1000);
})

promise.then(alert, display);
