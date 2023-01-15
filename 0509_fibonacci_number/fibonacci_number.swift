class Solution {
    func fib(_ n: Int) -> Int {
        sequence(state: (0, 1), next: { s in
            defer { s = (s.1, s.0 + s.1) }
            return s.0
        }).dropFirst(n).first { _ in true }!
    }
}
