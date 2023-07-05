fun main() {
    getSqr(3, null)

    var square: ((Int) -> Int)? = {
        4
    }
    square = null
}

fun fun1(x: Int): (Int, Int) -> Unit{
    if(x == 1){
        return one
    }
    else{
        return two
    }
}


fun getSqr(num: Int, func: ((Int) -> Int)? ): Int {
    return func()
}

var one: (Int, Int) -> Unit = {x, y ->
    println("This is one")
}

var two: (Int, Int) -> Unit = {x, y ->
    println("This is not one")
}