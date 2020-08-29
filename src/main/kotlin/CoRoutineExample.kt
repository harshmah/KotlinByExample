import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

class CoRoutineExample {

    fun xyz() {
        println("In XYZ")
        abc()
        CoroutineScope(Dispatchers.Default).launch {
            abc2()
        }
        println("XYZ is going in sleep mode")
        Thread.sleep(1000)
        println("XYZ is awake")
    }

    fun abc() {
        println("In ABC")
        CoroutineScope(Dispatchers.IO).launch {
            println("Inside ABC coroutine")
            println("ABC = ${kotlin.coroutines.coroutineContext.toString()}")
        }
        println("In Exiting from ABC")
    }

    suspend fun abc2() {
        println("In ABC2: ${coroutineContext}")
        withContext(Dispatchers.IO) {
            println("ABC2 = ${coroutineContext}")
        }
        println("In Exiting from ABC2")
    }
}
