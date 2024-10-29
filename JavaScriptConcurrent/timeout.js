function doMore() {
    i = setInterval(() => console.log("More!"), 3, 10)
    setTimeout(() => clearInterval(i), 500)
}

function tick(count) {
    setTimeout(() => {
        console.log("Tick! count is", count)
        if (count < 1_000) {
            tick(count + 1)
        }
        // console.log("tick done")
    }, 0)
}

tick(0)
// doMore()
