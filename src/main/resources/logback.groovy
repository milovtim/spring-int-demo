def commonPattern = '%d{dd/MM HH:mm:ss:SS} %level [%thread] %logger{10} %msg%n'

appender('CONSOLE', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = commonPattern
    }
}

logger('error-ch', DEBUG, ['CONSOLE'], false)

root(WARN, ['CONSOLE'])
