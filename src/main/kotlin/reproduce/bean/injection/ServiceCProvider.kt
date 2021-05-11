package reproduce.bean.injection

import io.micronaut.context.annotation.Bean
import io.micronaut.context.annotation.Factory
import javax.inject.Singleton

@Factory
class ServiceCProvider {

    @Singleton
    fun getServiceC(): ServiceC {
        println("REAL THING BEING CALLED")
        return ServiceC()
    }
}
