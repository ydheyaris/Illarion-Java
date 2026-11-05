/*
 * This file is part of the Illarion project.
 *
 * Copyright © 2015 - Illarion e.V.
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
 */

package illarion.client.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.utils.viewport.ScreenViewport
import illarion.client.loading.Loading
i

class LoadingScreen() : Screen {
    private var stage: Stage? = null
    private val loadingManager: Loading = Loading()

    @Override
    fun create() {

    }

    override fun render(delta: Float) {
        stage?.act(delta)
        stage?.draw()

        if (loadingManager.isLoadingDone()) {
            // TODO: transition to next screen
        }
    }

    override fun show() {
        loadingManager.load()
        stage = Stage(ScreenViewport())
        Gdx.input.setInputProcessor(stage)

    }

    override fun resize(width: Int, height: Int) {
        stage?.viewport?.update(width, height, true)
    }

    override  fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
        stage?.dispose()
    }
}
