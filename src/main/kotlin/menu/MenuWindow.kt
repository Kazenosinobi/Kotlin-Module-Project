package menu

import java.util.Scanner

abstract class MenuWindow() {
    protected abstract val menuOptions: MutableList<String>
    protected abstract fun handleSelection(index: Int)
    protected open val scanner = Scanner(System.`in`)

    fun start() {
        var running = true
        while (running) {
            showMenu()
            println("Введите значение (или ${menuOptions.size} для выхода):")
            try {
                val choice = scanner.nextInt()
                scanner.nextLine()
                if (choice >= 0 && choice < menuOptions.size) {
                    handleSelection(choice)
                } else if (choice == menuOptions.size) {
                    running = false
                } else {
                    println("Введите числовое значение из представленного диапазона.")
                }
            } catch (e: Exception) {
                println("Необходимо ввести числовое значение")
                scanner.nextLine()
            }
        }
    }

    private fun showMenu() {
        menuOptions.forEachIndexed { index, option ->
            println("$index. $option")
        }
        println("${menuOptions.size}. Выход")
    }
}
