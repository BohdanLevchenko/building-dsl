package com.pacemaker.blackarchive.inspections

import org.springframework.beans.factory.annotation.Autowired

abstract class Inspection extends Script {

    {
        String.metaClass.hasText = {
            delegate.contains(it)
        }
    }

    @Autowired
    Alerter alerter

    def when(boolean cond, Closure<Void> closure) {
        if (cond) closure.call()
    }

    def reject(Map args) {
        throw new IllegalArgumentException(args.reason)
    }

    def propertyMissing(String name) {
        request."${name}"
    }

    def notify(Map args) {
        alerter.notify(args.who, args.message)
    }
}
