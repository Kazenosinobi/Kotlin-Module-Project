package windows

import menu.MenuWindow
import model.Archive
import java.util.Scanner


class ArchivesWindow : MenuWindow() {
    private val listOfArchive = mutableListOf<Archive>()
    override val menuOptions = mutableListOf("Создать архив")
    override val scanner = Scanner(System.`in`)

    override fun handleSelection(index: Int) {
        when (index) {
            0 -> createArchive()
            in 1 until menuOptions.size -> NotesWindow(listOfArchive[index - 1]).start()
        }
    }

    private fun createArchive() {
        var archiveName = ""
        while (archiveName.isBlank()) {
            println("Введите название архива:")
            archiveName = scanner.nextLine().trim()
        }
        val newArchive = Archive(archiveName)
        listOfArchive.add(newArchive)
        menuOptions.add(menuOptions.size, archiveName)

    }
}