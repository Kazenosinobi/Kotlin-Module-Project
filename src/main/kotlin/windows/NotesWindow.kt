package windows

import menu.MenuOfNotes
import menu_interface.Methods
import model.Note
import java.util.Scanner

class NotesWindow : Methods {
    private val scanner = Scanner(System.`in`)
    var listOfNotes = mutableListOf<Note>()
    private var choice = 0
    private val menuOfNotes = MenuOfNotes
    private val archivesWindow = ArchivesWindow()
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
            //               scanner.nextLine()
            //           }
//            scanner.close()
        }
    }

    override fun create() {
//        do {
        println("Введите название заметки")
        val nameOfNote: String = scanner.nextLine()
        println("Введите текст заметки")
        val textOfNote: String = scanner.nextLine()
        listOfNotes.add(Note(nameOfNote, textOfNote))
        menuOfNotes.menuOfNotes.add(nameOfNote)
        for (element in menuOfNotes.menuOfNotes) {
            if (element == "Выход") {
                menuOfNotes.menuOfNotes.remove(element)
            }
        }
        menuOfNotes.menuOfNotes.add("Выход")
        showWindow()
//            scanner.close()
//        } while (nameOfNote.isEmpty() && textOfNote.isEmpty())
    }

    override fun open(choice: Int) {
        var value = 0
        println("Заметка:\n0 - Для просмотра заметки\n1 - Для возвращения на предыдущий экран")
        value = scanner.nextInt()
        scanner.nextLine()
        if (listOfNotes.isNotEmpty()) {
            when (value) {
                0 -> println(listOfNotes[choice - 1].value)
                else -> showWindow()
            }

        }
    }

    override fun close() {
        archivesWindow.showWindow()
    }

    override fun isClose() = choice == 0

    override fun showWindow() {
        println("Список заметок:")
        for (i in menuOfNotes.menuOfNotes.indices) {
            println("$i. ${menuOfNotes.menuOfNotes[i]}")
        }
    }


}