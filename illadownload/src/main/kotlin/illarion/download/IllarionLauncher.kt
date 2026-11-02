/*
 * This file is part of the Illarion project.
 *
 * Copyright © 2026 - Illarion e.V.
 *
 * Illarion is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Illarion is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Illarion.  If not, see <http://www.gnu.org/licenses/>.
 */
package illarion.download

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Skin
import org.slf4j.LoggerFactory
import org.slf4j.bridge.SLF4JBridgeHandler

import illarion.common.util.DirectoryManager
import illarion.common.util.DirectoryManager.Directory
import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.util.ContextInitializer
import ch.qos.logback.core.joran.spi.JoranException

/**
 * 
 */
class IllarionLauncher : ApplicationAdapter() {

    override fun render() {
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

 companion object {
        @JvmStatic
        fun main(args: Array<String>) {
                val config = Lwjgl3ApplicationConfiguration()
                config.setTitle("Illarion Launcher")
                config.setWindowedMode(620, 410)
                config.setResizable(false)
                Lwjgl3Application(IllarionLauncher(), config)
            }

    }
}
