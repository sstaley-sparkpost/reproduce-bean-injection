package reproduce.bean.injection

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Replaces
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import javax.inject.Inject
import javax.inject.Singleton

@MockBean(ServiceC::class)
fun getServiceC(): ServiceC {
    val serviceCMock = mockk<ServiceC>()
    every { serviceCMock.doThing() } returns "mock value"
    return serviceCMock
}

@MicronautTest
class RequestHandlerTest(
    private val requestHandler: RequestHandler
): DescribeSpec({

    describe("test") {
        it("test") {
//            @Factory
//            class ServiceCProviderMock {
//
//                @Singleton
//                @MockBean(ServiceC::class)
//                fun getServiceC(): ServiceC {
//                    return ServiceC()
//                }
//            }
            val event = ScheduledEvent()

//            val requestHandler = RequestHandler()

            requestHandler.handleRequest(event, TestContext()) shouldBe "mock value"
        }
    }
})
