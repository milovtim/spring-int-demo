package ru.milovtim

import com.google.common.base.Preconditions
import org.springframework.context.support.ClassPathXmlApplicationContext

class MainClass {

    static void main(String[] args) {
        Preconditions.checkArgument(args.length > 0, "Spring config name must be provided")
        def ctx = new ClassPathXmlApplicationContext("context/" + args[0] + ".xml")
        ctx.refresh()
        System.in.read()
    }
}
