package io.github.freya022.botcommands.internal.jdui

import at.xirado.jdui.config.PersistenceConfig
import at.xirado.jdui.config.ViewData
import io.github.freya022.botcommands.api.core.db.annotations.RequiresDatabase
import io.github.freya022.botcommands.api.core.db.preparedStatement
import io.github.freya022.botcommands.api.core.service.annotations.BService

@BService
@RequiresDatabase
internal class JDUIPersistenceConfig(
    private val database: JDUIDatabase,
) : PersistenceConfig {

    override suspend fun retrieveState(id: Long): ViewData? {
        return database.preparedStatement(
            """
                SELECT data
                FROM views
                WHERE id = ?
            """.trimIndent(),
            readOnly = true
        ) {
            val result = executeQuery(id).readOrNull() ?: return null

            ViewData(id, result["data"])
        }
    }

    override suspend fun save(viewData: ViewData) {
        database.preparedStatement(
            """
                INSERT INTO views (id, data)
                VALUES (?, ?)
                ON CONFLICT (id) DO UPDATE SET data = excluded.data
            """.trimIndent()
        ) {
            executeUpdate(viewData.id, viewData.data)
        }
    }
}