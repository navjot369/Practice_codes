function checkit() {
    let rows = document.getElementById("val-row").value;
    let cols = document.getElementById("val-col").value;
    let ele = document.getElementById("ans");
    let ans = "<table>";
    let count = 1;
    for(let i = 0; i < rows; i++) {
        ans += "<tr>";
        for(let j = 0; j < cols; j++) {
            ans += ("<td>" + count + "</td>");
            count++;
        }
        ans += "</tr>";
    }
    ele.innerHTML  = ans;
    console.log(ans.innerHTML);
}
