object Solution {
    def fib(n: Int): Int =
        LazyList.unfold((0, 1)) { case (a, b) => Some(a, (b, a + b)) }(n)
}
