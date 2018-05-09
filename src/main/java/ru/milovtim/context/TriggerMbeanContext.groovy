package ru.milovtim.context

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.integration.util.DynamicPeriodicTrigger
import org.springframework.jmx.export.MBeanExporter
import org.springframework.jmx.export.annotation.ManagedResource

import javax.annotation.PostConstruct
import javax.management.ObjectName

class TriggerMbeanContext {
    final DynamicPeriodicTrigger trigger

    MBeanExporter exporter

    TriggerMbeanContext(DynamicPeriodicTrigger trigger) {
        this.trigger = trigger
    }

    @Autowired
    void setExporter(MBeanExporter exporter) {
        this.exporter = exporter
    }

    @PostConstruct
    void init() {
        exporter.registerManagedResource(trigger, ObjectName.getInstance('ru.milovtim:name=delayTrigger,type=Trigger'))
    }
}
