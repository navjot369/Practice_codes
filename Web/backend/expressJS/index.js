import express from 'express';
import { dirname, join} from 'path';
import { fileURLToPath } from 'url';
const app = express();

let port = 3000;
const __dirname = dirname(fileURLToPath(import.meta.url));

app.listen(port, () => {
    console.log(`Listening at port: ${port}`);
    console.log(join(__dirname, "public"));
});

app.set("view engine", "ejs");
app.use(express.static(join(__dirname, "public")));
app.use(express.static(join(__dirname, "util")));
app.use(express.urlencoded({extended: true}));
app.use(express.json());

app.get("/", (req, res) => {
    res.render("home.ejs");
})

app.get("/user", (req, res) => {
    let {user, pass} = req.query;
    console.log(user, pass);
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.send("Form accepted");
});

app.post("/user", (req, res) => {
    let {user, pass} = req.body;
    console.log(`${user} have this ${pass}`);
    res.send("recieved");
})