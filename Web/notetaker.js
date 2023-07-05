$("#btn1").click(function() {
    var text = document.getElementById("txt1").value;
    const ele = document.createElement('p');
    ele.innerHTML = text;
    document.getElementById("here").append(ele);
});
document.getElementById("here").addEventListener('click', function(event){
    var text = event.target.innerHTML;
    const ele = document.createElement('textarea');
    ele.value = text;
    const main = document.getElementById("here");
    main.insertBefore(ele, event.target);
    event.target.remove()
})