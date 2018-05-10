package ru.milovtim.context

import org.springframework.beans.factory.InitializingBean
import org.springframework.integration.util.DynamicPeriodicTrigger
import org.springframework.jmx.export.MBeanExporter

import javax.management.ObjectName

class TriggerMbeanContext implements InitializingBean {
    final DynamicPeriodicTrigger trigger

    MBeanExporter exporter

    TriggerMbeanContext(DynamicPeriodicTrigger trigger) {
        this.trigger = trigger
    }

    void setExporter(MBeanExporter exporter) {
        this.exporter = exporter
    }

    @Override
    void afterPropertiesSet() throws Exception {
        exporter.registerManagedResource(trigger, ObjectName.getInstance('ru.milovtim:name=delayTrigger,type=Trigger'))
    }
}
