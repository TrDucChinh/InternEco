package com.eco.interneco.task2.models

enum class TypeMagazine {
    NATURAL_SCIENCE,
    SOCIAL_SCIENCE,
    TECHNOLOGY,
    OTHER,
}

data class Magazine(
    override val id: Long,
    override val name: String,
    override val publishDate: String,
    override val borrowed: Boolean,
    val type: TypeMagazine,
    val publisher: String,
    val issueNumber: Int,
) : LibraryItem(id, name, publishDate, borrowed) {
    override fun getItemType(): String {
        return TypeLibraryItem.MAGAZINE.name
    }

    override fun getItemDetails(): String {
        return "Type: $type | Publisher: $publisher | Issue number: $issueNumber"
    }

    override fun getDisplayInfo(): String {
        return ""
    }

    override fun toString(): String {
        return "id: $id |" +
                "name : $name | " +
                "author : $publisher | " +
                "publishDate : $publishDate | " +
                "type : $type | " +
                "issueNumber : $issueNumber | " +
                "borrowed : ${if (borrowed) "Yes" else "No"}\n"
    }
}