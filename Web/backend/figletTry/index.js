const fig = require("figlet");

fig("N a v j o t     S i n g h  <> $#@", (err, data) => {
    if(err) {
        console.log("Something went wrong...!");
        return;
    }
    console.log(data);
});