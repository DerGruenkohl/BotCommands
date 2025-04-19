package io.github.freya022.botcommands.api.jdui

import at.xirado.jdui.config.JDUIConfigBuilder
import at.xirado.jdui.config.Secret
import io.github.freya022.botcommands.api.core.service.annotations.InterfacedService

@InterfacedService(acceptMultiple = false)
interface JDUIConfigurer {

    val secret: Secret

    fun JDUIConfigBuilder.configure()
}