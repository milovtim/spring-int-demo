package ru.milovtim.context

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

@Configuration
class CommonContext {

    static final QUEUE_CAPACITY = 100

    @Bean
    BlockingQueue<Integer> staticIntQueue(Random rand) {
        def q = new LinkedBlockingQueue<Integer>(QUEUE_CAPACITY)
        100.times {
            q.offer(rand.nextInt(QUEUE_CAPACITY))
        }
        q
    }

    @Bean
    Random rand() {
        new Random()
    }
}
