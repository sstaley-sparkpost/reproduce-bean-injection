package reproduce.bean.injection

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServiceB @Inject constructor(
    private val serviceC: ServiceC
){
    fun doThing(): String {
        return serviceC.doThing()
    }
}