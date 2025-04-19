package io.github.freya022.botcommands.internal.jdui

import io.github.freya022.botcommands.api.core.db.Database
import io.github.freya022.botcommands.api.core.db.annotations.RequiresDatabase
import io.github.freya022.botcommands.api.core.service.annotations.BService
import io.github.freya022.botcommands.api.core.service.annotations.IgnoreServiceTypes

@BService
@RequiresDatabase
@IgnoreServiceTypes(Database::class)
internal class JDUIDatabase internal constructor(private val database: Database) : Database by database {

    override suspend fun fetchConnection(readOnly: Boolean) = database.fetchConnection().apply {
        schema = "jdui"
    }
}