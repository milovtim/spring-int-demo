import org.slf4j.LoggerFactory

class SometimesThrownService {

    def log = LoggerFactory.getLogger('error-ch')

    void handlerInt(int someInt) {
        log.debug('{}', someInt)

        if (someInt % 2 == 0)
            throw new RuntimeException('Value of "' + someInt + '" is odd')
    }
}
