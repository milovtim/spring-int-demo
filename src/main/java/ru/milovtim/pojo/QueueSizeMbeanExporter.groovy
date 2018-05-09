package ru.milovtim.pojo

import org.springframework.jmx.export.annotation.ManagedMetric
import org.springframework.jmx.export.annotation.ManagedResource

@ManagedResource("ru.milovtim:name=channelQueue,type=Channel")
class QueueSizeMbeanExporter {
    final Queue<?> queue

    QueueSizeMbeanExporter(Queue<?> queue) {
        this.queue = queue
    }

    @ManagedMetric(displayName = "channelQueueSize")
    int getQueueSize() {
        this.queue.size()
    }
}
