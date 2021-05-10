package reproduce.bean.injection
import com.amazonaws.services.lambda.runtime.events.ScheduledEvent
import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler
import java.util.UUID
import javax.inject.Inject

@Introspected
class RequestHandler : MicronautRequestHandler<ScheduledEvent?, String?>() {
    @Inject
    lateinit var serviceA: ServiceA
    override fun execute(input: ScheduledEvent?): String? {
        return if (input != null) {
            return serviceA.doThing()
        } else {
            null
        }
    }
}