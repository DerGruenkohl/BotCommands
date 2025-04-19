package io.github.freya022.botcommands.test

import at.xirado.jdui.config.JDUIConfigBuilder
import at.xirado.jdui.config.Secret
import io.github.freya022.botcommands.api.core.service.annotations.BService
import io.github.freya022.botcommands.api.jdui.JDUIConfigurer

@BService
class MyJDUIConfigurer : JDUIConfigurer {

    override val secret = Secret("diazbdazdaznonfazopdzna")

    override fun JDUIConfigBuilder.configure() {

    }
}