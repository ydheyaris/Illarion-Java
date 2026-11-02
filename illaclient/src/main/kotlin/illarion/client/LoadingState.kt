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

package illarion.client

import de.lessvoid.nifty.Nifty
import illarion.client.Game
import illarion.client.gui.controller.LoadScreenController
import illarion.client.states.GameState
import illarion.client.loading.Loading
import illarion.client.util.AudioPlayer
import illarion.common.data.SkillLoader
import org.illarion.engine.GameContainer

import javax.annotation.Nonnull

class LoadingState : GameState {
    private lateinit var controller: LoadScreenController

    @Nonnull
    private val loadingManager: Loading = Loading()

    @Override
    override fun create(@Nonnull game: Game, @Nonnull container: GameContainer, @Nonnull nifty: Nifty) {
        controller = LoadScreenController(game)
        nifty.registerScreenController(controller)

        //Util.loadXML(nifty, "illarion/client/gui/xml/loading.xml")
    }

    @Override
    override fun dispose() {
    }

    @Override
    override fun resize(@Nonnull container: GameContainer, width: Int, height: Int) {
    }

    @Override
    override fun update(@Nonnull container: GameContainer, delta: Int) {
        SkillLoader.load()
        AudioPlayer.getInstance().initAudioPlayer(container.engine.sounds)
    }

    @Override
    override fun render(@Nonnull container: GameContainer) {
        loadingManager.load()
        controller.setProgress(loadingManager.progress)

        if (loadingManager.isLoadingDone()) {
            controller.loadingDone()
        }
    }

    @Override
    override fun isClosingGame(): Boolean {
        return true
    }

    @Override
    override fun enterState(@Nonnull container: GameContainer, @Nonnull nifty: Nifty) {
        loadingManager.enlistMissingComponents(container.engine)
        nifty.gotoScreen("loading")
    }

    @Override
    override fun leaveState(@Nonnull container: GameContainer) {
    }
}
