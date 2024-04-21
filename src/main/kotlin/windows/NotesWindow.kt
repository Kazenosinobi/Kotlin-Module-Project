package windows

import menu.MenuWindow
import model.Archive
import model.Note
import java.util.Scanner

class NotesWindow(private val archive: Archive) : MenuWindow() {
    override val menuOptions = mutableListOf("Создать заметку")
    override val scanner = Scanner(System.`in`)

    init {
        menuOptions.addAll(archive.notes.map { it.nameOfNote })
    }

    override fun handleSelection(index: Int) {
        when (index) {
            0 -> createNote()
            in 1 until menuOptions.size -> viewNote(archive.notes[index - 1])
        }
    }

    private fun createNote() {
        var nameOfNote = ""
        while (nameOfNote.isBlank()) {
            println("Введите название заметки:")
            nameOfNote = scanner.nextLine().trim()
        }
        if (nameOfNote.isBlank()) {
            println("Пожалуйста, введите имя заметки")
        }
        var textOfNote = ""
        while (textOfNote.isBlank()) {
            println("Введите текст заметки:")
            textOfNote = scanner.nextLine().trim()
        }
        val newNote = Note(nameOfNote, textOfNote)
        archive.notes.add(newNote)
        menuOptions.add(menuOptions.size, nameOfNote)
    }

    private fun viewNote(note: Note) {
        println("Заметка: ${note.nameOfNote}\n${note.value}")
    }
}