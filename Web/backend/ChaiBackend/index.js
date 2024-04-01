import 'dotenv/config';
import express from 'express';
const app = express();
// const port = 3000;

app.get('/', (req, res) => {
    res.send("Respond to get Request");
})

app.get('/login', (req, res) => {
    res.send("<h1>Login here</h1>");
})

app.listen(process.env.PORT, () => {
    console.log(`Listening at port: ${process.env.PORT}`);
    console.log(process.env);
})