package com.android.mctimkato.notekeeper.database

/**
 * An entity that represents a note in the database
 * @param id is an int that is  autoincremented and represents the unique id of each note
 * @param courseId foreign key used to look up a course title in the [Course] entity in the database
 * @param module string representing  module
 * @param summary represents  a summary of the module the user has watched
 * */
data class Note(
    //TODO:1. Make id primary key
    val id: Int,
    //TODO:2.  Make courseId foreign key
    val courseId: String,
    val summary: String
)

/**
 * Represents a course entity in the database
 * @param id is a unique id of the course entity
 * @param name is title of the course
 **/
data class Course(
    //TODO:3. Make id primary key
    val id: String,
    //TODO:4. Make moduleId a foreign key
    val moduleId: String,
    val name: String
)

data class Module(
    //TODO: 5. make id primary key
    val id: String,
    val name: String
)
