package io.github.freya022.botcommands.internal.jdui

import at.xirado.jdui.JDUIListener
import at.xirado.jdui.config.jdui
import io.github.freya022.botcommands.api.core.annotations.BEventListener
import io.github.freya022.botcommands.api.core.service.annotations.BService
import io.github.freya022.botcommands.api.jdui.JDUIConfigurer
import net.dv8tion.jda.api.events.Event

@BService
internal class JDUIService internal constructor(
    configurer: JDUIConfigurer,
    persistenceConfig: JDUIPersistenceConfig?,
) {

    private val config = jdui {
        with(configurer) {
            configure()
        }
        this.secret = configurer.secret
        this.persistenceConfig = persistenceConfig
    }
    private val listener = JDUIListener(config)

    @BEventListener(
        // Blocking in case it needs to do something synchronously in some cases.
        // Though currently it is immediately redispatched by JDUI's own dispatcher anyway.
        mode = BEventListener.RunMode.BLOCKING
    )
    internal fun onEvent(event: Event) = listener.onEvent(event)
}