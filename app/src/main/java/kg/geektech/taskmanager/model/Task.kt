package kg.geektech.taskmanager.model

import java.io.Serializable

data class Task(
    var title: String? = null,
    var desc: String? = null,
) : Serializable
