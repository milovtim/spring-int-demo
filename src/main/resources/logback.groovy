def commonPattern = '%d{dd/MM HH:mm:ss:SS} [%thread] %level %logger{10} %msg%n'

appender('CONSOLE', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = commonPattern
    }
}

logger('error-ch', DEBUG, ['CONSOLE'], false)
logger('result', DEBUG, ['CONSOLE'], false)
logger('org.springframework.integration.endpoint.SourcePollingChannelAdapter', INFO, ['CONSOLE'], false)

root(WARN, ['CONSOLE'])
