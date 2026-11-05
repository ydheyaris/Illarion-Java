package illarion.client

import com.badlogic.gdx.Game
import com.badlogic.gdx.Screen
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import illarion.client.screens.LoadingScreen

class GameWindow(private val loadingScreen: LoadingScreen): Game() {
    override fun getScreen(): Screen? = loadingScreen
    override fun setScreen(screen: Screen?) {}
    override fun create() {}
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //TODO: Screensize
            val config = Lwjgl3ApplicationConfiguration()
            config.setWindowedMode(800, 600)
            Lwjgl3Application(GameWindow(LoadingScreen()), config)
        }
    }
}