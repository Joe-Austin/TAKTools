package net.joeaustin.taktools

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.stage.Stage

class MainApplication() : Application() {

    override fun start(primaryStage: Stage?) {
        val loader = FXMLLoader(javaClass.classLoader.getResource("fxml/MainView.fxml"))
        val root = loader.load<Parent>()

        val stage = Stage()
        stage.title = "TAK Tools"
        stage.scene = Scene(root, 800.0, 600.0)
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(MainApplication::class.java, *args)
        }
    }
}