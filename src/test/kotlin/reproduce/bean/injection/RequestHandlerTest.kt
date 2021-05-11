package reproduce.bean.injection

import com.amazonaws.services.lambda.runtime.events.ScheduledEvent
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotest.MicronautKotestExtension.getMock
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk


@MicronautTest
class RequestHandlerTest(
    private val requestHandler: RequestHandler,
): DescribeSpec({

    describe("test") {
        it("test") {
            val mock = getMock(requestHandler)
            val event = ScheduledEvent()

//            val requestHandler = RequestHandler()

            mock.handleRequest(event, TestContext()) shouldBe "mock value"
        }
    }
}) {
    @MockBean(ServiceCProvider::class)
    fun mockServiceCProvider(): ServiceCProvider {
        val serviceCProviderMock = mockk<ServiceCProvider>()
        val serviceCMock = mockk<ServiceC>()
        every { serviceCProviderMock.getServiceC() } returns serviceCMock

        every {serviceCMock.doThing()} returns "mock value"
        return serviceCProviderMock
    }
}
