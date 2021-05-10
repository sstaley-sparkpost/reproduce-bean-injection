package reproduce.bean.injection

import com.amazonaws.services.lambda.runtime.LambdaLogger
import org.slf4j.LoggerFactory

class TestLogger : LambdaLogger {
    override fun log(message: String) {
        logger.info(message)
    }

    override fun log(message: ByteArray) {
        logger.info(String(message))
    }

    companion object {
        private val logger = LoggerFactory.getLogger(TestLogger::class.java)
    }
}
