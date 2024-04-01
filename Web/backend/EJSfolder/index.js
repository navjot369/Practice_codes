const express = require("express");
const app = express();


const port = 3000;
app.listen(port, () => {
    console.log("Listening.....");
})

app.set("view engine", "ejs");

app.get("/id/:username", (req, res) => {
    let { username } = req.params;
    const Instadata = require("./data.json");
    const data = Instadata[username];
    if(data) {
        res.render("userPage.ejs", { data });
    }
    else{
        res.render("error.ejs", { username })
    }
});


// const express = require("express");
// const app = express();
// const path = require("path");

// let port = 3000;
// app.listen(port, () => {
//     console.log(`Listening at port: ${port}`);
// });
// app.set("view engine", "ejs");
// app.set("views", path.join(__dirname, "/views"));

// app.get("/", (req, res) => {
//     console.log(path.join(__dirname, "/views"));
//     res.render("home.ejs");
// })

// app.get("/welcome/:user", (req, res) => {
//     let { user } = req.params;
//     res.render("welcome.ejs", {name : user});
// })