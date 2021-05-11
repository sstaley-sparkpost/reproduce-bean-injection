package reproduce.bean.injection

import io.micronaut.test.annotation.MockBean
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test

class RequestHandlerOtherTest {

    @MockBean(ServiceC::class)
    fun getServiceC(): ServiceC {
        val serviceCMock = mockk<ServiceC>()
        every { serviceCMock.doThing() } returns "mock value"
        return serviceCMock
    }


    @Test
    fun `should be cool`() {

    }
}
