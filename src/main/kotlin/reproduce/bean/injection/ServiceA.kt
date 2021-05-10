package reproduce.bean.injection

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ServiceA @Inject constructor(
    private val serviceB: ServiceB
) {

    fun doThing(): String {
        return serviceB.doThing()
    }
}