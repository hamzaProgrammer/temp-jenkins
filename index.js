const express = require("express")
const app = express()
const PORT = 5000

app.get("/", (req, res) => {
    res.send("welcome to jenkins 11")
})

app.listen(PORT, () => {
    console.log("app is running on ", PORT)
})