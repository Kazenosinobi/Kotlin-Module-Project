package model

data class Archive(val nameOfArch: String, val notes: MutableList<Note> = mutableListOf())
