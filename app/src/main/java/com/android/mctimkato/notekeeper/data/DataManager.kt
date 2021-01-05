package com.android.mctimkato.notekeeper.data

import androidx.lifecycle.liveData

/**Contains variables to store app data
 * and methods to access, manipulate and manage app data */
object DataManager {
    var courses = HashMap<String, CourseInfo>()

    //stores mutable list of notes
    private var notesList = mutableListOf<NoteInfo>()

    /**
     * Returns  immutable list of all notes in the data store*/
    fun getAllNotes() = liveData {
        emit(notesList as List<NoteInfo>)
    }

    /*
    *Returns a note at a given position
    * */
    fun get(index: Int): NoteInfo {
        return notesList[index]
    }

    //adds a note to an existing list
    fun insert(note: NoteInfo): Int {
        notesList.add(note)
        return notesList.lastIndexOf(note)
    }

    /*Deletes a note form list*/
    fun delete(note: NoteInfo) {
        val index = notesList.indexOf(note)
        notesList.removeAt(index)
    }

    /**
     * Modifies content of an existing note*/
    fun update(index: Int, newNote: NoteInfo) {
        if (notesList[index] != newNote) {
            notesList[index] = newNote
        }
    }

    init {
        initializeCourses()
        initializeNotes()
    }

    //adds a course to courses map
    private fun addCourse(courseId: String, title: String) {
        courses[courseId] = CourseInfo(courseId, title)
    }

    /*
    * Initialise courses list*/
    private fun initializeCourses() {
        addCourse("android_intents", "Android Programming with intents")
        addCourse("android_async", "Android Async programming with services")
        addCourse(title = "Java Fundamentals: The Java language", courseId = "java_lang")
        addCourse("java_core", "Java Fundamentals: The Core Platform")
    }

    //adds a note to an notes array list
    private fun addNote(courseId: String, title: String, text: String) {
        val note = NoteInfo(courses[courseId], title, text)
        notesList.add(note)
    }

    /**
     * Populates notes list with initial data*/
    private fun initializeNotes() {
        addNote(
            "android_intents",
            "Dynamic intent resolution",
            "Wow, intents allow components to be resolved at runtime"
        )

        addNote(
            "android_intents", "Delegating intents", "PendingIntents are powerful; they " +
                    "delegate much more than just a component invocation"
        )

        addNote(
            "android_async",
            "Service default",
            "Did you know that by default and Android Service will tie up the UI thread?"
        )

        addNote("java_lang", "Parameters", "Leverage variable-length parameter lists")

        addNote("java_core", "Compiler options", "Remember to include Serialization")
    }
}