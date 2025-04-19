package io.github.freya022.botcommands.internal.jdui

import dev.minn.jda.ktx.interactions.components.findAll
import io.github.freya022.botcommands.api.components.ComponentIgnoreFilter
import io.github.freya022.botcommands.api.core.service.annotations.BService
import net.dv8tion.jda.api.components.ActionComponent
import net.dv8tion.jda.api.entities.Message

@BService
internal object JDUIComponentIgnoreFilter : ComponentIgnoreFilter {

    override fun shouldIgnore(message: Message, componentId: String): Boolean {
        val firstComponent = message.componentTree.findAll<ActionComponent>().firstOrNull() ?: return false
        val customId = firstComponent.customId ?: return false
        return customId.startsWith("j1:") || customId.startsWith("j2:")
    }
}