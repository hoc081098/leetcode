/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

class Solution {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val map = employees.associateBy { it!!.id }
        fun each(e: Employee): Int = e.importance + e.subordinates.fold(0) { acc, e -> acc + each(map[e]!!) }
        return each(map[id]!!)
    }
}

/*
 *	// Definition for Employee.
 *	class Employee {
 *		var id:Int = 0
 *		var importance:Int = 0
 *		var subordinates:List<Int> = listOf()
 *	}
 */

class Solution {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        val map = employees.associateBy { it!!.id }
        val openSet: Queue<Int> = LinkedList<Int>().apply { add(id) }
        val visited: MutableSet<Int> = hashSetOf<Int>()

        var sum = 0
        while(openSet.isNotEmpty()) {
            val cur = map[openSet.poll()]!!
            sum += cur.importance
            openSet += cur.subordinates.filter { visited.add(it) }
        }
        return sum
    }
}
