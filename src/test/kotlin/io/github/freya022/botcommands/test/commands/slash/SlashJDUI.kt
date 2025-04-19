package io.github.freya022.botcommands.test.commands.slash

import at.xirado.jdui.component.ViewContainer
import at.xirado.jdui.component.message.button
import at.xirado.jdui.component.message.container
import at.xirado.jdui.component.message.section
import at.xirado.jdui.component.message.text
import at.xirado.jdui.replyView
import at.xirado.jdui.state.state
import at.xirado.jdui.view.View
import at.xirado.jdui.view.compose
import io.github.freya022.botcommands.api.commands.annotations.Command
import io.github.freya022.botcommands.api.commands.application.ApplicationCommand
import io.github.freya022.botcommands.api.commands.application.slash.GuildSlashEvent
import io.github.freya022.botcommands.api.commands.application.slash.annotations.JDASlashCommand
import net.dv8tion.jda.api.components.button.ButtonStyle

@Command
class SlashJDUI : ApplicationCommand() {

    class Counter : View() {

        var count: Int by state(0)

        override suspend fun createView(): ViewContainer = compose {
            +container {
                +section {
                    +text(count.toString())

                    accessory {
                        button(ButtonStyle.PRIMARY, label = "Click me") {
                            count++
                        }
                    }
                }
            }
        }
    }

    @JDASlashCommand(name = "jdui")
    suspend fun onSlashJdui(event: GuildSlashEvent) {
        event.replyView<Counter>(ephemeral = true)
    }
}