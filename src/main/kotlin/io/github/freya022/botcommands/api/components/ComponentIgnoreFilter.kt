package io.github.freya022.botcommands.api.components

import io.github.freya022.botcommands.api.core.service.annotations.InterfacedService
import net.dv8tion.jda.api.entities.Message

@InterfacedService(acceptMultiple = true)
interface ComponentIgnoreFilter {
    fun shouldIgnore(message: Message, componentId: String): Boolean
}