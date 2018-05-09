package ru.milovtim.context

import org.springframework.integration.util.DynamicPeriodicTrigger
import org.springframework.jmx.export.MBeanExporter
import org.springframework.jmx.export.annotation.ManagedMetric
import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor

import javax.annotation.PostConstruct
import javax.management.ObjectName

@ManagedResource("ru.milovtim:name=executorQueue,type=TaskExecutor")
class MbeansContext {
    MBeanExporter exporter

    ThreadPoolTaskExecutor taskExecutor
    DynamicPeriodicTrigger trigger

    @ManagedMetric(displayName = "executorQueueSize")
    int getExecutorQueueSize() {
        taskExecutor.threadPoolExecutor.queue.size()
    }

    @PostConstruct
    void init() {
        exporter.registerManagedResource(taskExecutor,
            ObjectName.getInstance('ru.milovtim:name=workerExecutor,type=TaskExecutor'))

        exporter.registerManagedResource(trigger,
            ObjectName.getInstance('ru.milovtim:name=pollTrigger,type=Trigger'))
    }
}
