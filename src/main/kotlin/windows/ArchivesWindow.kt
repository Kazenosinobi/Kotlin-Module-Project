package windows

import menu.MenuOfArchives
import menu_interface.Methods
import model.Archive
import java.util.Scanner

class ArchivesWindow : Methods {
    private val scanner = Scanner(System.`in`)
    private var choice = 0
    private val menuOfArchive = MenuOfArchives
    private val notesWindow = NotesWindow()
    private val listOfArchive = mutableListOf<Archive>()
    fun start() {
        showWindow()
        while (isClose()) {
            println("Введите значение")
            choice = scanner.nextInt()
            scanner.nextLine()
//            if (scanner.hasNextInt() && choice >= 0 && choice <= 2) {
            when (choice) {
                0 -> create()
                1 -> open(choice)
                2 -> close()
            }
//            } else {
//                println("Введите числовое значение от 0 до 2")
//                scanner.nextLine()
//            }
//            scanner.close()
        }
    }

    override fun create() {
        println("Введите название архива")
        val nameOfNote: String = scanner.nextLine()
        listOfArchive.add(Archive(nameOfNote, notesWindow.listOfNotes))
        menuOfArchive.menuOfArchives.add(nameOfNote)
        for (element in menuOfArchive.menuOfArchives) {
            if (element == "Выход") {
                menuOfArchive.menuOfArchives.remove(element)
            }
        }
        menuOfArchive.menuOfArchives.add("Выход")
        showWindow()
    }

    override fun open(number: Int) = notesWindow.start()

    override fun close() {
        return
    }

    override fun isClose() = choice == 0

    override fun showWindow() {
        println("Список архивов:")
        for (i in menuOfArchive.menuOfArchives.indices) {
            println("$i. ${menuOfArchive.menuOfArchives[i]}")
        }
    }
}