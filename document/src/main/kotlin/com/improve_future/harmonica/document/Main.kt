package com.improve_future.harmonica.document

import com.improve_future.harmonica.document.view.HarmonicaView
import com.improve_future.harmonica.document.view.JarmonicaView
import com.improve_future.harmonica.document.view.TopView
import com.improve_future.harmonica.document.view.ViewInterface
import java.io.*
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.use

object Main {
    private val sitePath = Paths.get("..", "docs", "site").toRealPath()!!

    @JvmStatic
    fun main(vararg args: String) {
        arrayOf(TopView, JarmonicaView, HarmonicaView).forEach {
            outputFile(it)
        }
    }

    private fun outputFile(view: ViewInterface) {
        val file = File(Paths.get(sitePath.toString(), view.path).toString())
        FileWriter(file).use { it.write(view.index()) }
        println("Output " + view.path + ".")
    }
}